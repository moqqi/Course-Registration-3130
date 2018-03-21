package com.example.csci3130_baseproject;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Schedule Class mimicking database.
 */
public class ScheduleDB {
    /**
     * Main class for testing functionality of database.
     * @param args
     * @throws ParseException
     */
    public static void main (String [] args) throws ParseException{

        User student = new User ();
        ArrayList <Course> current_courses = new ArrayList<Course>();
        SimpleDateFormat format = new SimpleDateFormat ("EEEEE yyyy HH:mm");
        SimpleDateFormat format2 = new SimpleDateFormat ("EEE MMM d HH:mm:ss yyyy");



        String deadline_strg = "Sun Sep 06 11:28:16 2018";
        String current_strg = "Sun Oct 06 11:28:16 2018";
        Date deadline = format2.parse(deadline_strg);
        Date current = format2.parse(current_strg);

        String math_st_strg = "Monday 2018 10:30";
        String econ_st_strg = "Monday 2018 11:30";
        String psyo_st_strg = "Wednesday 2018 09:30";

        String math_end_strg = "Monday 2018 11:20";
        String econ_end_strg = "Monday 2018 12:20";
        String psyo_end_strg = "Wednesday 2018 10:20";

        Date math_st = format.parse(math_st_strg);
        Date econ_st = format.parse(econ_st_strg);
        Date psyo_st = format.parse(psyo_st_strg);

        Date math_end = format.parse(math_end_strg);
        Date econ_end = format.parse(econ_end_strg);
        Date psyo_end = format.parse(psyo_end_strg);

        Course math = new Course ();
        Course psyo = new Course ();
        Course econ = new Course ();

        math.setClass_start(math_st);
        psyo.setClass_start(psyo_st);
        econ.setClass_start(econ_st);

        math.setClass_end(math_end);
        psyo.setClass_end(psyo_end);
        econ.setClass_end(econ_end);

        current_courses.add(math);
        current_courses.add(psyo);
        current_courses.add(econ);

        current_courses.get(0).setName("MATH");
        current_courses.get(1).setName("PSYO");
        current_courses.get(2).setName("ECON");
        math.setDrop_deadline(deadline);
        math.setCurrent(current);

        student.setCourses(current_courses);
        viewDailySchedule(student);
    }

    /**
     * Display the daily schedule of current user.
     * @param user attempting to view their schedule.
     */
    public static void viewDailySchedule (User user){

        ArrayList<Course> courses = user.getCourses();
        ArrayList<Date> cTimes = new ArrayList<Date>();
        SimpleDateFormat format = new SimpleDateFormat ("EEEEE yyyy HH:mm");

        for(int i=0; i<courses.size(); i++){
            cTimes.add(courses.get(i).getClass_start());
            cTimes.add(courses.get(i).getClass_end());
        }
        int j = 0;
        for (int i=0; i<cTimes.size()*2; i=i+2){
            if(j>=courses.size()){
                return;
            }
            System.out.println(courses.get(j).getName()+"    "+ format.format(cTimes.get(i))+"    "+format.format(cTimes.get(i+1)));
            j++;
        }

        System.out.print(cTimes.size());
    }
}
