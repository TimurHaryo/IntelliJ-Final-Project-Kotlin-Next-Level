package generics.model

data class Cereal(
    override val discount: Double,
    val isLessSugar: Boolean,
) : Food {

    override fun eat() {
        println("Cereal to start your day fammm")
    }
}
