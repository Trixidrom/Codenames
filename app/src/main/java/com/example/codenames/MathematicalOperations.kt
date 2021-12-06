package com.example.codenames

import java.math.BigInteger
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

        fun decimalToSixtyTwo (input: String): String {
            var dec = BigInteger(input)
            var digit: Int
            var result = ""
            while (dec>BigInteger.ZERO){
                digit = dec.mod(BigInteger.valueOf(countDictionary.toLong())).toInt()
                result += dictionary[digit]
                dec = dec.divide(BigInteger.valueOf(countDictionary.toLong()))
            }
            return result.reversed()
        }

        fun decimalToQuaternary(input: String): String{
            var dec = BigInteger(input)
            var digit: Int
            var result = ""
            while (dec>BigInteger.ZERO){
                digit = dec.mod(BigInteger.valueOf(4L)).toInt()
                result += digit
                dec = dec.divide(BigInteger.valueOf(4L))
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

        fun sixtyTwoToDecimal(input: String, Big: Boolean): String{
            var result = BigInteger("0")
            var indexCharOfInput = 0

            for(i in input.length-1 downTo 0){
                result += BigInteger.valueOf(dictionary.indexOf(input[indexCharOfInput]).toLong()).multiply(BigInteger.valueOf(countDictionary.toLong()).pow(i))
                indexCharOfInput++
            }
            return result.toString()
        }

        fun quaternaryToSixtyTwo(input: String): String {
            var decimal = BigInteger.valueOf(0)
            var indexCharOfInput = 0
            for(i in input.length-1 downTo 0){
                decimal += BigInteger.valueOf(input[indexCharOfInput].toString().toLong()).multiply(BigInteger.valueOf(4f.pow(i.toFloat()).toLong()))
                indexCharOfInput++
            }

            //^ реализован перевод с 4ричной в 10тичную

            return decimalToSixtyTwo(decimal.toString())
        }



        fun createColorMap (): MutableList<Int>{
            val cardMap = listOf<Int>(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3).shuffled().toMutableList()
            return cardMap
        }

        fun createColorMapFromKey(key: String): MutableList<Int>{
            val dec = sixtyTwoToDecimal(key.substring(52), true)
            var quat = decimalToQuaternary(dec)
            while(quat.length<25){
                quat = "0" + quat
            }
            return quat.map{it.toString().toInt()}.toMutableList()
        }

        fun createWordMapFromKey(key: String): List<Int>{
            val keyMap = key.substring(2)
            var wordMap= mutableListOf<Int>()
            for (i in 0..48 step 2){
                wordMap.add(sixtyTwoToDecimal(keyMap.substring(i,i+2)))
            }

            return wordMap
        }

        fun createWordMap (listSize: Int): List<Int>{
            val s: MutableSet<Int> = mutableSetOf()
            while (s.size < 25) { s.add((0..(listSize-1)).random()) }
            return s.toList()
        }

        fun checkKey (key: String?): Boolean{
            if(key == null) return false
            if(key.length < 58 || key.length > 61) return false
            if(key[0].toString().toInt() < 0 || key[0].toString().toInt() > 7) return false
            if(key[1].toString().toInt() != 0 && key[1].toString().toInt() != 1) return false
            return true
        }
    }
}