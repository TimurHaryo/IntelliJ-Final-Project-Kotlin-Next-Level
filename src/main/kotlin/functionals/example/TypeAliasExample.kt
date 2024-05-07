package functionals.example

private typealias PhoneNumber = String
private typealias BasicOnClick = () -> Unit

fun main() {
    val momPhoneNumber: String = "082338383838s"
    callFamily(
        number = momPhoneNumber
    ) {
        println("Ringing...")
    }
}

private inline fun callFamily(number: PhoneNumber, call: BasicOnClick) {
    if (number.all { it.isDigit() }) {
        call()
    } else {
        println("Phone number must be all number")
    }
}
