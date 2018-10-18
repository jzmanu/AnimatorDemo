package com.manu.animatordemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.manu.animatordemo.samples.FrameAnimationActivity;
import com.manu.animatordemo.samples.PropertyAnimationActivity;
import com.manu.animatordemo.samples.TweenAnimationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnFrameAnimator)
    Button btnFrameAnimator;
    @BindView(R.id.btnTweenAnimator)
    Button btnTweenAnimator;
    @BindView(R.id.btnPropertyAnimator)
    Button btnPropertyAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnFrameAnimator, R.id.btnTweenAnimator,R.id.btnPropertyAnimator})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnFrameAnimator:
                startActivity(FrameAnimationActivity.class);
                break;
            case R.id.btnTweenAnimator:
                startActivity(TweenAnimationActivity.class);
                break;
            case R.id.btnPropertyAnimator:
                startActivity(PropertyAnimationActivity.class);
                break;
        }
    }

    private void startActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

}
