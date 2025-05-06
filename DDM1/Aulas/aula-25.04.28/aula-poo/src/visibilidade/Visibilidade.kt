package visibilidade

class Robo {
    private val modelo = "T800"

    private fun agir(){
        println("$modelo agindo!")
    }

    fun getModelo(): String = this.modelo
}

fun main(){
    val robo = Robo()
    // println(robo.modelo)
    // robo.agir()
    println(robo.getModelo())
}