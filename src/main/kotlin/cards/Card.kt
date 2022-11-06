package cards

sealed interface Card

fun <R> Card.fold(
    monster: (String, String, Points, List<Attack>) -> R,
    regularPower: (ElementalType) -> R,
    extendedPower: (PowerType, Boolean) -> R
): R = when (this) {
    is MonsterCard -> monster(id, name, body, attacks)
    is RegularPowerCard -> regularPower(type)
    is ExtendedPowerCard -> extendedPower(type, lastsOneTurn)
}

data class MonsterCard(
    val id: String,
    val name: String,
    val body: Points,
    val attacks: List<Attack>
): Card

fun MonsterCard.duplicateBody() = this.copy(body = body * Points(2))
// This sucks
fun MonsterCard.duplicateAttacks() = this.copy(
    attacks = attacks.map { attack ->
        attack.copy(damage = attack.damage * Points(2))
    }
)

sealed interface PowerCard: Card
data class RegularPowerCard(val type: ElementalType): PowerCard
data class ExtendedPowerCard(val type: PowerType, val lastsOneTurn: Boolean): PowerCard
