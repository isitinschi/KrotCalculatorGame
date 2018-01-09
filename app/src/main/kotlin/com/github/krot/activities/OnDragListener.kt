package com.github.krot.activities

import android.graphics.Color
import android.os.Handler
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import com.github.krot.game.Game
import com.github.krot.sqlite.helper.DatabaseHelper
import com.github.krot.utils.Properties
import com.github.krot.utils.SystemProperties
import com.github.krot.views.OperatorView
import java.text.DecimalFormat

object OnDragListener {
    private const val E_PRECISION = 0.000001F

    fun onDrag(event: DragEvent, mainActivity: MainActivity): Boolean {
        // Handles each of the expected events
        when (event.action) {
            DragEvent.ACTION_DROP -> {
                val view = event.localState as View
                val viewGroup = view.parent as ViewGroup
                viewGroup.removeView(view)
                Log.v("MA", "Removed view")

                Game.curValue = (view as OperatorView).operator.apply(Game.curValue)

                val outputValueBuilder = StringBuilder()
                val nf = DecimalFormat("##.##")
                val outputValue = nf.format(Game.curValue.toDouble())
                outputValueBuilder.append(outputValue)
                if (Math.abs(outputValue.toFloat() - Game.curValue) >= E_PRECISION) {
                    outputValueBuilder.append("...")
                }
                mainActivity.editText1.text = outputValueBuilder

                if (Math.abs(Game.curValue - Game.targetValue) < E_PRECISION) {
                    mainActivity.editText2.setTextColor(Color.GREEN)
                    DatabaseHelper.INSTANCE.putProperty(Properties.NEXT_ROUND.toString(), (++SystemProperties.NEXT_ROUND).toString())

                    val handler = Handler()
                    handler.postDelayed({ mainActivity.populateRoundData() }, 2000)
                }
            }
        }

        return true
    }
}
