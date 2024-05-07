package delegation

import delegation.util.DelegationConstants.activeAccounts
import kotlin.properties.Delegates

/**
 * TODO: 1. implement this [Logger] class into [Account] using kotlin delegation
 * */
interface Logger {

    fun info(message: String)

    fun error(message: String)
}

class LoggerImpl : Logger {

    override fun info(message: String) {
        println(
            message = "INFO | $message",
        )
    }

    override fun error(message: String) {
        println(
            message = "ERROR | $message",
        )
    }
}

/**
 * TODO: 2. implement this [Validator] class into [Account] using kotlin delegation
 * */
interface Validator {

    fun isAccountActive(username: String): Boolean
}

/**
 * TODO: 3. complete this [ValidatorImpl] by implementing [Validator].
 * This class should check if certain username is active or not by following condition:
 * - IF username is in [activeAccounts], then ACTIVE
 * - IF username is NOT in [activeAccounts], then NOT ACTIVE
 * */
class ValidatorImpl(
    private val activeAccounts: List<String>
) {

}

class Account(
    activeAccounts: List<String>,
) {
    /**
     * TODO: 4. using [Delegates.vetoable], make this [name] only received valid name.
     * Valid name has condition as below:
     * - all characters/string should be letter OR empty string
     * */
    var name: String = ""

    /**
     * TODO: 5. this [closeAccount] will do following task:
     * - check if [Validator.isAccountActive] is TRUE or FALSE
     * - if [Validator.isAccountActive] TRUE, then set [name] to empty string and use [Logger.info]
     * - if [Validator.isAccountActive] FALSE, use [Logger.error] only
     * */
    fun closeAccount() {

    }
}

fun main() {
    val validName = "simpleman" // change this value as you like
    val invalidName = "wawa12"
    val accounts = activeAccounts
    val account = Account(accounts)

    account.name = validName
    account.name = invalidName

    account.closeAccount()
}