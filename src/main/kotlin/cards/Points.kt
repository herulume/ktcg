package cards

@JvmInline
value class Points(private val points: Int) {
    init { require(points > 0) }

    operator fun plus(other: Points) =
        Points(this.points + other.points)

    operator fun times(other: Points) =
        Points(this.points * other.points)
}
