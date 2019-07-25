package com.example.dekko;

import java.io.Serializable;

public class User implements Serializable {
    String name,phone,dob,email,provice;

    public User() {
    }

    public User(String name, String phone, String dob, String email, String provice) {
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.email = email;
        this.provice = provice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }
}
