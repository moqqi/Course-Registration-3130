package com.example.imoqii.courseregistration;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * Created by GhadiKashgari on 2018-02-24.
 */

public class RegistrationDatabase {
    public static void main(String [] args) throws ParseException {
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Course> courses1 = new ArrayList<Course>();
        ArrayList<User> waitlist = new ArrayList<User>();
        ArrayList<User> students = new ArrayList<User>();

        User stu1 = new User();
        stu1.setId("1000");
        stu1.setEmail("gh90@dal.ca");
        stu1.setPassword("1234");
        stu1.setCourses(courses1);

        Course c1 = new Course();
        c1.setDepartment("Science");
        c1.setId("CHEM1100");
        c1.setName("Chemistry 1");
        c1.setCapacity(1);

        Course c2 = new Course();
        c2.setDepartment("Computer Science");
        c2.setId("CSCI101");
        c2.setName("Computer Science 2");
        c2.setCapacity(3);
        c1.setStudents(students);
        c1.setWaitlist(waitlist);

        registerCourse(stu1,c1);

        registerCourse(stu1,c1);

        SimpleDateFormat format2 = new SimpleDateFormat ("EEE MMM d HH:mm:ss yyyy");
        String deadline_strg = "Sun Sep 06 11:28:16 2018";
        String current_strg = "Sun Oct 06 11:28:16 2018";
        Date deadline = format2.parse(deadline_strg);
        Date current = format2.parse(current_strg);
        c1.setDrop_deadline(deadline);
        c1.setCurrent(current);
        drop(c1,courses);

    }

    //Assuming that the maximum number of courses a student can register for is 5.
    public static boolean addStudent(User user, Course course){
        course.getStudents().add(user);
        user.getCourses().add(course);
        if (course.getStudents().contains(user) && user.getCourses().contains(course)){
            return true;
        }
        else{
            return false;
        }
    }

    //Returns 1 if student is successfully registered in the course
    //Returns 2 if student is added to the wait list
    //returns 3 if student is not registered (either due to max hours exceeded error, or wait list is full)
    public static int registerCourse(User user, Course course){
        if (!maxCourses(user) && courseCapacity(course)) {
            addStudent(user,course);
            return 1;
        }
        else if (!maxCourses(user) && !courseCapacity(course)){ //If course capacity is full
            if (waitlist(course)){ //if wait list has room, adds the student to it
                addStudent(user,course);
                return 2;
            }
            else { //if not, doesn't add student and returns 3
                return 3;
            }
        }
        else {
            return 3;
        }
    }

    //returns true if maximum hours exceeded (5 or more hours)
    public static boolean maxCourses(User user){
        if (user.coursesNum() >= 5){
            return true;
        }
        else {
            return false;
        }
    }

    //Returns true if capacity is not full
    public static boolean courseCapacity(Course course){
        if(course.getCapacity() > course.studentsNum()){
            return true;
        }
        else {
            return false;
        }
    }
    //returns true if wait list is not full
    public static boolean waitlist(Course course) {
        if (course.getWaitlist().size() < 10) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean drop(Course course, ArrayList<Course> Courses){
        if(course.getDrop_deadline().before(course.getCurrent())){
            System.out.println(course.getName()+" was dropped successfully.");
            Courses.remove(course);
            return true;
        }
        else {
            System.out.println("deadline is passed.");
            return false;

        }
    }
}