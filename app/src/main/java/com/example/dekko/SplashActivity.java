package com.example.dekko;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        router();
    }

    private void router() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("dekko",MODE_PRIVATE);
                boolean isLogin =sharedPreferences.getBoolean("isLogin",false);
                if(isLogin){
                    intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    intent = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);

                }
            }
        },2000);
    }
}
