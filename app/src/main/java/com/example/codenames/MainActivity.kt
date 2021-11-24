package com.example.codenames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_new_game.setOnClickListener {
            val newGameIntent = Intent (this, ActivityCreateGame::class.java)
            startActivity(newGameIntent)
        }

        btn_continue_game.setOnClickListener {

        }

    }

    override fun onResume() {
        super.onResume()
        if (Game.game != null){
            btn_continue_game.visibility = VISIBLE
        }
    }
}