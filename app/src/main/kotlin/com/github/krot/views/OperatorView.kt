package com.github.krot.views

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue.COMPLEX_UNIT_PX
import android.view.DragEvent
import android.view.DragEvent.ACTION_DRAG_ENDED
import android.view.DragEvent.ACTION_DRAG_STARTED
import android.view.Gravity
import android.view.Gravity.CENTER
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_DOWN
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import com.github.krot.R
import com.github.krot.game.Operator

class OperatorView(context: Context, val operator: Operator) : TextView(context) {
    init {
        text = operator.formattedString
        setBackgroundResource(R.drawable.operator_background)
        gravity = CENTER
        setOnDragListener(OperationViewDragListener())

        val height = resources.displayMetrics.heightPixels
        val textSize = height * FONT_SIZE_PERCENT
        setTextSize(COMPLEX_UNIT_PX, textSize)

        val size = (height * CIRCLE_SHAPE_SIZE_PERCENT).toInt()
        (resources.getDrawable(R.drawable.operator_background) as GradientDrawable).setSize(size, size)

        val layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        val margin = (height * MARGIN_PERCENT).toInt()
        layoutParams.setMargins(margin, margin, margin, margin)
        setLayoutParams(layoutParams)
    }

    override fun onTouchEvent(motionEvent: MotionEvent): Boolean {
        if (motionEvent.action == ACTION_DOWN) {
            startDrag(null, View.DragShadowBuilder(this), this, 0)
        }
        return true
    }

    private inner class OperationViewDragListener : View.OnDragListener {

        override fun onDrag(v: View, event: DragEvent): Boolean {
            if (event.action == ACTION_DRAG_STARTED) {
                val view = event.localState as View
                view.visibility = INVISIBLE
            } else if (event.action == ACTION_DRAG_ENDED) {
                val view = event.localState as View
                view.post { view.visibility = VISIBLE }
            }

            return true
        }
    }

    companion object {
        private val FONT_SIZE_PERCENT = 0.035f
        private val CIRCLE_SHAPE_SIZE_PERCENT = 0.13f
        private val MARGIN_PERCENT = 0.025f
    }
}
