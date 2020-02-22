package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    fun String.getRights(s: String): Int {
        var rights = 0
        for ((index, character) in this.withIndex()) {
            if (s[index] == character) rights++
        }

        return rights
    }

    fun String.getWrongs(s: String): Int {
        val sA = mutableListOf<Char>()
        val sG = mutableListOf<Char>()
        for ((index, character) in this.withIndex()) {
            if (s[index] != character) {
                sA.add(character)
                sG.add(s[index])
            }
        }

        var wrongs = 0
        for (element in sA) {
            if (element in sG) {
                sG.remove(element)
                wrongs++
            }
        }

        return wrongs
    }

    return Evaluation(secret.getRights(guess), secret.getWrongs(guess))
}