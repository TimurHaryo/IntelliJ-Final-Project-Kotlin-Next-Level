package sealedclass

sealed class LoginEvent {
    data class OnForgetPassword(val username: String) : LoginEvent()
    data object OnCustomerService : LoginEvent()
    // TODO: 1. add as much events as you like about Login.
    // e.g Login With Email, Login With Number, Sign Up, or anything else
}

private fun handleEvent(event: LoginEvent) {
    // TODO: 2. use switch case to handle event type. Handle as you like. Have fun :)
}

fun main() {
    // Test your code here
    val userEvent = LoginEvent.OnForgetPassword(
        username = "badumtess",
    )
    handleEvent(
        event = userEvent,
    )
}