package exceptions

fun main() {
    try {
        print("Input your age: ")
        val age = readln().toInt()
        val maxAge = 150
        if (age >= maxAge) {
            /**
             * TODO: throw [IllegalArgumentException] exception if age more than equal maxAge
             */
        }
        println("Your age is: $age")
    } catch (numberExc: NumberFormatException) {
        println("Sorry age must be a number")
    } catch (illegalExc: IllegalArgumentException) {
        println(illegalExc.message)
    } finally {
        println("Thank you")
    }
}