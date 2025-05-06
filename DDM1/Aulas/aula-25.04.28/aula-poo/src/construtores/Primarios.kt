package construtores

open class Button(val label: String)

class RadioButton(label: String) : Button(label)

fun main() {
    val radio = RadioButton("Pix")
    println(radio.label)
}