package com.example.codenames

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import com.example.codenames.Game.Companion.game
import kotlinx.android.synthetic.main.fragment_card.*

private const val ARG_COLOR = "color"
private const val ARG_WORD = "word"
private const val ARG_NUMBER = "number"
private const val ARG_TEXT_VISIBLE = "text_visible"

class CardFragment : Fragment(), View.OnClickListener {

    var numberCard: Int = 0
    private var color: Int? = null
    private var word: Int? = null
    private var textVisible = true
    var dialog: Dialog? = null

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

        if(!game?.isLeading!!){
            dialog = context?.let { Dialog(it) }
            dialog?.setContentView(R.layout.dialog_color_card)
        }

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

        textCard.text = Dictionary.dictionary[word ?: 0]

        if(game?.isLeading!!){
            view.setOnLongClickListener{

                if (textCard.isVisible){
                    textCard.visibility = View.INVISIBLE
                    game?.visibleWord?.set(numberCard, false)
                }else{
                    textCard.visibility = View.VISIBLE
                    game?.visibleWord?.set(numberCard, true)
                }
                true
            }
        }else{
            val ibRed = dialog?.findViewById<ImageButton>(R.id.ib_red)
            val ibBlue = dialog?.findViewById<ImageButton>(R.id.ib_blue)
            val ibYellow = dialog?.findViewById<ImageButton>(R.id.ib_yellow)
            val ibGrey = dialog?.findViewById<ImageButton>(R.id.ib_grey)

            ibRed?.setOnClickListener(this)
            ibBlue?.setOnClickListener(this)
            ibYellow?.setOnClickListener(this)
            ibGrey?.setOnClickListener(this)



            view.setOnLongClickListener{
                dialog?.show()
                true
            }
        }


        textCard.visibility = if (textVisible)  View.VISIBLE else View.INVISIBLE

        if(game?.isLeading!!){
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
        }else{
            when(color){
                1 -> frameCard.setBackgroundResource(R.color.codeRed)
                2 -> frameCard.setBackgroundResource(R.color.codeBlue)
                3 -> frameCard.setBackgroundResource(R.color.codeYellow)
                else -> frameCard.setBackgroundResource(R.color.codeGrey)
            }

        }


        return view
    }

    override fun onClick(p0: View?) {
        when (p0?.getId()){
            R.id.ib_red -> {frameCard.setBackgroundResource(R.color.codeRed)
            game?.colorMap?.set(numberCard, 1)}
            R.id.ib_blue -> {frameCard.setBackgroundResource(R.color.codeBlue)
            game?.colorMap?.set(numberCard, 2)}
            R.id.ib_yellow -> {frameCard.setBackgroundResource(R.color.codeYellow)
            game?.colorMap?.set(numberCard, 3)}
            else -> {frameCard.setBackgroundResource(R.color.codeGrey)
            game?.colorMap?.set(numberCard, 0)}
        }
        dialog?.dismiss()
    }
}