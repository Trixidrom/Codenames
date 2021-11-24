package com.example.codenames

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_game.*

class ActivityCreateGame: AppCompatActivity(R.layout.activity_new_game) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_begin.setOnClickListener {

            Game.getInstance(true)?.param_1 = param_1.isChecked

            val gameIntent = Intent (this, ActivityGame::class.java)
            startActivity(gameIntent)
            MainActivity.hasGame = true
            finish()
        }

        btn_resume.setOnClickListener {
            val gameIntent = Intent (this, ActivityGame::class.java)
            startActivity(gameIntent)
            MainActivity.hasGame = true
            //finish()
        }
    }
}