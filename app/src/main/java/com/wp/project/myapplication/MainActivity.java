package com.wp.project.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * android控件可移动demo
 * auth:WanPan
 * date:2018年11月22日
 *
 */
public class MainActivity extends Activity implements View.OnTouchListener {
    private Button mButton;
    private ViewGroup mViewGroup;
    private int xDelta;
    private int yDelta;
    private int start_x;//记录按下时的坐标x
    private int start_y;//记录按下时的坐标y
    private int stop_x;//记录移动后的坐标x
    private int stop_y;//记录移动后的坐标y
    public static final String TAG = "YAYUN";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewGroup = (ViewGroup) findViewById(R.id.root);
        mButton = (Button) findViewById(R.id.id_text);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin = 50;
        layoutParams.topMargin = 50;

        mButton.setLayoutParams(layoutParams);
        mButton.setOnTouchListener(this);
    }


    /**
     * 手指按下时记录坐标xy，移动中重新赋值xy坐标并刷新父控件。手指弹起后判断移动距离，(这里已10px)表示未移动(即点击事件)
     *
     * @param view
     * @param event
     * @return
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final int x = (int) event.getRawX();
        final int y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view
                        .getLayoutParams();
                start_x = params.leftMargin;
                start_y = params.topMargin;
                xDelta = x - params.leftMargin;
                yDelta = y - params.topMargin;
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                        .getLayoutParams();
                int xDistance = x - xDelta;
                int yDistance = y - yDelta;
                stop_x = xDistance;
                stop_y = yDistance;
                layoutParams.leftMargin = xDistance;
                layoutParams.topMargin = yDistance;
                view.setLayoutParams(layoutParams);
                break;
            case MotionEvent.ACTION_UP:
                int move_x;//移动的距离
                int move_y;//移动的距离
                if (start_x > stop_x) {
                    move_x = start_x - stop_x;
                } else {
                    move_x = stop_x - start_x;
                }
                if (start_y > stop_y) {
                    move_y = start_y - stop_y;
                } else {
                    move_y = stop_y - start_y;
                }
                if (move_x < 10 && move_y < 10) {
                    //TODO:点击事件这里写
                }
                break;
        }
        mViewGroup.invalidate();
        return true;
    }
}