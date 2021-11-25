package com.example.codenames

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu_create_game.*

class ActivityMenuCreateGame: AppCompatActivity(R.layout.activity_menu_create_game) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_begin.setOnClickListener {

            Game.getInstance(true)

            val gameIntent = Intent (this, ActivityGame::class.java)
            startActivity(gameIntent)
            finish()
        }
    }
}