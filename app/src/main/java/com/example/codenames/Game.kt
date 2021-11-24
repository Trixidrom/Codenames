package com.example.codenames

class Game {

    var param_1 : Boolean =false

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
            }
            return game
        }
    }

}