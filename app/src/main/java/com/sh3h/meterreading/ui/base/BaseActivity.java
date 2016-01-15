package com.sh3h.meterreading.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sh3h.meterreading.MainApplication;
import com.sh3h.meterreading.R;
import com.sh3h.meterreading.injection.component.ActivityComponent;
import com.sh3h.meterreading.injection.component.DaggerActivityComponent;
import com.sh3h.meterreading.injection.module.ActivityModule;

public class BaseActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;
    private boolean mStartAnimation;
    private boolean mEndAnimation;

    public BaseActivity() {
        mActivityComponent = null;
        mStartAnimation = true;
        mEndAnimation = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setForwardAnimation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        LogUtil.i(TAG, String.format("onDestroy %s", getClass().getName()));
//        destroyReceiver(mainApplication);
//        destroyDataManager();
//        destroyDataDaemon();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);

        if (mStartAnimation) {
            // 设置切换动画，从右边进入，左边退出
            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);

        if (mStartAnimation) {
            // 设置切换动画，从右边进入，左边退出
            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
    }

    @Override
    public void finish() {
        super.finish();

        if (mEndAnimation) {
            // 设置切换动画，从左边进入，右边退出
            overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
        }
    }

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(MainApplication.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }

    public void setStartAnimation(boolean animation) {
        mStartAnimation = animation;
    }

    public void setEndAnimation(boolean animation) {
        mEndAnimation = animation;
    }

    public void destroy() {
        finish();
    }

    public void setForwardAnimation() {
        setStartAnimation(true);
        setEndAnimation(false);
    }

    public void setBackwardAnimation() {
        setStartAnimation(false);
        setEndAnimation(true);
    }

    public void setBothAnimation() {
        setStartAnimation(true);
        setEndAnimation(true);
    }
}
