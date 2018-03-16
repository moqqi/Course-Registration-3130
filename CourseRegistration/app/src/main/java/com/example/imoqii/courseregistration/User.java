package com.example.imoqii.courseregistration;
import java.util.ArrayList;
public class User {
    private String id;
    private String email;
    private String password;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Course> pastCourses = new ArrayList<>();

    public User(){
    }

    public User (String id, String email, String password, ArrayList<Course> courses, ArrayList<Course>pastCourses){
        this.id = id;
        this.email=email;
        this.password = password;
        this.courses=courses;
        this.pastCourses=pastCourses;
    }
    public void setPastCourses(ArrayList<Course> course){
        this.pastCourses =course;
    }

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

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
