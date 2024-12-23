package com.adminpanel.adminpanel.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(name = "user_name",nullable = false)
    private String user_name;
    @Column(name = "user_age",nullable = false)
    private String user_age;
    @Column(name = "phone_number",nullable = false)
    private String phone_number;
    @Column(name = "user_email",nullable = false)
    private String user_email;
    @Column(name = "user_password",nullable = false)
    private String user_password;


    public UserModel(){}

    public UserModel(Long user_id, String user_name, String user_age, String phone_number, String user_email, String user_password) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_age = user_age;
        this.phone_number = phone_number;
        this.user_password = user_password;
        this.user_name=user_name;

    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_name) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

//    public String getUser_password() {
//        return user_password;
//    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public  String toString(){
        return  "User [user_id="+user_id+",user_name="+user_name+",user_email="+user_email+",user_password="+user_password+",user_age="+user_age+",phone_number="+phone_number+"]";
    }
}
