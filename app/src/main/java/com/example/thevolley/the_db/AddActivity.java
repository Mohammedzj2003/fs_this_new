package com.example.thevolley.the_db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.thevolley.R;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Button btn_ok =  findViewById(R.id.btn_ok);
        Button ra1 =  findViewById(R.id.ra1);
        Button ra2 =  findViewById(R.id.ra2);
        Button ra3 =  findViewById(R.id.ra3);
        EditText contact_name =  findViewById(R.id.contact_name);
        EditText contact_mobile = findViewById(R.id.contact_mobile);
        EditText contact_phone =  findViewById(R.id.contact_phone);


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = contact_name.getText().toString();
                String mobile = contact_mobile.getText().toString();
                String phone = contact_phone.getText().toString();

                Contact contact = new Contact(name, mobile, phone);


                DBOperations operations = new DBOperations(AddActivity.this);
                operations.openDB();
                operations.InsertContact(contact);
                operations.closeDB();

            }
        });

        ra1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBOperations operations = new DBOperations(AddActivity.this);
                operations.openDB();
                ArrayList<Contact> allContacts = operations.selectContacts();
                operations.closeDB();

                customAdapter adapter = new customAdapter(AddActivity.this, R.layout.item, allContacts);
                ListView myListView =  findViewById(R.id.myListView);
                myListView.setAdapter(adapter);
            }
        });


        ra2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBOperations operations = new DBOperations(AddActivity.this);
                operations.openDB();
                ArrayList<Contact> allContacts = operations.selectContacts2();
                operations.closeDB();

                customAdapter adapter = new customAdapter(AddActivity.this, R.layout.item, allContacts);
                ListView myListView =  findViewById(R.id.myListView);
                myListView.setAdapter(adapter);
            }
        });

        ra3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBOperations operations = new DBOperations(AddActivity.this);
                operations.openDB();
                ArrayList<Contact> allContacts = operations.selectContacts3();
                operations.closeDB();

                customAdapter adapter = new customAdapter(AddActivity.this, R.layout.item, allContacts);
                ListView myListView =  findViewById(R.id.myListView);
                myListView.setAdapter(adapter);
            }
        });

    }
}