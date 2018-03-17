package com.example.imoqii.courseregistration;
import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Course implements Serializable{
    private String key, name, id, department, semester;
    private Date drop_deadline, current;
    private ArrayList<User> waitlist;
    private Date class_start;
    private Date class_end;
    private int capacity;
    private  ArrayList<User> students ;

    private MyApplicationData appData;

    public Course (){

    }

    public Course(String key, String name, String id, String department, String semester,
                  Date drop_deadline, Date current, ArrayList<User> waitlist, Date class_start,
                  Date class_end, int capacity, ArrayList<User> students) {
        this.key = key;
        this.name = name;
        this.id = id;
        this.department = department;
        this.semester = semester;
        this.drop_deadline = drop_deadline;
        this.current = current;
        this.waitlist = waitlist;
        this.class_start = class_start;
        this.class_end = class_end;
        this.capacity = capacity;
        this.students = students;
    }

    public int studentsNum(){
        if (students.isEmpty()){
            return 0;
        }
        else{
            return students.size();
        }
    }
    public ArrayList<User> getStudents() {
        return students;
    }
    public void setStudents(ArrayList<User> students) {
        this.students = students;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name  = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id  = id;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public ArrayList<User> getWaitlist() {
        return waitlist;
    }
    public int waitlistSize() {
        return waitlist.size();
    }

    public void setWaitlist(ArrayList<User> waitlist) {
        this.waitlist = new ArrayList<User>();
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public Date getDrop_deadline() {
        return drop_deadline;
    }
    public void setDrop_deadline(Date drop_deadline) {
        this.drop_deadline = drop_deadline;
    }
    public Date getCurrent() {
        return current;
    }
    public void setCurrent(Date current) {
        this.current = current;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    public String getSemester() {
        return semester;
    }
    public String viewCourseInfo() {
        return this.getDepartment() + "\tSemester: " + this.getSemester() + "\n" + this.getId() + ": " + this.getName() + "\n"
                + "Capacity: " + this.getCapacity();
    }
    public Date getClass_start() {
        return class_start;
    }

    public void setClass_start(Date class_start) {
        this.class_start = class_start;
    }

    public Date getClass_end() {
        return class_end;
    }

    public void setClass_end(Date class_end) {
        this.class_end = class_end;
    }

    public void updateDatabase(Course course){
        if(course != null){
            appData.courseDatabase.child(course.key).setValue(course);
        }
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("id", id);
        result.put("department", department);
        result.put("semester", semester);
        result.put("drop_deadline", drop_deadline.toString());
        result.put("current", current.toString());
        result.put("waitlist", waitlist.size());
        result.put("class_start", class_start.toString());
        result.put("class_end", class_end).toString();
        result.put("capacity", capacity);
        result.put("students", students.size());
        return result;
    }
}
