package exceptions

fun main() {
    val n = 89
    val percent =
        if (n in 1.. 100)
            n
        else
            throw  IllegalArgumentException()

    println(percent)
}