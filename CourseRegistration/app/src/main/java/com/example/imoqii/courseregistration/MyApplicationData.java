package com.example.imoqii.courseregistration;
import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Franz on 2017-05-31.
 */

/**
 * Class holding references to the Firebase instances.
 */
public class MyApplicationData extends Application {

    public DatabaseReference firebaseReference;
    public DatabaseReference userDatabase;
    public DatabaseReference courseDatabase;
    public FirebaseDatabase firebaseDBInstance;

}
