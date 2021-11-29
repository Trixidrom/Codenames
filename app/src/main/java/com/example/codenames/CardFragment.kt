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
import androidx.core.view.isVisible
import com.example.codenames.Game.Companion.game

private const val ARG_COLOR = "color"
private const val ARG_WORD = "word"
private const val ARG_NUMBER = "number"
private const val ARG_TEXT_VISIBLE = "text_visible"

class CardFragment() : Fragment() {

    var numberCard: Int = 0
    private var color: Int? = null
    private var word: Int? = null
    private var textVisible = true
//    var dialog: Dialog? = null

    companion object {
        @JvmStatic
        fun newInstance(numberCard: Int, color: Int, word: Int, textVisible: Boolean) =
            CardFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLOR, color)
                    putInt(ARG_WORD, word)
                    putInt(ARG_NUMBER, numberCard)
                    putBoolean(ARG_TEXT_VISIBLE, textVisible)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        dialog = context?.let { Dialog(it) }
//        dialog?.setContentView(R.layout.dialog_visibility_card)

        arguments?.let {
            color = it.getInt(ARG_COLOR)
            word = it.getInt(ARG_WORD)
            numberCard = it.getInt(ARG_NUMBER)
            textVisible = it.getBoolean(ARG_TEXT_VISIBLE)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card, container, false)
        val textCard = view.findViewById<TextView>(R.id.cardName)
        val frameCard = view.findViewById<FrameLayout>(R.id.frameCard)
//        val Button = dialog?.findViewById<Button>(R.id.btnDialogOk) as Button
//        val heading = dialog?.findViewById<TextView>(R.id.heading) as TextView

        textCard.text = Dictionary.dictionary[word ?: 0]

        view.setOnLongClickListener{
//            if (textCard.isVisible){
//                heading.text = "Скрыть?"
//            }else{
//                heading.text = "Показать?"
//            }
//            dialog?.show()
            if (textCard.isVisible){
                textCard.visibility = View.INVISIBLE
                game?.visibleWord?.set(numberCard, false)
            }else{
                textCard.visibility = View.VISIBLE
                game?.visibleWord?.set(numberCard, true)
            }
            true
        }

//        Button.setOnClickListener{
//            if (textCard.isVisible){
//                textCard.visibility = View.INVISIBLE
//                game?.visibleWord?.set(numberCard, false)
//            }else{
//                textCard.visibility = View.VISIBLE
//                game?.visibleWord?.set(numberCard, true)
//            }
//
//            dialog?.hide()
//        }

        textCard.visibility = if (textVisible)  View.VISIBLE else View.INVISIBLE

        if(game?.redFirst!!){
            when(color){
                1 -> frameCard.setBackgroundResource(R.color.codeRed)
                2 -> frameCard.setBackgroundResource(R.color.codeBlue)
                3 -> frameCard.setBackgroundResource(R.color.codeBlack)
                else -> frameCard.setBackgroundResource(R.color.codeYellow)
            }
        }else{
            when(color){
                1 -> frameCard.setBackgroundResource(R.color.codeBlue)
                2 -> frameCard.setBackgroundResource(R.color.codeRed)
                3 -> frameCard.setBackgroundResource(R.color.codeBlack)
                else -> frameCard.setBackgroundResource(R.color.codeYellow)
            }
        }

        return view
    }
}