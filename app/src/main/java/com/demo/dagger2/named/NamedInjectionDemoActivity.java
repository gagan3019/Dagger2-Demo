package com.demo.dagger2.named;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.demo.dagger2.R;
import com.demo.dagger2.common.ui.BaseActivity;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.Bind;
import timber.log.Timber;

/**
 * Created by gagandeep on 7/4/16.
 */
public class NamedInjectionDemoActivity extends BaseActivity {

    public static final String CURRENT_SCREEN_NAME = "CURRENT_SCREEN_NAME";
    public static final String LAST_SCREEN_NAME = "LAST_SCREEN_NAME";

    @Inject
    @Named(LAST_SCREEN_NAME)
    NIDScreenInfo mLastScreenInfo;

    @Inject
    @Named(CURRENT_SCREEN_NAME)
    NIDScreenInfo mCurrentScreenInfo;

    @Bind(R.id.tv_current_screen_name)
    TextView mCurrentScreenNameView;

    @Bind(R.id.tv_last_screen_name)
    TextView mLastScreenNameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_named_injection_demo);
        getSupportActionBar().setTitle("Named Injection Demo");

        String currentScreenName = String.format(getString(R.string.current_screen_name), mCurrentScreenInfo.screenName);
        String lastScreenName = String.format(getString(R.string.last_screen_name), mLastScreenInfo.screenName);

        Timber.d("onCreate: "+currentScreenName);
        Timber.d("onCreate: "+lastScreenName);

        mCurrentScreenNameView.setText(currentScreenName);
        mLastScreenNameView.setText(lastScreenName);

    }

    @Override
    public void initComponent() {
        NamedInjectionDemoComponent component = DaggerNamedInjectionDemoComponent.builder().namedInjectionDemoModule
                (new NamedInjectionDemoModule("Monday", "Sunday")).build();
        component.inject(this);
    }

}
