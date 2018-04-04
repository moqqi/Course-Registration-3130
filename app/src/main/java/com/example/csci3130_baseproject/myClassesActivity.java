package com.example.csci3130_baseproject;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by GhadiKashgari on 2018-03-14.
 */

/**
 * Displaying all classes on user.
 */
public class myClassesActivity extends Activity{

    /**
     * OnCreate method for setting the current view of activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycourses_activity);
    }
}
