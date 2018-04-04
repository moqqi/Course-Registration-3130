package com.example.csci3130_baseproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by GhadiKashgari on 2018-03-14.
 */

/**
 * Class for handling the UI of Daily Schedule viewing.
 */
public class dailyScheduleActivity extends Activity {
    /**
     * On Create method for initializing UI of Daily Schedule
     * @param savedInstanceState previously saved instance of application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_schedule_activity);
    }

    /**
     * Method for returning to home activity.
     * @param v View of activity.
     */
    public void backToHome(View v) {
        setContentView(R.layout.activity_main);
    }
}
