package com.example.codenames

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.codenames.Game.Companion.game

private const val ARG_KEY = "key"

class AreYouLeadingDialog : DialogFragment() {

    private var key: String? = ""

    companion object {
        @JvmStatic
        fun newInstance(key: String) =
                AreYouLeadingDialog().apply {
                    arguments = Bundle().apply {
                        putString(ARG_KEY, key)
                    }
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            key = it.getString(ARG_KEY)
        }

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Вы ведущий?")
                .setNegativeButton("Нет"){
                    dialog, id ->
                    dialog.dismiss()

                    Dictionary.setDictionary(key?.first().toString().toInt())
                    Game.getInstance(key!!)
                    game?.isLeading = false
                    game?.colorMapForNotLeading = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
                    val newGameIntent = Intent (context, ActivityGame::class.java)
                    startActivity(newGameIntent)
                }
                .setPositiveButton("Да"){
                        dialog, id ->
                    dialog.dismiss()

                    Dictionary.setDictionary(key?.first().toString().toInt())
                    Game.getInstance(key!!)
                    game?.isLeading = true

                    val newGameIntent = Intent (context, ActivityGame::class.java)
                    startActivity(newGameIntent)
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }

}