package objects

class User {
    val username: String

    constructor(email: String) {
        this.username = email.substringBefore("@")
    }

    constructor(id: Int){
        this.username = getUsernameFor(id)
    }

    private fun getUsernameFor(id: Int): String {
        return "Hanzo"
    }

    companion object {
        fun fromEmail(email: String): User {
            return User(email)
        }

        fun fromId(id: Int): User {
            return User(id)
        }
    }
}

fun main() {
    val user1 = User("mercy@gmail.com")
    val user2 = User(1)
    println(user1.username)
    println(user2.username)

    val user3 = User.fromEmail("genji@gmail.com")
    val user4 = User.fromId(1)

    println(user3.username)
    println(user4.username)
}
