package com.example.monkey.mobilefinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends BaseActivity implements View.OnTouchListener{

    private Animation alphaAnimation;
    private GestureDetector mGestureDetector;
    @BindView(R.id.fl)
    FrameLayout fl;

    @BindView(R.id.anim_tv)
    TextView tv;

    @OnClick(R.id.bt)
    public void alpha(){
        tv.startAnimation(alphaAnimation);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);
        initialAnimation();
    }

    private void initialAnimation() {
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    public class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onDown(MotionEvent e){
            toastShort("onDown");
            return true;
        }

        public void onShowPress(MotionEvent e){
            toastShort("onShowPress");
        }

        public void onLongPress(MotionEvent e){
            toastShort("onLongPress");
        }

        public boolean onSingleTapUp(MotionEvent e){
            toastShort("onSingleTapUp");
            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
            toastShort("onScroll" + (e2.getX()-e1.getX()) + "   " + distanceX);
            return true;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            toastShort("onFLing");
            return true;
        }

        public boolean onDoubleTap(MotionEvent e){
            toastShort("onDoubleTap");
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent e){
            toastShort("onDoubleTapEvent");
            return true;
        }
    }
}
