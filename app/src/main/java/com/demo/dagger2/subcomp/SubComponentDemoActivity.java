package com.demo.dagger2.subcomp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.dagger2.R;
import com.demo.dagger2.common.ui.BaseActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by gagandeep on 7/4/16.
 */
public class SubComponentDemoActivity extends BaseActivity {

    @Bind(R.id.tv_current_screen_name)
    TextView mCurrentScreenView;

    @Inject
    String mScreenName;

    @Inject
    HttpClient mHttpClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_comp_demo);
        getSupportActionBar().setTitle("Sub Component Injection Demo");

        String currentScreenName = String.format(getString(R.string.current_screen_name), mScreenName);
        mCurrentScreenView.setText(currentScreenName);
    }

    @OnClick(R.id.bt_send_screen_name)
    void onSendScreenNameButtonClicked() {
        sendScreenName();
        Toast.makeText(SubComponentDemoActivity.this, "Screen Name Sent", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initComponent() {
        SubCompDemoActivityComponent activityComponent = DaggerSubCompDemoActivityComponent.builder()
                .subComDemoActivityModule(new SubComDemoActivityModule("SubComponent Demo Activity")).build();

        SubCompDemoNetComponent netComponent = activityComponent.plus(new SubCompDemoNetModule());
        netComponent.inject(this);
    }

    private void sendScreenName() {
        mHttpClient.sendScreenNameOnNetwork(mScreenName);
    }
}
