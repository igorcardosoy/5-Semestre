package construtores

class Customer {
    var name: String

    constructor(name: String?) {
        this.name = name ?: "Joe"
    }

    constructor() {
        this.name = "James"
    }

}

fun main() {
    val customers = listOf(
        Customer(null),
        Customer("Foo"),
        Customer("Querry"),
        Customer()
    )

//    for (c in customers) {
//        println(c.name)
//    }

    customers.forEach { println(it.name) }
}