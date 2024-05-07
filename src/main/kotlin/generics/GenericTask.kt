package generics

import generics.model.Bread
import generics.model.Cereal
import generics.model.Coffee
import generics.model.Tea

/**
 * TODO: change this class into generic class.
 *
 * For now this class only can handle [String]. adjust this class to be able to
 * handle any data types.
 * */
class Stack {
    private val items = mutableListOf<String>()

    fun push(item: String) {
        items.add(item)
    }

    fun pop(): String? {
        return if (items.isEmpty()) null else items.removeAt(items.lastIndex)
    }

    fun peek(): String? {
        return items.lastOrNull()
    }
}

fun main() {
    val stringStack = Stack()
    stringStack.push("Hello 1")
    stringStack.push("Hello 2")
    println("stringStack -> ${stringStack.peek()}")

//    println("==============================================")
//    val intStack = Stack()
//    intStack.push(11)
//    intStack.push(22)
//    println("intStack -> ${intStack.peek()}")
//
//    println("==============================================")
//    val foodStack = Stack()
//    foodStack.push(
//        item = Bread(
//            discount = 0.2,
//            taste = "sweet",
//        ),
//    )
//    foodStack.push(
//        item = Cereal(
//            discount = 0.2,
//            isLessSugar = true,
//        ),
//    )
//    println("foodStack -> ${foodStack.peek()}")
//
//    println("==============================================")
//    val beverageStack = Stack()
//    beverageStack.push(
//        item = Coffee(
//            isCold = true,
//            coffeeType = "v60",
//        ),
//    )
//    beverageStack.push(
//        item = Tea(
//            isCold = true,
//            teaLeafName = "cukurukuk",
//            teaColor = "purple",
//        ),
//    )
//    println("beverageStack -> ${beverageStack.peek()}")
}