package interfaces

interface Clickable {
    fun click()

    fun show() {
        println("I'm clickable!")
    }
}

class Button : Clickable {
    override fun click() {
        println("Got clicked!")
    }
}

fun main() {
    val button = Button()
    button.click()

    button.show()
}