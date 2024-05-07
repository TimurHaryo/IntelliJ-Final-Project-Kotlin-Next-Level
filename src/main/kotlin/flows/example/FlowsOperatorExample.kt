package flows.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val stockPrices = getLivePrice()

        stockPrices
            .filter { price ->
                price in 105.0..118.0 // Filter for prices between 105 and 118
            }
            .map { price ->
                "$${String.format("%.2f", price)}" // Format price with 2 decimals
            }
            .collect { price ->
                println(price)
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
