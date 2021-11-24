package com.example.codenames

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ARG_COLOR = "color"
private const val ARG_WORD = "word"

class CardFragment : Fragment() {

    private var color: Int? = null
    private var word: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getInt(ARG_COLOR)
            word = it.getInt(ARG_WORD)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card, container, false)
        val textCard = view.findViewById<TextView>(R.id.cardName)
        textCard.text = WORDS_GAGA_GAMES[word ?: 0]

        when(color){
            1 -> textCard.setBackgroundResource(R.color.codeRed)
            2 -> textCard.setBackgroundResource(R.color.codeBlue)
            3 -> textCard.setBackgroundResource(R.color.codeBlack)
            else -> textCard.setBackgroundResource(R.color.codeYellow)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int, word: Int) =
            CardFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLOR, color)
                    putInt(ARG_WORD, word)
                }
            }
    }
}