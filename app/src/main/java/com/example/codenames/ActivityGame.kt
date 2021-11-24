package com.example.codenames

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class ActivityGame : AppCompatActivity(R.layout.game) {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI()

        var colorMap = MathematicalOperations.CreateColorMap()
        var wordMap = MathematicalOperations.CreateWordMap(WORDS_GAGA_GAMES.size)

        for (i in 0..24) {
            addCardToFragment(cardIds[i], colorMap[i], wordMap[i])
        }
    }

    private fun addCardToFragment(ids: Int, color: Int, word: Int) {
        supportFragmentManager.beginTransaction()
            .add(ids, CardFragment.newInstance(color, word))
            .commit()
    }

    override fun onResume() {
        super.onResume()
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
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