package generics.example

import generics.model.Bread
import generics.model.Food

fun <T : Food> T.instantEat(lambda: (T) -> Unit) {
    println("Your food is: $this")
    lambda(this)
}

fun <T> calculateAverage(numbers: List<T>): Double where T : Number, T : Comparable<T> {
    if (numbers.isEmpty()) return 0.0
    val sum = numbers.sumOf { it.toDouble() }
    return sum / numbers.size
}

fun main() {
    val myBread = Bread(
        discount = 0.2,
        taste = "sour",
    )
    val average = calculateAverage(listOf(4,3,2,5,3))

    myBread.instantEat {
        println("So good")
    }

    println("The average is $average")
}