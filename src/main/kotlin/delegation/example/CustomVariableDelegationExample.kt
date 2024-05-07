package delegation.example

import kotlin.reflect.KProperty

class MyCustomLazy<T>(val initializer: () -> T) {
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (value == null) {
            value = initializer()
        }
        return value!!
    }
}

class Settings {
    // Example of delegation in variable
    val apiKey by MyCustomLazy {
        println("Loading API key from file...")
        "your_api_key"
    }
}

fun main() {
    val settings = Settings()
    println("API Key: ${settings.apiKey}")
}