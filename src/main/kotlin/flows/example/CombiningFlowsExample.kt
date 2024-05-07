package flows.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    combiningFlow()
    zipFlow()
}

private fun combiningFlow() {
    runBlocking {
        val stockPrices = getLivePrice()
        val timestamps = getLiveTimeStamp()

        // Concatenate flows (stock prices followed by timestamps)
        val combinedFlow = channelFlow {
            launch {
                stockPrices.collect { send(it) }
            }
            launch {
                timestamps.collect { send(it) }
            }
        }
        combinedFlow
            .collect { data ->
                println(data) // Print each emitted element
            }
    }
}

private fun zipFlow() {
    runBlocking {
        val stockPrices = getLivePrice()
        val timestamps = getLiveTimeStamp()

        // Zip flows to combine stock price with corresponding timestamp
        val priceWithTime = stockPrices.zip(timestamps) { price, timestamp ->
            "[$timestamp] - $$price"
        }

        priceWithTime.collect { data ->
            println(data)
        }
    }
}

private suspend fun getLivePrice() = flow {
    repeat(10) {
        val price = Random.nextDouble(100.0, 120.0)
        delay(3000)
        emit(price)
    }
}

private suspend fun getLiveTimeStamp() = flow {
    var time = 0L
    repeat(10) {
        delay(500)
        emit(time)
        time += 1000
    }
}
