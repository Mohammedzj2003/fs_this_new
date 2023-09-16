package com.example.thevolley.the_db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBOperations extends SQLiteOpenHelper {
    public DBOperations(Context context) {
        super(context, "MyDB", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table contacts(id integer primary key ,name text,phone text,mobile text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    SQLiteDatabase sql_db;

    public void openDB() {
        sql_db = getWritableDatabase();
    }

    public void closeDB() {
        sql_db.close();
    }

    public void InsertContact(Contact contact) {
        sql_db.execSQL("insert into contacts(name,phone,mobile) values('" + contact.getName() + "','" + contact.getPhone() + "','" + contact.getMobile() + "')");
    }

    public void UpdateContact(Contact contact) {
        sql_db.execSQL("update contacts set name='" + contact.getName() + "', phone='" + contact.getPhone() + "',mobile='" + contact.getMobile() + "' where id = " + contact.getId());
    }

    public void DeleteContact(int id) {
        sql_db.execSQL("delete from contacts where id =" + id);
    }


    public ArrayList<Contact> selectContacts() {
        ArrayList<Contact> allContacts = new ArrayList<>();

        Cursor C = sql_db.rawQuery("select * from contacts", null);

        while (C.moveToNext()) {
            int id = C.getInt(0);
            String name = C.getString(1);
            String phone = C.getString(2);
            String mobile = C.getString(3);
            allContacts.add(new Contact(id, name, phone, mobile));
        }

        return allContacts;
    }

    public ArrayList<Contact> selectContacts2() {
        ArrayList<Contact> allContacts = new ArrayList<>();

        Cursor C = sql_db.rawQuery("select * from contacts where phone > 50", null);

        while (C.moveToNext()) {
            int id = C.getInt(0);
            String name = C.getString(1);
            String phone = C.getString(2);
            String mobile = C.getString(3);
            allContacts.add(new Contact(id, name, phone, mobile));
        }

        return allContacts;
    }

    public ArrayList<Contact> selectContacts3() {
        ArrayList<Contact> allContacts = new ArrayList<>();

        Cursor C = sql_db.rawQuery("select * from contacts where phone <= 50", null);

        while (C.moveToNext()) {
            int id = C.getInt(0);
            String name = C.getString(1);
            String phone = C.getString(2);
            String mobile = C.getString(3);
            allContacts.add(new Contact(id, name, phone, mobile));
        }

        return allContacts;

    }
}
