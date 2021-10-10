package com.dharmik953.weather;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import java.util.Objects;

public class intro extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    final private static int TIME_OUT = 1500;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Objects.requireNonNull(getSupportActionBar()).hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent HomeIndent = new Intent(intro.this, MainActivity.class);
                intro.this.startActivity(HomeIndent);
                intro.this.finish();
            }
        },TIME_OUT);
    }
}