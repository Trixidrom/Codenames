package com.example.codenames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codenames.TranslationOfNumbers.Companion.decimalToSixtyTwo
import com.example.codenames.TranslationOfNumbers.Companion.sixtyTwoToDecimal


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("=========------========")
        println(decimalToSixtyTwo(63)) //11
        println(decimalToSixtyTwo(62)) //10
        println(decimalToSixtyTwo(3843)) //zz


        println(sixtyTwoToDecimal("11"))
        println(sixtyTwoToDecimal("10"))
        println(sixtyTwoToDecimal("zz"))

    }


//ПРЯЧЕМ ПАНЕЛЬ НАВИГАЦИИ (Нижнюю)
//    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        super.onWindowFocusChanged(hasFocus)
//        if (hasFocus) {
//            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                    or View.SYSTEM_UI_FLAG_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
//        }
//    }


}