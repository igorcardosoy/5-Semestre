package exceptions

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader): Int? =
    try {
        val line = reader.readLine()
        Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        null
    } finally {
        reader.close()
    }


fun main() {
    val reader = BufferedReader(StringReader("1"))
    val num = readNumber(reader)

    println(num)
}