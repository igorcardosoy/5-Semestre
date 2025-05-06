open class Veiculo(private val placa: String) {
    open fun mover(){
        println("O veículo $placa está se movendo.")
    }

    fun parar(){
        println("$placa parou.")
    }
}

class Onibus(private val placa: String): Veiculo(placa){
    override fun mover(){
        println("O onibus $placa está se movendo.")
    }
}

class Carro(private val placa: String): Veiculo(placa){
    override fun mover(){
        println("O carro $placa está se movendo.")
    }
}

fun main() {
    val veiculo = Veiculo("V-01")
    veiculo.mover()

    val onibus: Veiculo = Onibus("O-01")
    onibus.mover()

    val carro: Veiculo = Carro("C-01")
    carro.mover()
}