package operators

data class Snack(
    val id: String,
    val name: String,
    val price: Double,
) {

    operator fun minus(price: Double): Snack {
        return copy(
            price = this.price - price,
        )
    }

    // TODO: 1. overload the [plus], [multiply], and [div] and calculate the price as the example above
}

class Cashier {

    operator fun invoke(item: Snack) {
        println(
            message = """
                =================================================
                            Your item is ${item.name}.
                    And the total payment will be ${item.price}
                =================== Thank You ===================
            """.trimIndent(),
        )
    }
}

fun main() {
    val cashier = Cashier()
    val mySnack = Snack(
        id = "q",
        name = "Q-tela",
        price = 100.0,
    )

    cashier(
        item = mySnack - 25.0,
    )
//    cashier(
//        item = mySnack + 25.0,
//    )
//    cashier(
//        item = mySnack * 25.0,
//    )
//    cashier(
//        item = mySnack / 25.0,
//    )
}