package cards

sealed interface PowerType

object AsteriskType: PowerType

enum class ElementalType: PowerType {
    FIRE, WATER, AIR, GROUND
}
