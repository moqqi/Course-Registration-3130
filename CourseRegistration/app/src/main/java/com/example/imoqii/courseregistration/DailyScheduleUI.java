package com.example.imoqii.courseregistration;
import java.text.Format;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class DailyScheduleUI extends AppCompatActivity   {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
   /* public void set_end_Date (TextView view){
        SimpleDateFormat formatter = new SimpleDateFormat ("EEEEE yyyy HH:mm");
        String end_strg = "Monday 2018 11:20";
        String date = formatter.format(end_strg);
        view.setText(date);*/
    //}
    //public void DAILY_SCHEDULE(View v) {


      //  setContentView(R.layout.activity_main);
      //  Course temp = new Course();
      //  User user = new User ();
      //  temp.setName("MATH1000");
      //  user.getCourses().add(temp);
      //  TextView textView = (TextView)findViewById(R.id.textView1);
      //  textView.setText(temp.getName());




   // }

}
