package com.example.csci3130_baseproject;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by GhadiKashgari on 2018-03-14.
 */

/**
 * Class for handling the logout UI.
 */
public class logoutActivity extends Activity {

    /**
     * On create method for initializing UI for logout.
     * @param savedInstanceState previous saved instance of application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout_activity);

    }
}