package com.example.csci3130_baseproject;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by iMoqii on 2018-03-27.
 */

public class MyApplicationData extends Application{
    public DatabaseReference firebaseReference;
    public FirebaseDatabase firebaseDBInstance;
    public User mainUser;
    public Course mainCourse;

    public User getMainUser() {
        return mainUser;
    }

    public void setMainUser(User mainUser) {
        this.mainUser = mainUser;
    }

    public Course getMainCourse() { return mainCourse; }
    public void setMainCourse(Course mainCourse) { this.mainCourse = mainCourse; }
}
