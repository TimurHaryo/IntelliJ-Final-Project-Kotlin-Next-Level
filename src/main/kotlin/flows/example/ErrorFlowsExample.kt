package flows.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val stockPrices = getLivePriceWithError()

        stockPrices
            .catch { e ->
                println("Error: ${e.message}") // Handle exceptions
            }
            .collect { price ->
                println("Current stock price: $$price")
            }
    }
}

private suspend fun getLivePriceWithError() = flow {
    repeat(20) {
        val price = Random.nextDouble(-10.0, 10.0)
        delay(2000)
        if (price < 0.0) {
            throw Exception("Error fetching negative price") // Simulate occasional error and terminate the flow
        }
        emit(price)
    }
}
