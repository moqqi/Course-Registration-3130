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
}
