package com.example.thevolley.the_db;

public class Contact {
    private int id;
    private String name;
    private String mobile;
    private String phone;

    public Contact() {
    }

    public Contact(String name, String mobile, String phone) {
        this.name = name;
        this.mobile = mobile;
        this.phone = phone;
    }


    public Contact(int id, String name, String mobile, String phone) {
        this.id=id;
        this.name = name;
        this.mobile = mobile;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
