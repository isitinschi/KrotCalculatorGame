package com.github.krot.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.krot.R;
import com.github.krot.game.Game;
import com.github.krot.game.Operator;
import com.github.krot.game.Round;
import com.github.krot.sqlite.helper.DatabaseHelper;
import com.github.krot.utils.Properties;
import com.github.krot.utils.PropertiesLoader;
import com.github.krot.utils.SystemProperties;
import com.github.krot.views.OperatorView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends Activity {
    private static final float EQUATION_FONT_SIZE_PERCENT = 0.15f;
    private static final float BUTTON_FONT_SIZE_PERCENT = 0.5f;
    private static final float ROUND_INFO_FONT_SIZE_PERCENT = 0.06f;
    private static float E_PRECISION = 0.000001f;

    private float curValue = 0;
    private float targetValue = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSystem();
        initLayout();
    }

    private void initSystem() {
        DatabaseHelper.init(this);
        PropertiesLoader.loadSystemProperties();
    }

    private void initLayout() {
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.editText1)).setGravity(Gravity.END);

        setFontSize();
        populateRoundData();

        findViewById(R.id.mainPanel).setOnDragListener(new MyDragListener());
        findViewById(R.id.clearButton).setOnClickListener(new MyClickListener());
    }

    private void setFontSize() {
        int height = getResources().getDisplayMetrics().heightPixels;
        float equalsPanelTextSize = height * EQUATION_FONT_SIZE_PERCENT;

        ((TextView) findViewById(R.id.editText1)).setTextSize(TypedValue.COMPLEX_UNIT_PX, equalsPanelTextSize);
        ((TextView) findViewById(R.id.editText2)).setTextSize(TypedValue.COMPLEX_UNIT_PX, equalsPanelTextSize);
        ((TextView) findViewById(R.id.editText3)).setTextSize(TypedValue.COMPLEX_UNIT_PX, equalsPanelTextSize);

        int buttonHeight = getResources().getDrawable(R.drawable.button_normal).getIntrinsicHeight();
        float buttonTextSize = buttonHeight * BUTTON_FONT_SIZE_PERCENT;
        ((Button) findViewById(R.id.clearButton)).setTextSize(TypedValue.COMPLEX_UNIT_PX, buttonTextSize);

        float roundInfoTextSize = height * ROUND_INFO_FONT_SIZE_PERCENT;
        ((TextView) findViewById(R.id.roundInfo)).setTextSize(TypedValue.COMPLEX_UNIT_PX, roundInfoTextSize);
    }

    private void populateRoundData() {
        Game game = Game.INSTANCE;
        Round round = game.nextRound();
        if (round != null) {
            ViewGroup viewgroup = findViewById(R.id.operationsPanel);
            viewgroup.removeAllViews();
            for (Operator operator : round.getOperators()) {
                View ov = new OperatorView(this, operator);
                viewgroup.addView(ov);
            }

            NumberFormat nf = new DecimalFormat("##.##");

            TextView initValueEditText = findViewById(R.id.editText1);
            curValue = round.getInitValue();
            initValueEditText.setText(nf.format(curValue));

            TextView equalsSignEditText = findViewById(R.id.editText2);
            equalsSignEditText.setTextColor(Color.RED);

            TextView targetValueEditText = findViewById(R.id.editText3);
            targetValue = round.getTargetValue();
            targetValueEditText.setText(nf.format(targetValue));

            ((TextView) findViewById(R.id.roundInfo)).setText("Round " + round.getId());
        } else {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("No new rounds for the moment. Will be soon...");
            dlgAlert.setTitle("Krot");
            dlgAlert.setCancelable(false);
            dlgAlert.create().show();
        }
    }

    private class MyDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            // Handles each of the expected events
            switch (event.getAction()) {

                //signal for the start of a drag and drop operation.
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;

                //the drag point has entered the bounding box of the View
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    break;

                case DragEvent.ACTION_DROP:
                    View view = (View) event.getLocalState();
                    ViewGroup viewgroup = (ViewGroup) view.getParent();
                    viewgroup.removeView(view);
                    Log.v("MA", "Removed view");

                    TextView tv = findViewById(R.id.editText1);
                    curValue = ((OperatorView) view).getOperator().apply(curValue);

                    StringBuilder outputValueBuilder = new StringBuilder();
                    NumberFormat nf = new DecimalFormat("##.##");
                    String outputValue = nf.format(curValue);
                    outputValueBuilder.append(outputValue);
                    if (Math.abs(Float.valueOf(outputValue) - curValue) >= E_PRECISION) {
                        outputValueBuilder.append("...");
                    }
                    tv.setText(outputValueBuilder);

                    if (Math.abs(curValue - targetValue) < E_PRECISION) {
                        ((TextView) findViewById(R.id.editText2)).setTextColor(Color.GREEN);
                        ++SystemProperties.NEXT_ROUND;
                        DatabaseHelper.getHelper().putProperty(Properties.NEXT_ROUND.toString(), String.valueOf(SystemProperties.NEXT_ROUND));

                        Handler handler = new Handler();
                        handler.postDelayed(MainActivity.this::populateRoundData, 2000);
                    }
                    break;

                //the drag and drop operation has concluded.
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
                default:
                    break;
            }
            return true;
        }
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            populateRoundData();
        }
    }
}
