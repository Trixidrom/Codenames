package com.example.codenames

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment

private const val ARG_KEY = "key"

class KeyExistDialog : DialogFragment() {

    private var key: String? = ""

    companion object {
        @JvmStatic
        fun newInstance(key: String) =
                KeyExistDialog().apply {
                    arguments = Bundle().apply {
                        putString(ARG_KEY, key)
                    }
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        dialog = context?.let { Dialog(it) }
//        dialog?.setContentView(R.layout.dialog_visibility_card)

        arguments?.let {
            key = it.getString(ARG_KEY)
        }

    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Буфер обмена содержит ключ игры")
                .setMessage("Создать игру по этому ключу?")
                .setNegativeButton("Ввести ключ в ручную"){
                        dialog, id ->
                    val enterKeyIntent = Intent (context, EnterKeyActivity::class.java)
                    startActivity(enterKeyIntent)
                }
                .setPositiveButton("Да"){
                        dialog, id ->
                    dialog.dismiss()



                    goToChoiseLeadingOrNot(null, activity, context, key!!)
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}


