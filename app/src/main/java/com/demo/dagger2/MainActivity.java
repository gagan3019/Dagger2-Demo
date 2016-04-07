package com.demo.dagger2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.demo.dagger2.constructor.ConstructorInjectionDemoActivity;
import com.demo.dagger2.login.LoginActivity;
import com.demo.dagger2.named.NamedInjectionDemoActivity;
import com.demo.dagger2.scopes.ScopesDemoActivity;
import com.demo.dagger2.subcomp.SubComponentDemoActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gagandeep on 7/4/16.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_demo_app)
    void launchDaggerDemo() {
        startDemo(LoginActivity.class);
    }

    @OnClick(R.id.bt_demo_constructor_injection)
    void launchConstructorInjectionDemo() {
        startDemo(ConstructorInjectionDemoActivity.class);
    }

    @OnClick(R.id.bt_demo_named_injection)
    void launchNamedInjectionDemo() {
        startDemo(NamedInjectionDemoActivity.class);
    }

    @OnClick(R.id.bt_demo_scopes_injection)
    void launchScopesInjectionDemo() {
        startDemo(ScopesDemoActivity.class);
    }

    @OnClick(R.id.bt_demo_sub_comp_injection)
    void launchSubCompDemo() {
        startDemo(SubComponentDemoActivity.class);
    }

    private void startDemo(Class<? extends Activity> acitivityClass) {
        Intent intent = new Intent(getApplicationContext(), acitivityClass);
        startActivity(intent);
    }
}
