package com.example.codenames

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun goToChoiseLeadingOrNot(editText: EditText?, activity: FragmentActivity?, context: Context?) {

    val dialogLeading = AreYouLeadingDialog()
    var manager: Any

    if (editText != null) {
        if (MathematicalOperations.checkKey(editText?.text.toString())) {
            manager = activity?.supportFragmentManager as FragmentManager
            dialogLeading.show(manager, "Leading")
        } else {
            Toast.makeText(context, "Неверный ключ игры", Toast.LENGTH_SHORT).show()
        }
    } else {
        manager = activity?.supportFragmentManager!!.beginTransaction() as FragmentTransaction
        dialogLeading.show(manager, "Leading")
    }
}
