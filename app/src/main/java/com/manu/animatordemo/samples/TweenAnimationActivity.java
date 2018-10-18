package com.manu.animatordemo.samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.manu.animatordemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TweenAnimationActivity extends AppCompatActivity {

    @BindView(R.id.btnTranslation)
    Button btnTranslation;
    @BindView(R.id.btnAlpha)
    Button btnAlpha;
    @BindView(R.id.btnScale)
    Button btnScale;
    @BindView(R.id.btnRotate)
    Button btnRotate;
    @BindView(R.id.btnCombine)
    Button btnCombine;
    @BindView(R.id.ivImage)
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        ButterKnife.bind(this);

//        WindowManager manager = getWindowManager();
//        Display display = manager.getDefaultDisplay();
//        System.out.println("height-"+display.getHeight());
//        System.out.println("width-"+display.getWidth());
    }

    @OnClick({R.id.btnTranslation, R.id.btnAlpha, R.id.btnScale, R.id.btnRotate, R.id.btnCombine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnTranslation:
                translation();
                break;
            case R.id.btnAlpha:
                alpha();
                break;
            case R.id.btnScale:
                scale();
                break;
            case R.id.btnRotate:
                rotate();
                break;
            case R.id.btnCombine:
                combine();
                break;
        }
    }

    /**
     * 位移动画
     */
    private void translation() {
        //获取在anim下定义的动画文件
//        TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.translation_anim);
//        ivImage.startAnimation(translateAnimation);

        //表示相对View自身原点(View左上角)像素偏移量
        TranslateAnimation translateAnimation = new TranslateAnimation(0,100,0,100);

        /**
         * ABSOLUTE:表示相对View自身原点(View左上角)像素偏移量
         *          此时和TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta)一样
         * RELATIVE_TO_SELF:表示相对View自身的百分比，如0.5f表示View自身大小的50%，1.0f表示View自身大小
         * RELATIVE_TO_PARENT:表示相对父View的百分比，如0.5f表示View自身大小的50%，1.0f表示View自身大小
         */
//        TranslateAnimation translateAnimation = new TranslateAnimation(
//                Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0.46f,
//                Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0.46f);

        //设置动画持续时间
        translateAnimation.setDuration(1200);
        //设置动画重复模式
        translateAnimation.setRepeatMode(Animation.REVERSE);
        //设置动画重复次数
        translateAnimation.setRepeatCount(3);
        //设置动画插值器
        translateAnimation.setInterpolator(this,android.R.anim.accelerate_interpolator);
//        translateAnimation.setInterpolator(new AccelerateInterpolator());
        //...
        ivImage.startAnimation(translateAnimation);
    }

    /**
     * 缩放动画
     */
    private void scale(){
//        ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(this,R.anim.scale_anim);
//        ivImage.startAnimation(scaleAnimation);

        ScaleAnimation scaleAnimation = new ScaleAnimation(1,3,1,3,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setDuration(1200);
        scaleAnimation.setRepeatCount(3);
        scaleAnimation.setInterpolator(this,android.R.anim.accelerate_decelerate_interpolator);
//        translateAnimation.setInterpolator(new AccelerateInterpolator());
        //...
        ivImage.startAnimation(scaleAnimation);
    }

    /**
     * 旋转动画
     */
    private void rotate(){
//        RotateAnimation rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(this,R.anim.rotate_anim);
//        ivImage.startAnimation(rotateAnimation);

        RotateAnimation rotateAnimation = new RotateAnimation(0,100,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        rotateAnimation.setDuration(1200);
        rotateAnimation.setRepeatCount(3);
        rotateAnimation.setInterpolator(this,android.R.anim.accelerate_decelerate_interpolator);
//        translateAnimation.setInterpolator(new AccelerateInterpolator());
        //...
        ivImage.startAnimation(rotateAnimation);
    }

    /**
     * 透明度动画
     */
    private void alpha(){
//        AlphaAnimation alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(this,R.anim.alpha_anim);
//        ivImage.startAnimation(alphaAnimation);

        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.0f);
        alphaAnimation.setRepeatMode(Animation.RESTART);
        alphaAnimation.setDuration(1500);
        alphaAnimation.setRepeatCount(3);
//        alphaAnimation.setInterpolator(this,android.R.anim.accelerate_decelerate_interpolator);
//        translateAnimation.setInterpolator(new AccelerateInterpolator());
        //...
        ivImage.startAnimation(alphaAnimation);
    }

    /**
     * 组合动画
     */
    private void combine(){
//        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this,R.anim.combine_anim);
//        ivImage.startAnimation(animationSet);

        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.3f);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setRepeatCount(3);
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        rotateAnimation.setRepeatCount(3);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1,3,1,3,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(3);

        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);

        animationSet.setDuration(1200);
        //AnimationSet不支持动画重复播放，如果想要组合动画重复播放可设置每个动画重复播放即可
//        animationSet.setRepeatMode(Animation.REVERSE);
//        animationSet.setRepeatCount(10);

        ivImage.startAnimation(animationSet);
    }
}












