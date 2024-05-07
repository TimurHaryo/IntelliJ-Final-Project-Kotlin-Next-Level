package delegation.example

import kotlin.properties.Delegates

class User {
    val name: String by lazy {
        println("Initializing user name...")
        "John Doe"
    }

    var age: Int by Delegates.vetoable(0) { _, oldValue, newValue ->
        newValue in (oldValue + 1)..100
    }

    fun addAgeBy(additionalAge: Int) {
        age += additionalAge
    }

    fun reduceAgeBy(reducedAge: Int) {
        age -= reducedAge
    }
}

fun main() {
    val user = User()
    user.addAgeBy(10)
    user.addAgeBy(20)
    user.reduceAgeBy(20)

    println(user.name)
    println("User age is: ${user.age}")
}