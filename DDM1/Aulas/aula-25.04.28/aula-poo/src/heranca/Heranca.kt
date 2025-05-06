package heranca

open class Animal {
    open fun sayHello() {
        println("Hello, i am a animal!")
    }

    fun eat() {
        println("I am a animal eating!")
    }
}

class Horse : Animal() {
    override fun sayHello() {
        println("I am a Horse!")
    }
}

fun main() {
    val animal: Animal = Animal()
    val horse: Animal = Horse()

    animal.sayHello()
    animal.eat()

    horse.sayHello()
    animal.eat()
}