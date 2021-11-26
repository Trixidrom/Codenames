package com.example.codenames

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu_create_game.*

class ActivityMenuCreateGame: AppCompatActivity(R.layout.activity_menu_create_game) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val spinner = findViewById<Spinner>(R.id.spinner)
        //val adapter = Arra

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        btn_begin.setOnClickListener {
            var numberDictionary = when(radioGroup.checkedRadioButtonId){
                R.id.radioButtonGaga -> 0
                R.id.radioButtonUndercover -> 1
                R.id.radioButtonWithoutToponyms -> 2
                R.id.radioButtonWithManyToponyms -> 3
                R.id.radioButtonFewToponyms -> 4
                R.id.radioButtonFewToponymsAnd18 -> 5
                R.id.radioButtonAllDictionary -> 6
                else -> 7
            }
            Dictionary.setDictionary(numberDictionary)
            Game.getInstance(true)

            val gameIntent = Intent (this, ActivityGame::class.java)
            startActivity(gameIntent)
            finish()
        }
    }
}