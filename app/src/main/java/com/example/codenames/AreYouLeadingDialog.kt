package com.example.codenames

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class AreYouLeadingDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Вы ведущий?")
                .setNegativeButton("Нет"){
                    dialog, id ->
                    Toast.makeText(context, "Не", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("Да"){
                        dialog, id ->
                    Toast.makeText(context, "Ага", Toast.LENGTH_SHORT).show()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }

}