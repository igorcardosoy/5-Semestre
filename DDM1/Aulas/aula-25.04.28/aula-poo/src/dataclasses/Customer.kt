package dataclasses

data class Customer(val name: String, val id: Int)

fun main() {
    val customer = Customer("Oriza", 1)
    println(customer.toString())
}