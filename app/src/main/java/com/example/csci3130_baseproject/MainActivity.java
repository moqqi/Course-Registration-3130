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

    public void backToHome(View v) {
        setContentView(R.layout.activity_main);
    }
}
