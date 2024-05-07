package generics.model

data class Coffee(
    override val isCold: Boolean,
    val coffeeType: String,
) : Beverages {

    override fun drink() {
        println("Yummy coffee")
    }
}
