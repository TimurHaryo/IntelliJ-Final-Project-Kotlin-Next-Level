package functionals.example

import functionals.model.Person
import java.util.Date
import functionals.util.FunctionalConstants.persons

fun main() {
    executeSomething {
        println("Hello from executeSomething")
    }

    executeInline {
        println("Hello from executeInline")
    }

    println("After")

    executeBlockWithReturnType {
        println()
        "Hello from executeBlockWithReturnType"
    }

    executeSomethingWithParameter(17) {
        println()
        println("I am ready to be success from executeSomethingWithParameter")
    }

    executeSomethingWithTwoHOF(
        age = 14,
        onAdult = {
            println()
            println("Let's success from executeSomethingWithTwoHOF")
        },
        onUnderAge = {
            println()
            println("No time to lose from executeSomethingWithTwoHOF")
        }
    )

    hofWithLambdaReceiver {
        println()
        println("current time stamp: $time")
    }

    hofWithLambdaArgument(
        personName = "Benny"
    ) { person, futureAge ->
        println()
        println(
            message = """
                Now ${person.name} is ${person.age} years old.
                And 5 year later her/his age should be $futureAge
            """.trimIndent()
        )
    }
}

private fun executeSomething(block: () -> Unit) {
    block()
}

private inline fun executeInline(block: () -> Unit) {
    block()
}

private fun executeBlockWithReturnType(block: () -> String) {
    println(block())
}

private fun executeSomethingWithParameter(
    age: Int,
    onAdult: () -> Unit,
) {
    if (age >= 17) {
        onAdult()
        return
    }

    println("Keep going on very young age!")
}

private fun executeSomethingWithTwoHOF(
    age: Int,
    onAdult: () -> Unit,
    onUnderAge: () -> Unit
) {
    if (age >= 17) {
        onAdult()
    } else {
        onUnderAge()
    }
}

private fun hofWithLambdaReceiver(lambda: Date.() -> Unit) {
    val date = Date()
    date.lambda()
}

private fun hofWithLambdaArgument(
    personName: String,
    lambda: (person: Person, futureAge: Int) -> Unit,
) {
    val personNames = persons.map { it.name }
    if (personName in personNames) {
        val person = persons.first { it.name == personName }
        lambda(
            person,
            person.age + 5,
        )
        return
    }

    println("$personName is not found")
}