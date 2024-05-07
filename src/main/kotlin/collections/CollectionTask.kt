package collections

import collections.model.Product
import collections.model.ProductType
import collections.util.ProductConstants.purchasedProducts

fun main() {
    val filteredProductByType = filterProductByType(
        productType = ProductType.FOOD,
    )
    val filteredProductByPrice = filterProductByPriceRange(
        minPrice = 5.0,
        maxPrice = 10.0,
    )
    val expensiveProduct = findHighestProductPrice()
    val cheapProduct = findLowestProductPrice()
    val productNames = getUppercaseProductNames()
    val totalPrice = calculateTotalPrice()
    val groupedByType = countProductEachType()
    val (type, quantity) = findLargestQuantityProductType()

    println(
        message = """
            1. filteredProductByType: $filteredProductByType
            2. filteredProductByPrice: $filteredProductByPrice
            3. expensiveProduct: $expensiveProduct
            4. cheapProduct: $cheapProduct
            5. productNames: $productNames
            6. totalPrice: $totalPrice
            7. groupedByType: $groupedByType
            8. findLargestQuantityProductType: $type has $quantity product(s)
        """.trimIndent()
    )
}

private fun filterProductByType(productType: ProductType): List<Product> {
    // TODO: return list of product with given type only
    return purchasedProducts
        .filter {
            it.category == productType
        }
}

private fun filterProductByPriceRange(
    minPrice: Double,
    maxPrice: Double,
): List<Product> {
    // TODO: return list of product with its price is between minPrice and maxPrice
    return purchasedProducts
        .filter {
            it.price in minPrice..maxPrice
        }
}

private fun findHighestProductPrice(): Product? {
    // TODO: return a single product which its price is the highest among the others
    return purchasedProducts.maxByOrNull { it.price }
}

private fun findLowestProductPrice(): Product? {
    // TODO: return a single product which its price is the lowest among the others
    return purchasedProducts.minByOrNull { it.price }
}

private fun getUppercaseProductNames(): List<String> {
    // TODO: return list of product name in uppercase. you should convert list of product into list of string
    return purchasedProducts
        .map { it.name.uppercase() }
}

private fun calculateTotalPrice(): Double {
    // TODO: return sum of all product price
    return purchasedProducts
        .sumOf {
            it.price
        }
}

private fun countProductEachType(): Map<ProductType, Int> {
    /**
     * TODO: return map of product type with its number of product.
     * @sample: {FOOD=2, ELECTRONIC=1, CLOTHES=1, BEVERAGE=1}
     * */
    return purchasedProducts
        .groupBy {
            it.category
        }
        .mapValues {
            it.value.count()
        }
}

private fun findLargestQuantityProductType(): Pair<ProductType, Int> {
    /**
     * TODO: return pair of product type and its quantity with largest quantity.
     * */
    return countProductEachType()
        .maxBy {
            it.value
        }
        .toPair()
}