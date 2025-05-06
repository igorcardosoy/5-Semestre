import kotlin.math.sqrt

abstract class Media {
    abstract fun calcular(x1: Double, x2: Double): Double

    companion object {
        fun geometrica(): Media {
            return Geometrica()
        }

        fun aritimetica(): Media {
            return Aritimetica()
        }
    }

    private class Aritimetica : Media() {
        override fun calcular(x1: Double, x2: Double): Double {
            return (x1 + x2) / 2
        }
    }

    private class Geometrica : Media() {
        override fun calcular(x1: Double, x2: Double): Double {
            return sqrt(x1 * x2) // or (x1 * x2).pow(1.0 / 2)
        }
    }
}


fun main() {
    var media = Media.geometrica()
    println("res = ${media.calcular(10.0, 2.0)}")

    media = Media.aritimetica()
    println("res = ${media.calcular(10.0, 8.0)}")
}