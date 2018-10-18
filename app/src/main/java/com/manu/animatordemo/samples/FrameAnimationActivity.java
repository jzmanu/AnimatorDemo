package com.manu.animatordemo.samples;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.manu.animatordemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrameAnimationActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.btnStartFrame)
    Button btnStartFrame;
    @BindView(R.id.btnEndFrame)
    Button btnEndFrame;

    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        ButterKnife.bind(this);

        //获取Frame动画文件对应的AnimationDrawable
//        mAnimationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.frame_animator);
//        imageView.setBackground(mAnimationDrawable);

        //代码创建Frame动画
        mAnimationDrawable = new AnimationDrawable();
        //设置动画只能播放一次
        mAnimationDrawable.setOneShot(false);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.drawable.zzlx1),100);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.drawable.zzlx2),100);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.drawable.zzlx3),100);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.drawable.zzlx4),100);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.drawable.zzlx5),100);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.drawable.zzlx6),100);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.drawable.zzlx7),100);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.drawable.zzlx8),100);
        imageView.setBackground(mAnimationDrawable);
    }

    @OnClick({R.id.btnStartFrame, R.id.btnEndFrame})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnStartFrame:
                //开启动画
                mAnimationDrawable.start();
                break;
            case R.id.btnEndFrame:
                //停止动画
                mAnimationDrawable.stop();
                break;
        }
    }
}
