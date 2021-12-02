package com.example.codenames

class Game {

    var colorMap = listOf<Int>()
    var wordMap = listOf<Int>()
    var redFirst = true
    var isLeading = true
    val visibleWord = mutableListOf(
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true,
        true
    )

    companion object {

        var game: Game? = null

        fun getInstance(): Game? {
            if (game == null) {
                game = Game()
            }
            return game
        }

        fun getInstance(newInstance: Boolean): Game? {
            if (game == null || newInstance) {
                game = Game()
                game?.colorMap = MathematicalOperations.createColorMap()
                game?.wordMap = MathematicalOperations.createWordMap(Dictionary.dictionary.size)
            }
            return game
        }
    }

    fun generateKey(): String{
        val wordMapKey = wordMap.map { val a= MathematicalOperations.decimalToSixtyTwo(it)
            if(a.length>1) a else "0$a"}.joinToString("")
        val colorMapKey = MathematicalOperations.quaternaryToSixtyTwo(colorMap.joinToString(""))

        val key = Dictionary.numberDictionary.toString() + if(redFirst) "1" else {"0"} + wordMapKey + colorMapKey
        return key
    }


}