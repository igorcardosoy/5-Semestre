fun main(){
    val personJava = PersonJava("Igor")
    println("Nome ${personJava.name}")

    val personKotlin = PersonKotlin("Igor Kotlin", true)
    println("Nome ${personKotlin.name}")

    println("Estudante: ${personKotlin.isStudent}")

    personKotlin.isStudent = false
    println("Estudante: ${personKotlin.isStudent}")

    personKotlin.sayHello()
}