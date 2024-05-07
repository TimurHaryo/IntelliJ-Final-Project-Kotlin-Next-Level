package generics.model

data class Tea(
    override val isCold: Boolean,
    val teaLeafName: String,
    val teaColor: String,
) : Beverages {

    override fun drink() {
        println("Enjoy your tea")
    }
}
