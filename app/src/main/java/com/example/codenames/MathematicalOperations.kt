package com.example.codenames

import kotlin.math.pow

class MathematicalOperations {
    //Класс переводит из 10-ой системы счисления в 62-ричную и наоборот
    // 62 ричный код, позволяет сохранять 3843 слова (по 2 символа на слово)

    companion object {
        val dictionary = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

        val countDictionary = dictionary.length

        fun decimalToSixtyTwo (input: Int): String {
            var dec = input
            var digit: Int
            var result = ""

            while (dec>0){
                digit = dec % countDictionary
                result += dictionary[digit]
                dec = dec/ countDictionary
            }
            return result.reversed()
        }

        fun sixtyTwoToDecimal(input: String): Int{
            var result = 0
            var indexCharOfInput = 0

            for(i in input.length-1 downTo 0){
                result += dictionary.indexOf(input[indexCharOfInput]) * (countDictionary.toFloat().pow(i.toFloat())).toInt()
                indexCharOfInput++
            }
            return result
        }

        fun CreateColorMap (): List<Int>{
            val cardMap = listOf<Int>(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3).shuffled()
            return cardMap
        }

        fun CreateWordMap (listSize: Int): List<Int>{
            val s: MutableSet<Int> = mutableSetOf()
            while (s.size < 25) { s.add((0..(listSize-1)).random()) }
            return s.toList()
        }
    }
}