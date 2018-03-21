package com.example.csci3130_baseproject;
import java.util.ArrayList;

/**
 * Object class for users/students accessing the application.
 */
public class User {
    private String id;
    private String email;
    private String password;
    private ArrayList<Course> courses;
    private ArrayList<Course> pastCourses;

    /**
     * Default constructor for user.
     */
    public User(){
    }

    /**
     * Set the past courses of the user.
     * @param course Arraylist containing courses for the user.
     */
    public void setPastCourses(ArrayList<Course> course){
        this.pastCourses = new ArrayList<Course>();
    }

    /**
     * Get past courses from the user.
     * @return Arraylist of courses from the student.
     */
    public ArrayList<Course> getPastCourses(){
        return pastCourses;
    }
    public int coursesNum(){
        if (getCourses().isEmpty()){
            return 0;
        }
        else{
            return getCourses().size();
        }
    }

    /**
     * Get Courses from student
     * @return Arraylist of courses that student is enrolled in.
     */
    public ArrayList<Course> getCourses(){
        return courses;
    }

    /**
     * Set courses student is taking.
     * @param courses Updated Arraylist of courses student is taking.
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    /**
     * Get the email attached to the student.
     * @return String of the email of the student.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the student.
     * @param email Updated String of user email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the password of the user.
     * @return String of password for the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the user.
     * @param password String of updated password value.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set the ID of the user.
     * @param id String ID value to be set.
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Get the ID of the user.
     * @return String of the user ID.
     */
    public String getId() {
        return id;
    }
}
