package objects

class MyClass {
    companion object {
        fun callMe(){
            println("Hello!")
        }
    }
}


fun main(){
    MyClass.callMe()
}