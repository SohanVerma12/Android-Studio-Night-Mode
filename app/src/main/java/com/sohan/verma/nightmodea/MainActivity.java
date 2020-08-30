package com.sohan.verma.nightmodea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch switchNightmode = findViewById(R.id.switchNightMode);

        int currentMode = AppCompatDelegate.getDefaultNightMode();

        if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
            switchNightmode.setChecked(true);
        }
        else {
            switchNightmode.setChecked(false);
        }

        switchNightmode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartCurrentActivity();
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartCurrentActivity();
                }
            }
        });
    }

    private void restartCurrentActivity(){
        Intent i = getIntent();
        finish();
        startActivity(i);

        overridePendingTransition(R.anim.fabe_in, R.anim.fabe_out);

    }
}