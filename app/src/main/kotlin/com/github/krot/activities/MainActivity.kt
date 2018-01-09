package com.github.krot.activities

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.Gravity.CENTER
import android.view.Gravity.END
import android.widget.Button
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import android.widget.LinearLayout.VERTICAL
import android.widget.TextView
import com.github.krot.R
import com.github.krot.game.Game
import com.github.krot.sqlite.helper.DatabaseHelper
import com.github.krot.utils.PropertiesLoader
import com.github.krot.views.OperatorView
import org.jetbrains.anko.*
import java.text.DecimalFormat

class MainActivity : Activity() {
    private lateinit var operationsPanel: LinearLayout
    private lateinit var mainPanel: LinearLayout
    private lateinit var roundInfo: TextView
    private lateinit var equationPanel: LinearLayout
    private lateinit var clearButton: Button
    lateinit var editText1: TextView
    lateinit var editText2: TextView
    private lateinit var editText3: TextView

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystem()
        initLayout()
    }

    private fun initSystem() {
        DatabaseHelper.init(this)
        PropertiesLoader.loadSystemProperties()
    }

    private fun initLayout() {
        linearLayout {
            operationsPanel = linearLayout {
                orientation = VERTICAL
                gravity = CENTER
                setBackgroundResource(R.drawable.operations_panel)
            }.lparams {
                width = wrapContent
                height = matchParent
                margin = dip(3)
            }

            mainPanel = linearLayout {
                orientation = VERTICAL
                setBackgroundResource(R.drawable.equation_panel)

                setOnDragListener { _, event ->
                    OnDragListener.onDrag(event, this@MainActivity)
                }

                roundInfo = textView {
                    textSize = 35F
                    text = "Round 1"
                }.lparams {
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                    gravity = END
                }

                equationPanel = linearLayout {
                    orientation = HORIZONTAL
                    gravity = CENTER

                    editText1 = textView {
                        gravity = Gravity.END
                        textSize = 100F
                        singleLine = true
                    }.lparams {
                        width = wrapContent
                        height = wrapContent
                    }

                    editText2 = textView {
                        textSize = 100F
                        singleLine = true
                        gravity = CENTER
                        text = "="
                    }.lparams {
                        width = dip(100)
                        height = wrapContent
                    }

                    editText3 = textView {
                        textSize = 100F
                        gravity = CENTER
                        singleLine = true
                        setPadding(dip(10), dip(0), dip(10), dip(0))
                        setBackgroundResource(R.drawable.metal_frame)
                        textColor = Color.parseColor("#FF6600")
                    }.lparams {
                        width = wrapContent
                        height = wrapContent
                    }
                }.lparams {
                    width = matchParent
                    height = dip(0)
                    weight = 1F
                    margin = dip(10)
                }

                clearButton = button {
                    textSize = 24F
                    text = "Clear"
                    setBackgroundResource(R.drawable.button)
                    setOnClickListener { populateRoundData() }
                }.lparams {
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                    gravity = CENTER
                }
            }.lparams {
                width = matchParent
                height = matchParent
            }

            lparams {
                width = matchParent
                height = matchParent
            }
        }

        setFontSize()
        populateRoundData()
    }

    private fun setFontSize() {
        val height = resources.displayMetrics.heightPixels
        val equalsPanelTextSize = height * EQUATION_FONT_SIZE_PERCENT

        editText1.setTextSize(TypedValue.COMPLEX_UNIT_PX, equalsPanelTextSize)
        editText2.setTextSize(TypedValue.COMPLEX_UNIT_PX, equalsPanelTextSize)
        editText3.setTextSize(TypedValue.COMPLEX_UNIT_PX, equalsPanelTextSize)

        val buttonHeight = resources.getDrawable(R.drawable.button_normal).intrinsicHeight
        val buttonTextSize = buttonHeight * BUTTON_FONT_SIZE_PERCENT
        clearButton.setTextSize(TypedValue.COMPLEX_UNIT_PX, buttonTextSize)

        val roundInfoTextSize = height * ROUND_INFO_FONT_SIZE_PERCENT
        roundInfo.setTextSize(TypedValue.COMPLEX_UNIT_PX, roundInfoTextSize)
    }

    fun populateRoundData() {
        val game = Game
        val round = game.nextRound()
        if (round != null) {
            operationsPanel.removeAllViews()
            for (operator in round.operators) {
                val ov = OperatorView(this, operator)
                operationsPanel.addView(ov)
            }

            val nf = DecimalFormat("##.##")

            game.curValue = round.initValue
            editText1.text = nf.format(game.curValue.toDouble())

            editText2.setTextColor(Color.RED)

            game.targetValue = round.targetValue
            editText3.text = nf.format(game.targetValue.toDouble())

            roundInfo.text = "Round ${round.id}"
        } else {
            val dlgAlert = AlertDialog.Builder(this)
            dlgAlert.setMessage("No new rounds for the moment. Will be soon...")
            dlgAlert.setTitle("Krot")
            dlgAlert.setCancelable(false)
            dlgAlert.create().show()
        }
    }

    companion object {
        private val EQUATION_FONT_SIZE_PERCENT = 0.15f
        private val BUTTON_FONT_SIZE_PERCENT = 0.5f
        private val ROUND_INFO_FONT_SIZE_PERCENT = 0.06f
    }
}
