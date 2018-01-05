package com.github.krot.views;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.krot.R;
import com.github.krot.game.Operator;

public class OperatorView extends TextView {

    private static final float FONT_SIZE_PERCENT = 0.035f;
    private static final float CIRCLE_SHAPE_SIZE_PERCENT = 0.13f;
    private static final float MARGIN_PERCENT = 0.025f;

    private Operator operator;

    public OperatorView(Context context, Operator operator) {
        super(context);
        this.operator = operator;

        setText(operator.getFormattedString());
        setBackgroundResource(R.drawable.operator_background);
        setGravity(Gravity.CENTER);
        setOnDragListener(new OperationViewDragListener());

        int height = getResources().getDisplayMetrics().heightPixels;
        float textSize = height * FONT_SIZE_PERCENT;
        setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);

        int size = (int) (height * CIRCLE_SHAPE_SIZE_PERCENT);
        ((GradientDrawable)getResources().getDrawable(R.drawable.operator_background)).setSize(size, size);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int margin = (int) (height * MARGIN_PERCENT);
        layoutParams.setMargins(margin, margin, margin, margin);
        setLayoutParams(layoutParams);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            startDrag(null, new View.DragShadowBuilder(this), this, 0);
        }
        return true;
    }

    private class OperationViewDragListener implements OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            if (event.getAction() == DragEvent.ACTION_DRAG_STARTED) {
                final View view = ((View)event.getLocalState());
                view.setVisibility(View.INVISIBLE);
            } else if (event.getAction() == DragEvent.ACTION_DRAG_ENDED) {
                final View view = ((View)event.getLocalState());
                view.post(() -> view.setVisibility(View.VISIBLE));
            }

            return true;
        }
    }

    public Operator getOperator() {
        return operator;
    }
}
