package com.example.codenames

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class KeyExistDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Буфер обмена содержит ключ игры")
                .setMessage("Создать игру по этому ключу?")
                .setNegativeButton("Нет"){
                        dialog, id -> val dialogKey = KeyDoesNotExistDialog()
                    val transaction = activity?.supportFragmentManager!!.beginTransaction()
                    dialogKey.show(transaction, "keyDoesNotExist")
                }
                .setPositiveButton("Да"){
                        dialog, id ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}


