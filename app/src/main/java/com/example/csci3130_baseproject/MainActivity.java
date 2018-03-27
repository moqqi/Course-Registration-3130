package com.example.csci3130_baseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * MainActivity Class that handles view states of application.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Sets content view to activity main and calls super onCreate.
     * @param savedInstanceState previously saved Instance State.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the app wide shared variables
        MyApplicationData appData = (MyApplicationData)getApplication();

        //Set-up Firebase
        appData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appData.firebaseReference = appData.firebaseDBInstance.getReference("user");

    }

    /**
     * Method for enterring the course info UI section of application.
     * @param v Current View of application.
     */
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

    /**
     * Method for enterring the Science course info UI section of application.
     * @param v Current View of application.
     */
    public void enterScience(View v) {
        setContentView(R.layout.sci);
    }

    /**
     * Method for enterring the Engineering course info UI section of application.
     * @param v Current View of application.
     */
    public void enterEngineer(View v) {
        setContentView(R.layout.eng);
    }

    /**
     * Method for enterring other types of courses UI.
     * @param v Current View of application.
     */
    public void enterOthers(View v){
        setContentView(R.layout.others);
    }

    /**
     * Method for enterring the business and economics portion of course UI.
     * @param v Current View of application.
     */
    public  void enterbande(View v)   {
        setContentView(R.layout.bande);
    }

    /**
     * Method for enterring the course main information in UI.
     * @param v Current View of application.
     */
    public void displayCourseMain(View v) {
        setContentView(R.layout.displaycoursesmain);
    }

    /**
     * Method for displaying the schedule of user selected.
     * @param v Current View of application.
     */
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

    /**
     * Method for enterring the course info UI section of application.
     * @param v Current View of application.
     */
    public void enterMyCourses(View v) {
        setContentView(R.layout.mycourses_activity);
    }

    /**
     * Method for enterring the user information portion of UI.
     * @param v Current View of application.
     */
    public void enterUser(View v) {
        setContentView(R.layout.user_activity);
    }

    /**
     * Method for enterring the logout portion of the application UI.
     * @param v Current View of application.
     */
    public void enterLogout(View v) {
        setContentView(R.layout.logout_activity);
    }

    /**
     * Method for going back to home screen of application.
     * @param v Current View of application.
     */
    public void backToHome(View v) {
        setContentView(R.layout.activity_main);
    }

    /**
     * Sets the startDate of UI for class selected.
     * @param view Textview of onClick
     */
    public void stDate (TextView view){
        Calendar.getInstance().set(2018,3,12,11,20);
        SimpleDateFormat formatter = new SimpleDateFormat ("EEEEE yyyy HH:mm");
        //String st_strg = "Monday 2018 10:30";
        String date = formatter.format(Calendar.getInstance().getTime());
        view.setText(date);
    }

    /**
     * Sets the endDate value of UI for class selected.
     * @param view Textview of OnClick
     */
    public void endDate (TextView view){
        Calendar.getInstance().set(2018,3,12,12,30);
        SimpleDateFormat formatter = new SimpleDateFormat ("EEEEE yyyy HH:mm");
        //String st_strg = "Monday 2018 10:30";
        String date = formatter.format(Calendar.getInstance().getTime());
        view.setText(date);
    }
}