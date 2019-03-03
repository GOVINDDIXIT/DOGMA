package com.example.govind.techie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toolbar;

public class SettingActivity extends AppCompatActivity {
    private Switch mswitch;
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(MainActivity.currentTheme.equals("DarkTheme"))
            setTheme(R.style.darkTheme);
        else
            setTheme(R.style.lightTheme);
        setContentView(R.layout.activity_setting);

        toolbar=findViewById(R.id.toolbar);
        mswitch = (Switch)findViewById(R.id.mswitch);

        toolbar.setTitle("Settings");

        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES) {
            mswitch.setChecked(true);
        }

        mswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();
                }
            }
        });
    }


    public void restartApp() {
        Intent i =new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}
