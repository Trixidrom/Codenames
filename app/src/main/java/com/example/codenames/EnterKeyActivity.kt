package com.example.codenames

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.enter_key_activity.*


class EnterKeyActivity : AppCompatActivity(R.layout.enter_key_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_begin_game.setOnClickListener {
            goToChoiseLeadingOrNot(et_key, this, this)
        }

    }
}

