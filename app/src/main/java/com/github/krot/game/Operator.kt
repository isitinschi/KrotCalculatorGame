package com.github.krot.game

import android.text.Html
import android.text.Spanned
import com.github.krot.game.Operation.*

class Operator (val operation: Operation, val operand: Int? = null) {

    val formattedString: Spanned
        get() {
            val htmlCode: String = when (operation) {
                ADD -> "+ " + operand
                SUB -> "- " + operand
                MULT -> "* " + operand
                DIV -> "/ " + operand
                ROOT -> "&radic;x"
                EXP -> "x<sup>$operand</sup>"
                NEG -> "- x"
            }

            return Html.fromHtml(htmlCode)
        }

    fun apply(value: Float): Float {
        return when (operation) {
            ADD -> value + operand!!
            SUB -> value - operand!!
            MULT -> value * operand!!
            DIV -> value / operand!!
            ROOT -> if (value > 0) Math.pow(value.toDouble(), 0.5).toFloat() else value
            EXP -> Math.pow(value.toDouble(), operand!!.toDouble()).toFloat()
            NEG -> -1 * value
        }
    }
}
