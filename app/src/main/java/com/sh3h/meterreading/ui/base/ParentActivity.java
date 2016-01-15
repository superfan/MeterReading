package com.sh3h.meterreading.ui.base;


import android.os.Bundle;

public class ParentActivity extends BaseActivity {
    public ParentActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setBothAnimation();
    }
}
