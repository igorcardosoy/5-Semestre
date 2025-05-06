package exercicios

fun transformar(text: String, transformer: (String) -> String): String {
    return transformer(text)
}

fun main(){
    println(transformar("texto", { str -> str.uppercase()}))

    println(transformar("texto") { str -> str[0].toString()})

    println(transformar("texto") { it[2].toString()})
}