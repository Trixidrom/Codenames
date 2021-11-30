package com.example.codenames

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.EditText
import com.example.codenames.Game.Companion.game
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context


class MainActivity : AppCompatActivity() {

    var dialog: Dialog? = null
    lateinit var etKey: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialog = Dialog(this)
        dialog?.setContentView(R.layout.generate_key_dialog)
        etKey = dialog?.findViewById(R.id.et_key)!!

        btn_new_game.setOnClickListener {
            val newGameIntent = Intent (this, ActivityMenuCreateGame::class.java)
            startActivity(newGameIntent)
        }

        btn_continue_game.setOnClickListener {
            val gameIntent = Intent (this, ActivityGame::class.java)
            startActivity(gameIntent)
        }

        btn_generateKey.setOnClickListener{
            etKey.setText(game?.generateKey())
            dialog?.show()

            //копировать в буфер
            val clipboard: ClipboardManager = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("", etKey.getText().toString())
            clipboard.setPrimaryClip(clip)

        }
    }

    override fun onResume() {
        super.onResume()
        if (game != null){
            btn_continue_game.visibility = VISIBLE
            btn_generateKey.visibility = VISIBLE
        }
    }
}