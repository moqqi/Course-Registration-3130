package com.example.csci3130_baseproject;
import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Object class for users/students accessing the application.
 */
public class User implements Serializable {
    private String id;
    private String email;
    private String password;
    private ArrayList<Course> courses;

    /**
     * Default constructor for user, required for firebase.
     */
    public User(){
    }

    public User(Map<String, Object> mapObj){
        //this.setId((String) mapObj.get("id"));
        this.setEmail((String) mapObj.get("email"));
        this.setPassword((String) mapObj.get("password"));

        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Object> coursesMap = (ArrayList<Object>) mapObj.get("courses");
        if(coursesMap != null){
            for(Object obj: coursesMap){
                if (obj instanceof Map) {
                    Map<String, Object> courseMapObj = (Map<String, Object>) obj;
                    Course course = new Course(courseMapObj);
                    courses.add(course);
                }
            }
        }
        this.setCourses(courses);
    }

    public User(String id, String email, String password, ArrayList<Course> courses) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.courses = courses;
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

    /**
     * Mapping required for adding attributes of User for use on Firebase.
     * @return Mapping of Name and Value.
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("email", email);
        //result.put("id", id);
        result.put("password", password);
        result.put("courses", courses);
        return result;
    }
}
