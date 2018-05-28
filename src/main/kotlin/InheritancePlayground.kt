fun main(args: Array<String>) {

    println("PrivateUser: ${PrivateUser(nickname = "romerorr16@msn.com").nickname}")
    println("SubscribingUser: ${SubscribingUser("romerorr16@msn.com").nickname}")
    println("FacebookUser: ${FacebookUser(accountId = 987654321).nickname}")

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Romero")
    println("Romero is a word with ${lengthCounter.counter} characters")
}

interface User {
    val email: String?
    val nickname: String
        get() = email!!.substringBefore('@')
}

class PrivateUser(override val email: String? = null,
                  override val nickname: String) : User

class SubscribingUser (override val email: String) : User {

    override val nickname: String
    get() = email.substringBefore('@')
}

class FacebookUser(override val email: String = "0", accountId: Int) : User {
    override val nickname = Integer.toBinaryString(accountId)
}

class LengthCounter {
    var counter: Int = 0
    private set

    fun addWord(word: String) {
        counter += word.length
    }
}