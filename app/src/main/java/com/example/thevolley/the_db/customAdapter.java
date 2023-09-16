package com.example.thevolley.the_db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.thevolley.R;

import java.util.ArrayList;

public class customAdapter extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<Contact> allContacts;

    public customAdapter(Context context, int resource, ArrayList<Contact> allContacts) {
        super(context, resource, allContacts);
        this.context = context;
        this.resource = resource;
        this.allContacts = allContacts;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View V = LayoutInflater.from(context).inflate(resource, null);

        TextView contact_id =  V.findViewById(R.id.contact_id);
        TextView contact_name =  V.findViewById(R.id.contact_name);
        TextView contact_mobile =  V.findViewById(R.id.contact_mobile);
        TextView contact_phone =  V.findViewById(R.id.contact_phone);

        Contact contact = allContacts.get(position);
        contact_id.setText("" + contact.getId());
        contact_name.setText("" + contact.getName());
        contact_mobile.setText("" + contact.getMobile());
        contact_phone.setText("" + contact.getPhone());


        return V;
    }
}

