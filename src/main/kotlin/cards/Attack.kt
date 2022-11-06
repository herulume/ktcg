package cards

data class Attack(
    val name: String,
    val cost: List<PowerType>,
    val damage: Points
)

sealed interface EnoughPowerResult

object EnoughPower: EnoughPowerResult

data class MissingPower(
    val cost: List<PowerType>
): EnoughPowerResult

fun Attack.enoughPower(cards: List<Card>): EnoughPowerResult =
    cards.filterIsInstance<PowerCard>().let { TODO() }
