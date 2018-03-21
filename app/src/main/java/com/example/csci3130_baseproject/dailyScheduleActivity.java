package com.example.csci3130_baseproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by GhadiKashgari on 2018-03-14.
 */

public class dailyScheduleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_schedule_activity);
    }

    public void backToHome(View v) {
        setContentView(R.layout.activity_main);
    }
}
