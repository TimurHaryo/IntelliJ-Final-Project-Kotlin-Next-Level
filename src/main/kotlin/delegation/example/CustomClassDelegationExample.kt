package delegation.example

interface Logger {

    fun calmLog(message: String)

    fun rageLog(message: String)
}

class LoggerImpl : Logger {

    override fun calmLog(message: String) {
        println(message)
    }

    override fun rageLog(message: String) {
        println(
            message = "${message.uppercase()}!!!"
        )
    }
}

class Database : Logger by LoggerImpl() {
    var username: String = ""
        private set

    fun setName(name: String) {
        if (name.all { it.isLetter() }) {
            username = name
            calmLog("Success set name")
            return
        }

        rageLog("Fill with correct name")
    }
}

fun main() {
    val database = Database()
    val validName = "Guapo"
    val invalidName = "Jessie123"
    database.setName(invalidName)
    println("Saved name from database is: ${database.username}")
}