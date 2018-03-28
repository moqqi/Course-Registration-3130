package com.example.csci3130_baseproject;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * Created by GhadiKashgari on 2018-02-24.
 */

/**
 * Class used for mimicking the database for Registration of course.
 */
public class RegistrationDatabase {

    /**
     * Main class for testing functionality of database.
     * @param args
     * @throws ParseException
     */
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
        drop(c1,courses);

    }

    /**
     * Add a student to the requested course.
     * @param user to be added to the course.
     * @param course that the use will be added to.
     * @return boolean value of if the user was successfully added to course.
     */
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

    /**
     * Method for registering a user to a course.
     * @param user attempting to register for course.
     * @param course the user is attempting to register.
     * @return int value representing if the user was able to register for course.
     */
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

    /**
     * Check if the user is at max amount of courses.
     * @param user attempting to register.
     * @return boolean check.
     */
    public static boolean maxCourses(User user){
        if (user.coursesNum() >= 5){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Check if course is at max capacity.
     * @param course that user is requesting access to.
     * @return boolean of capacity check.
     */
    public static boolean courseCapacity(Course course){
        if(course.getCapacity() > course.studentsNum()){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Check if waitlist is at maximum.
     * @param course to be checked for waitlist size.
     * @return boolean of waitlist maximum check.
     */
    public static boolean waitlist(Course course) {
        if (course.getWaitlist().size() < 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method for user to drop a course.
     * @param course that user is attempting to drop
     * @param courses list of courses user currently has.
     */
    public static void drop(Course course, ArrayList<Course> courses){
            courses.remove(course);
    }
}