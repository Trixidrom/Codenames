package com.example.codenames

class Game {

    var colorMap = listOf<Int>()
    var wordMap = listOf<Int>()
    var dictionary: List<String>? = null
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
                game?.colorMap = MathematicalOperations.CreateColorMap()
                game?.wordMap = MathematicalOperations.CreateWordMap(Dictionary.dictionary.size)
            }
            return game
        }
    }

    fun setWordVisibility(index: Int){
        visibleWord[index] = !visibleWord[index]
    }
}