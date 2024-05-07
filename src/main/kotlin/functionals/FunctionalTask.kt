package functionals

import functionals.model.Person

// TODO: type aliases goes here

fun main() {
    val simpleman = Person(
        "Simpleman99",
        18,
    )
    val jordan = Person(
        "Jordan Montemuro",
        16,
    )
    val rowan = Person(
        "Rowan",
        18,
    )

    // TODO: call your function here to test the result. you can use person variables above to check
}

/**
 * TODO: 1. change all of these below functions into kotlin extension functions
 *
 * @sample:
 *  > Before:
 *      fun hasValidName(person: Person): Boolean {
 *          return person.name.all { it.isLetter() }
 *      }
 *  > After:
 *      fun Person.hasValidName(): Boolean {
 *  *       return name.all { it.isLetter() }
 *  *   }
 * */

fun hasValidName(person: Person): Boolean {
    return person.name.all { it.isLetter() }
}

fun ableToCreateDrivingLicense(person: Person): Boolean {
    return person.age >= 17
}

fun getFirstName(person: Person): String {
    return person.name.split(" ").first()
}

/**
 * TODO: 2. create type aliases from below functions. AND remember, create type aliases
 * when it really necessary
 * */
inline fun talkWithPerson(
    firstName: String,
    block: () -> Unit,
) {
    println("Hello, $firstName")
    block()
}

fun administrationCheck(
    person: Person,
    onValid: () -> Unit,
    onInvalid: () -> Unit,
) {
    val isValidAge = ableToCreateDrivingLicense(person)
    val isValidName = hasValidName(person)
    if (isValidAge && isValidName) {
        onValid()
        return
    }

    onInvalid()
}