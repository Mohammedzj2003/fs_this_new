package com.example.thevolley.the_sharedprf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thevolley.R;

public class LoginActivity extends AppCompatActivity {

    EditText editText1 ,editText2;
    Button button;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText1 = findViewById(R.id.name_et);
        editText2 = findViewById(R.id.school_et);
        button = findViewById(R.id.sent_but);


        preferences = getSharedPreferences("myprf",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText1.getText().length() ==0){
                    editText1.setError("Enter Name");
                }else if (editText2.getText().length() ==0){
                    editText2.setError("Enter School");
                }else{
                    editor.putString("name",editText1.getText().toString());
                    editor.putString("school",editText2.getText().toString());
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Done", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(LoginActivity.this, LogoutActivity.class);
                    startActivity(intent);
                }


            }
        });
    }
}