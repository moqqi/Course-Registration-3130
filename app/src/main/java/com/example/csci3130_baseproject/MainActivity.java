package com.example.csci3130_baseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
    }

    public void enterMyCourses(View v) {
        setContentView(R.layout.mycourses_activity);
    }

    public void enterLogout(View v) {
        setContentView(R.layout.logout_activity);
    }

    public void backToHome(View v) {
        setContentView(R.layout.activity_main);
    }
}
