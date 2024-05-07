package flows.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val stockPrices = getLivePrice()

        stockPrices.collect { price ->
            println("Current stock price: $$price")
        }
    }
}

private suspend fun getLivePrice() = flow {
    repeat(20) {
        val price = Random.nextDouble(100.0, 120.0)
        delay(2000)
        emit(price)
    }
}
