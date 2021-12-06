package com.example.codenames

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun goToChoiseLeadingOrNot(editText: EditText?, activity: FragmentActivity?, context: Context?, key: String) {


    var manager: Any

    if (editText != null) {
        if (MathematicalOperations.checkKey(editText?.text.toString())) {
            var dialogLeading = AreYouLeadingDialog.newInstance(editText.text.toString())
            manager = activity?.supportFragmentManager as FragmentManager
            dialogLeading.show(manager, "Leading")
        } else {
            Toast.makeText(context, "Неверный ключ игры", Toast.LENGTH_SHORT).show()
        }
    } else {
        var dialogLeading = AreYouLeadingDialog.newInstance(key)
        manager = activity?.supportFragmentManager!!.beginTransaction() as FragmentTransaction
        dialogLeading.show(manager, "Leading")
    }
}
