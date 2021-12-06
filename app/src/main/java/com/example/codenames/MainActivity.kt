package com.example.codenames

import android.app.Dialog
import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.EditText
import com.example.codenames.Game.Companion.game
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.content.ClipDescription.MIMETYPE_TEXT_PLAIN





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_new_game.setOnClickListener {
            val newGameIntent = Intent (this, ActivityMenuCreateGame::class.java)
            startActivity(newGameIntent)
        }

        btn_continue_game.setOnClickListener {
            val gameIntent = Intent (this, ActivityGame::class.java)
            startActivity(gameIntent)
        }

        btn_game_from_key.setOnClickListener{
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            var pasteData = ""

            if (!clipboard.hasPrimaryClip() || !clipboard.getPrimaryClipDescription()?.hasMimeType(MIMETYPE_TEXT_PLAIN)!!) {
                //если в буфере ничего нет или там не текст

                val enterKeyIntent = Intent (this, EnterKeyActivity::class.java)
                startActivity(enterKeyIntent)
            } else {
                //если в буфере текст
                val item: ClipData.Item = clipboard.getPrimaryClip()!!.getItemAt(0)
                // получаем буфер в виде текста.
                pasteData = item.text.toString()

                val keyExistDialog = KeyExistDialog.newInstance(pasteData)
                val manager = supportFragmentManager
                keyExistDialog.show(manager, "keyExist")
            }

            println("паст дата: $pasteData")
        }

        ib_key.setOnClickListener{
            //копировать в буфер
            val clipboard: ClipboardManager = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("", tv_key.getText().toString())
            clipboard.setPrimaryClip(clip)

            Toast.makeText(this, "Ключ скопирован в буфер обмена", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        if (game != null){
            btn_continue_game.visibility = VISIBLE
            ll_key.visibility = VISIBLE
            tv_key.setText(game?.generateKey())
        }
    }
}