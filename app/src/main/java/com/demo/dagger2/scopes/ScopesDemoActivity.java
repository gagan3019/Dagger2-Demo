package com.demo.dagger2.scopes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.demo.dagger2.AppController;
import com.demo.dagger2.R;
import com.demo.dagger2.common.di.AppComponent;
import com.demo.dagger2.common.ui.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.Bind;
import butterknife.OnClick;
import timber.log.Timber;

/**
 * Created by gagandeep on 7/4/16.
 */
public class ScopesDemoActivity extends BaseActivity {

    public static final String SCREEN_NAME = "SCREEN_NAME";
    public static final String CURRENT_TIME = "CURRENT_TIME";

    @Bind(R.id.tv_app_name)
    TextView mAppNameView;

    @Bind(R.id.tv_current_screen_name)
    TextView mScreenNameView;

    @Bind(R.id.tv_current_time)
    TextView mCurrentTimeView;

    @Inject
    @Named(AppController.APP_NAME)
    String mAppName;

    @Inject
    @Named(SCREEN_NAME)
    String mScreenName;

    @Inject
    @Named(CURRENT_TIME)
    String mCurrentTime;

    private AppComponent mAppComponent;
    private ScopesDemoScreenComponent mScreenComponent;
    private ScopesDemoTimeComponent mTimeComponent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scopes_demo);
        getSupportActionBar().setTitle("Scopes Injection Demo");
        setData();
    }

    @Override
    public void initComponent() {
        mAppComponent = AppController.get(getApplicationContext()).getAppComponent();
        mScreenComponent = DaggerScopesDemoScreenComponent.builder().appComponent(mAppComponent)
                .scopesDemoScreenModule(new ScopesDemoScreenModule("Scopes Demo Screen")).build();
        mTimeComponent = DaggerScopesDemoTimeComponent.builder().scopesDemoScreenComponent(mScreenComponent)
                .scopesDemoTimeSessionModule(new ScopesDemoTimeSessionModule(getCurrentTime())).build();

        mTimeComponent.inject(this);

        //setData();
    }

    private void setData() {
        String appName = String.format(getString(R.string.current_app_name), mAppName);
        String currentScreenName = String.format(getString(R.string.current_screen_name), mScreenName);
        String currentTime = String.format(getString(R.string.current_time), mCurrentTime);

        mAppNameView.setText(appName);
        mScreenNameView.setText(currentScreenName);
        mCurrentTimeView.setText(currentTime);

        printrefs();
    }

    @OnClick(R.id.bt_refresh_session)
    void onRefreshButtonClicked() {
        mTimeComponent = DaggerScopesDemoTimeComponent.builder().scopesDemoScreenComponent(mScreenComponent)
                .scopesDemoTimeSessionModule(new ScopesDemoTimeSessionModule(getCurrentTime())).build();

        mTimeComponent.inject(this);
        setData();
    }

    private String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(cal.getTime());
    }

    private void printrefs() {
        Timber.d("mAppName = "+mAppName.hashCode());
        Timber.d("mScreenName = "+mScreenName.hashCode());
        Timber.d("mCurrentTime = "+mCurrentTime.hashCode());
    }
}
