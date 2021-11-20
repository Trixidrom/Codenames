package com.example.codenames

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_game.*

class ActivityNewGame: AppCompatActivity(R.layout.activity_new_game) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_begin.setOnClickListener {
            val gameIntent = Intent (this, ActivityGame::class.java)
            startActivity(gameIntent)
        }

    }
}