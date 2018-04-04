package com.example.csci3130_baseproject;

/**
 * Created by GhadiKashgari on 2018-02-24.
 */

import org.junit.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;

import org.junit.Test;
import static org.junit.Assert.*;
public class RegistrationJUnit {
    RegistrationDatabase r = new RegistrationDatabase();

    ArrayList<Course> courses = new ArrayList<Course>();
    static User u1;
    static User u2;
    static User u3;
    static User u4;
    static User u5;
    static User u6;
    static User u7;
    static User u8;
    static User u9;
    static User u10;

    static Course c1;


    @BeforeClass
    public static void init() throws ParseException{
        ArrayList<User> students = new ArrayList<User>();
        ArrayList<User> waitlist = new ArrayList<User>();
        ArrayList<Course> courses = new ArrayList<Course>();
        u1 = new User();
        u2 = new User();
        u3 = new User();
        u4 = new User();
        u5 = new User();
        u6 = new User();
        u7 = new User();
        u8= new User();
        u9 = new User();
        u10 = new User();
        u1.setCourses(courses);

        c1 = new Course();

        c1.setStudents(students);
        c1.setWaitlist(waitlist);
        c1.setCapacity(15);

        c1.getStudents().add(u1);
        c1.getStudents().add(u2);
        c1.getStudents().add(u3);
        c1.getStudents().add(u4);
        c1.getStudents().add(u5);
        c1.getStudents().add(u6);
        c1.getStudents().add(u7);
        c1.getStudents().add(u8);
        c1.getStudents().add(u9);
        c1.getStudents().add(u10);
        courses.add(c1);
        SimpleDateFormat format2 = new SimpleDateFormat ("EEE MMM d HH:mm:ss yyyy");
        String deadline_strg = "Sun Sep 06 11:28:16 2018";
        String current_strg = "Sun Oct 06 11:28:16 2018";
        Date deadline = format2.parse(deadline_strg);
        Date current = format2.parse(current_strg);
        c1.setDrop_deadline(deadline);
        c1.setCurrent(current);



    }

    @Test
    public  void registerCourses(){
        assertEquals(1, RegistrationDatabase.registerCourse(u1,c1));
    }

    @Test
    public  void maxCoursesChecker() {
        assertEquals(false, RegistrationDatabase.maxCourses(u1));
    }

    @Test
    public void CapacityChecker(){
        assertEquals(true, RegistrationDatabase.courseCapacity(c1));
    }

    @Test
    public void waitlistChecker(){
        assertEquals(true, RegistrationDatabase.waitlist(c1));
    }

    @Test
    public void addStudentChecker(){
        assertEquals(true, RegistrationDatabase.addStudent(u1,c1));
    }

    @Test
    public void dropChecker(){
        assertEquals(true, RegistrationDatabase.drop(c1,courses));
    }
}
