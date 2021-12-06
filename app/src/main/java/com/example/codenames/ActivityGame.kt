package com.example.codenames

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class ActivityGame : AppCompatActivity(R.layout.activity_game) {

    val cardIds = listOf(
        R.id.card0,
        R.id.card1,
        R.id.card2,
        R.id.card3,
        R.id.card4,
        R.id.card5,
        R.id.card6,
        R.id.card7,
        R.id.card8,
        R.id.card9,
        R.id.card10,
        R.id.card11,
        R.id.card12,
        R.id.card13,
        R.id.card14,
        R.id.card15,
        R.id.card16,
        R.id.card17,
        R.id.card18,
        R.id.card19,
        R.id.card20,
        R.id.card21,
        R.id.card22,
        R.id.card23,
        R.id.card24
    )
    var game : Game? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI()

        game = Game.getInstance()

        for (i in 0..24) {
            addCardToFragmentForTeamLead(cardIds[i], i, game?.colorMap?.get(i) ?: 0, game?.wordMap?.get(i) ?: 0, game?.visibleWord?.get(i)?: true)
        }

        //TODO тесты
        println("--------------")

//        println(game?.generateKey())
//        println("color map" + game?.colorMap?.joinToString(""))
//        println(game?.wordMap)
//        println(MathematicalOperations.quaternaryToSixtyTwo("3222222222111111110000000"))
//        println(MathematicalOperations.sixtyTwoToDecimal("4j4Fa9AHY", true))
//        println(MathematicalOperations.decimalToQuaternary("1032074556686336"))
//
//
//        println(MathematicalOperations.quaternaryToSixtyTwo("111111112222222223"))
//        println(MathematicalOperations.sixtyTwoToDecimal("P0Elxr", true))
//        println(MathematicalOperations.decimalToQuaternary("22906841771"))
//
//        println(MathematicalOperations.createWordMapFromKey("010F3l4n1J1m2O1y204a510L141I5K0j4u4N5p374M221k5u0D6127SwIdQJc"))

    }

    private fun addCardToFragmentForTeamLead(ids: Int, number: Int, color: Int, word: Int, textVisibility: Boolean ) {
        supportFragmentManager.beginTransaction()
            .add(ids, CardFragment.newInstance(number, color, word, textVisibility))
            .commit()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.setDecorFitsSystemWindows(false)
                window.insetsController?.let {
                    it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                    it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }
            }else{
                @Suppress("DEPRECATION")
                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
            }
        }
    }

    private fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let {
                it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            getSupportActionBar()?.hide()
            @Suppress("DEPRECATION")
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }
}