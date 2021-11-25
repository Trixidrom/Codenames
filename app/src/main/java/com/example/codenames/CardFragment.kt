package com.example.codenames

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

private const val ARG_COLOR = "color"
private const val ARG_WORD = "word"
private const val ARG_NUMBER = "number"

class CardFragment() : Fragment() {

    var numberCard: Int = 0
    private var color: Int? = null
    private var word: Int? = null
    var dialog: Dialog? = null

    companion object {
        @JvmStatic
        fun newInstance(numberCard: Int, color: Int, word: Int) =
            CardFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLOR, color)
                    putInt(ARG_WORD, word)
                    putInt(ARG_NUMBER, numberCard)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dialog = context?.let { Dialog(it) }
        dialog?.setContentView(R.layout.dialog_visibility_card)

        arguments?.let {
            color = it.getInt(ARG_COLOR)
            word = it.getInt(ARG_WORD)
            numberCard = it.getInt(ARG_NUMBER)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card, container, false)
        val textCard = view.findViewById<TextView>(R.id.cardName)
        val frameCard = view.findViewById<FrameLayout>(R.id.frameCard)
        val Button = dialog?.findViewById<Button>(R.id.btnDialogOk) as Button
        val heading = dialog?.findViewById<TextView>(R.id.heading) as TextView

        textCard.text = WORDS_GAGA_GAMES[word ?: 0]

        view.setOnClickListener{
            if (textCard.isVisible){
                heading.text = "Скрыть?"
            }else{
                heading.text = "Показать?"
            }
            dialog?.show()
        }

        Button.setOnClickListener{
            if (textCard.isVisible){
                textCard.visibility = View.INVISIBLE
            }else{
                textCard.visibility = View.VISIBLE
            }

            dialog?.hide()
        }

        when(color){
            1 -> frameCard.setBackgroundResource(R.color.codeRed)
            2 -> frameCard.setBackgroundResource(R.color.codeBlue)
            3 -> frameCard.setBackgroundResource(R.color.codeBlack)
            else -> frameCard.setBackgroundResource(R.color.codeYellow)
        }

        return view
    }
}