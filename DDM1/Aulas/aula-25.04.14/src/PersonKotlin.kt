class PersonKotlin(
    val name: String,
    var isStudent: Boolean
) {
    fun sayHello() {
        println("Oi! eu me chamo $name.")

        showStatus()
    }

    private fun showStatus() {
        if (isStudent) println("Sou estudante.")
        else println("Estou trabalhando.")
    }
}