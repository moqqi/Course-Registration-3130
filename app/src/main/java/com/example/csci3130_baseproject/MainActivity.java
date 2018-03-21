package com.example.csci3130_baseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void enterCourseInfoUI(View v) {
        setContentView(R.layout.course_info);

        Course testCourse = new Course();
        testCourse.setDepartment("Computer Science");
        testCourse.setId("CS212");
        testCourse.setName("Databases");
        testCourse.setCapacity(100);

        ((TextView)findViewById((R.id.courseName))).setText(testCourse.getId());
        ((TextView)findViewById((R.id.courseInfo))).setText(testCourse.viewCourseInfo());
    }

    public void enterScience(View v) {
        setContentView(R.layout.sci);
    }

    public void enterEngineer(View v) {
        setContentView(R.layout.eng);
    }

    public void enterOthers(View v){
        setContentView(R.layout.others);
    }

    public  void enterbande(View v)   {
        setContentView(R.layout.bande);
    }
    public void displayCourseMain(View v) {
        setContentView(R.layout.displaycoursesmain);
    }

    public void displayDailySchedule(View v) {
        setContentView(R.layout.daily_schedule_activity);

        setContentView(R.layout.daily_schedule_activity);
        Course temp = new Course();
        User user = new User ();
        temp.setName("MATH1000");

        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText(temp.getName());

        TextView textView2 = (TextView)findViewById(R.id.textView2);
        stDate(textView2);
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        endDate(textView3);

    }

    public void enterMyCourses(View v) {
        setContentView(R.layout.mycourses_activity);
    }

    public void enterUser(View v) {
        setContentView(R.layout.user_activity);
    }

    public void enterLogout(View v) {
        setContentView(R.layout.logout_activity);
    }

    public void backToHome(View v) {
        setContentView(R.layout.activity_main);
    }
    public void stDate (TextView view){
        Calendar.getInstance().set(2018,3,12,11,20);
        SimpleDateFormat formatter = new SimpleDateFormat ("EEEEE yyyy HH:mm");
        //String st_strg = "Monday 2018 10:30";
        String date = formatter.format(Calendar.getInstance().getTime());
        view.setText(date);
    }

    public void endDate (TextView view){
        Calendar.getInstance().set(2018,3,12,12,30);
        SimpleDateFormat formatter = new SimpleDateFormat ("EEEEE yyyy HH:mm");
        //String st_strg = "Monday 2018 10:30";
        String date = formatter.format(Calendar.getInstance().getTime());
        view.setText(date);
    }
}