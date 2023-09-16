package com.example.thevolley.the_sharedprf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.thevolley.R;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences preferences;
    Handler handler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        preferences =getSharedPreferences("myprf",MODE_PRIVATE);

        String prfName = preferences.getString("name",null);
        String prfSchool = preferences.getString("school",null);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (prfName== null || prfSchool == null){
                    Intent intent = new Intent(SplashActivity.this, LogoutActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);

                }
                finish();
            }
        },2000);
    }
}