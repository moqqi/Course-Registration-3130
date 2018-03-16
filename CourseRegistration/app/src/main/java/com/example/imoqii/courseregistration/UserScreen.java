package com.example.imoqii.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class UserScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button timetableBtn = findViewById(R.id.button3);
        timetableBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(UserScreen.this, timetableActivity.class));
            }
        });

        final Button myCoursesBtn = findViewById(R.id.button);
        myCoursesBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(UserScreen.this, myClassesActivity.class));
            }
        });

        final Button dailyScheduleBtn = findViewById(R.id.button2);
        dailyScheduleBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(UserScreen.this, dailyScheduleActivity.class));
            }
        });

        final Button logoutBtn = findViewById(R.id.button4);
        timetableBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(UserScreen.this,logoutActivity.class));
            }
        });

    }
}