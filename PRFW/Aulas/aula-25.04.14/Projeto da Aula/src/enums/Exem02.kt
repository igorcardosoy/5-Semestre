package enums

enum class ColorRGB(
    val r: Int,
    val g: Int,
    val b: Int,
    val colorName: String
) {
    RED(255, 0, 0, "Vermelho"),
    GREEN(0, 255, 0, "Verde"),
    BLUE(0, 0, 255, "Azul");

    fun print() = println("($r, $g, $b)")
}

fun getColorName(colorRGB: ColorRGB): String =
    when (colorRGB) {
        ColorRGB.RED -> "Vermelho"
        ColorRGB.BLUE -> "Azul"
        ColorRGB.GREEN -> "Verde"
    }

fun main() {
    val colorRGB = ColorRGB.RED
    colorRGB.print()
    //println(colorRGB.colorName)
    println(getColorName(colorRGB))
}