package exercicios.exer2

class Livro (
    val titulo: String,
    val autor: String,
    val anoPublicacao: String,
    var estaEmprestado: Boolean,

) {

    val descricao: String
        get() = "$titulo ($anoPublicacao), de $autor. ${if (estaEmprestado) "Disponível para empréstimo" else "tualmente emprestado"}."

    fun emprestar(){
        if (!estaEmprestado) estaEmprestado = true
    }

    fun devolver(){
        if (estaEmprestado) estaEmprestado = false
    }
}