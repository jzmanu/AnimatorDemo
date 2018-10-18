package com.manu.animatordemo.samples;

import android.animation.AnimatorInflater;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import com.manu.animatordemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PropertyAnimationActivity extends AppCompatActivity {

    private static final String TAG = "PropertyAnimation";
    @BindView(R.id.ivImage)
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ivImage})
    public void onViewClicked(View v) {
        switch (v.getId()){
            case R.id.ivImage:
//                translation();
//                alpha();
//                keyFrame();
                sina();
                break;
        }
    }

    /**
     * 代码创建创建ValueAnimator
     */
    private void translation(){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        //设置属性动画持续时间
        valueAnimator.setDuration(2000);
        //设置属性插值器，控制动画执行的变化速率，默认设置插值器为AccelerateDecelerateInterpolator
        valueAnimator.setInterpolator(new AccelerateInterpolator());
//        CycleInterpolator
        //设置属性动画重复播放模式
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        //设置属性动画重复播放次数
        valueAnimator.setRepeatCount(0);
        //设置属性动画延时播放的时间
        valueAnimator.setStartDelay(0);
        //设置属性动画估值器，用于控制最终属性值(API22)
//        valueAnimator.setCurrentFraction(0.5f);
        //设置当前播放时间，其值在Duration范围之内
        valueAnimator.setCurrentPlayTime(1000);
        //设置属性动画估值器，用于控制最终属性值
        valueAnimator.setEvaluator(new IntEvaluator());
//        valueAnimator.setEvaluator(new TypeEvaluator<Integer>() {
//            @Override
//            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
//                Log.i(TAG,"fraction-->"+fraction);
//                int startInt = startValue;
//                return (int)(startInt + fraction * (endValue - startInt));
//            }
//        });

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i(TAG, animation.getAnimatedValue() + "");
                int x = (int) animation.getAnimatedValue();
                ivImage.setTranslationX(x);
                ivImage.setTranslationY(x);
//                ivImage.setRotation(x);
////                ivImage.setRotationY(x);
//                ivImage.setScaleX(3);
//                ivImage.setScaleY(3);
            }
        });

        valueAnimator.start();
    }

    /**
     * xml创建ValueAnimator
     */
    private void test(){
        ValueAnimator animator = (ValueAnimator) AnimatorInflater.loadAnimator(this,R.animator.test_animator);
        animator.setTarget(ivImage);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i(TAG, animation.getAnimatedValue() + "");
                int x = (int) animation.getAnimatedValue();
                ivImage.setTranslationX(x);
                ivImage.setTranslationY(x);
            }
        });
    }

    /**
     * 自定义估值器的使用
     * 正弦运动的估值器
     */
    private void sina(){
        Point startPoint = new Point(ivImage.getX(),ivImage.getY());
        Point endPoint = new Point(ivImage.getX()+500,ivImage.getY());
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new SineTypeValue(), startPoint, endPoint);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i(TAG, animation.getAnimatedValue() + "");
                Point point = (Point) animation.getAnimatedValue();
                ivImage.setX(point.getX());
                ivImage.setY(point.getY());
            }
        });
        valueAnimator.start();
    }

    /**
     * 关键帧的使用
     */
    private void keyFrame(){
        Keyframe keyframe1 = Keyframe.ofFloat(0,0);
        Keyframe keyframe2 = Keyframe.ofFloat(0.25f,500);
        //每个KeyFrame可设置自己的插值器
        keyframe2.setInterpolator(new AccelerateInterpolator());
        Keyframe keyframe3 = Keyframe.ofFloat(0.75f,100);
        Keyframe keyframe4 = Keyframe.ofFloat(1,600);
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("translationX",keyframe1,keyframe2,keyframe3,keyframe4);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(ivImage,holder);
        animator.setDuration(3000);
        animator.start();
    }

    private void alpha(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivImage,"alpha",1f,0,1f);
        animator.setDuration(3000);
        animator.start();
    }

}
