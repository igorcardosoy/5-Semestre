fun exectuar(f: () -> Unit){
    f()
}

fun main() {
    exectuar { println("Oloco!") }
}