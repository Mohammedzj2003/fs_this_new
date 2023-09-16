package com.example.thevolley.the_sharedprf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thevolley.R;

public class LogoutActivity extends AppCompatActivity {

    TextView textView1 , textView2;
    Button button;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_logout);
        textView1 = findViewById(R.id.name_tV);
        textView2 = findViewById(R.id.school_tV);
        button = findViewById(R.id.out_but);

        preferences = getSharedPreferences("myprf",MODE_PRIVATE);
        String prfName = preferences.getString("name",null);
        String prfSchool = preferences.getString("school",null);

        textView1.setText("Name: "+prfName);
        textView2.setText("School: "+prfSchool);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }
}