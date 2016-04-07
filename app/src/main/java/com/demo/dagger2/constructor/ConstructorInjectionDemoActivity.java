package com.demo.dagger2.constructor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.demo.dagger2.R;
import com.demo.dagger2.common.ui.BaseActivity;

import butterknife.Bind;

/**
 * Created by gagandeep on 7/4/16.
 */
public class ConstructorInjectionDemoActivity extends BaseActivity {

    @Bind(R.id.tv_screen_name)
    TextView mScreenNameView;

    private CIDScreenInfo mScreenInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportActionBar().setTitle("Constructor Injection Demo");
        mScreenNameView.setText(mScreenInfo.screenName);
    }

    @Override
    public void initComponent() {
        ConstructorInjectionDemoComponent component = DaggerConstructorInjectionDemoComponent.builder().constructorInjectionDemoModule(new
                ConstructorInjectionDemoModule("Constructor Injection Demo Activity")).build();
        mScreenInfo = component.screenInfo();
    }
}
