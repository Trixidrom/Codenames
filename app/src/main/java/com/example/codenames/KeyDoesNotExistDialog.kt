package com.example.codenames

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.app.AlertDialog
import android.view.View
import android.widget.EditText
import android.widget.Toast


class KeyDoesNotExistDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater
        val view: View = inflater!!.inflate(R.layout.enter_key_dialog, null)
        val editText = view.findViewById<EditText>(R.id.et_key)
        builder.setView(view)
            .setTitle("Введите ключ игры:")
            .setPositiveButton("Ок") { dialog, id ->
                Toast.makeText(context, editText.text, Toast.LENGTH_SHORT).show()
            }
        return builder.create();
    }
}