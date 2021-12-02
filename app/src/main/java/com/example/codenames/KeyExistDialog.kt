package com.example.codenames

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class KeyExistDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Буфер обмена содержит ключ игры")
                .setMessage("Создать игру по этому ключу?")
                .setNegativeButton("Нет"){
                        dialog, id ->
                    val enterKeyIntent = Intent (context, EnterKeyActivity::class.java)
                    startActivity(enterKeyIntent)
                }
                .setPositiveButton("Да"){
                        dialog, id ->
                    goToChoiseLeadingOrNot(null, activity, context)
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}


