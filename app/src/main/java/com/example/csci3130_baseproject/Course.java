package com.example.csci3130_baseproject;
import com.google.firebase.database.Exclude;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Class used for Course Objects used throughout application.
 */
public class Course {
    private String name, id, courseNum, department;
    private ArrayList<User> waitlist;
    private String class_start;
    private String class_end;
    private int capacity;
    private int current;
    private  ArrayList<User> students ;

    /**
     * Constructor for course.
     */
    public Course (){

    }

    public Course(Map<String, Object> mapObj){
        this.setName((String) mapObj.get("name"));
        this.setId((String) mapObj.get("id"));
        this.setDepartment((String) mapObj.get("department"));
        this.setClass_start((String) mapObj.get("class_start"));
        this.setClass_end((String) mapObj.get("class_end"));

        Long currentValue = (Long) mapObj.get("current");
        if(currentValue != null)
            this.setCurrent(currentValue.intValue());
        Long capacityValue = (Long) mapObj.get("capacity");
        if(capacityValue != null)
            this.setCapacity(capacityValue.intValue());

        ArrayList<User> students = new ArrayList<User>();
        ArrayList<Object> mapStudents = (ArrayList<Object>) mapObj.get("students");
        if(mapStudents != null){
            for(Object obj: mapStudents){
                if (obj instanceof Map) {
                    Map<String, Object> studentMapObj = (Map<String, Object>) obj;
                    User student = new User(studentMapObj);
                    students.add(student);
                }
            }
        }
        this.setStudents(students);

        ArrayList<User> waitlist = new ArrayList<User>();
        ArrayList<Object> mapWaitlist = (ArrayList<Object>) mapObj.get("waitlist");
        if(mapWaitlist != null) {
            for (Object obj : mapWaitlist) {
                if (obj instanceof Map) {
                    Map<String, Object> studentMapObj = (Map<String, Object>) obj;
                    User student = new User(studentMapObj);
                    waitlist.add(student);
                }
            }
        }
        this.setWaitlist(waitlist);
    }

    public Course(String name, String id, String courseNum, String department, ArrayList<User> waitlist, String class_start, String class_end,
                  int capacity, int current, ArrayList<User> students){
        this.name = name;
        this.id = id;
        this.courseNum = courseNum;
        this.department = department;
        this.waitlist = waitlist;
        this.class_start = class_start;
        this.class_end = class_end;
        this.capacity = capacity;
        setStudents(students);
        this.current = current;

    }

    /**
     * Method for retrieving student number.
     * @return Student's number
     */
    public int studentsNum(){
        if (students.isEmpty()){
            return 0;
        }
        else{
            return students.size();
        }
    }

    /**
     * Get list of students in course.
     * @return Array of students in course.
     */
    public ArrayList<User> getStudents() {
        return students;
    }

    /**
     * Sets list of students in the course.
     * @param students List of updated students enrolled in course.
     */
    public void setStudents(ArrayList<User> students) {
        this.students = students;
    }

    /**
     * Get the name of course.
     * @return Name of the course selected.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the course
     * @param name Updated name of course.
     */
    public void setName(String name) {
        this.name  = name;
    }

    /**
     * Get the ID of the course.
     * @return Current ID of course.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the course.
     * @param id updated ID of course.
     */
    public void setId(String id) {
        this.id  = id;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    /**
     * Gets the current department of the course.
     * @return current department of course.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Updates the Department of current Course.
     * @param department Updated Department value of course.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Get the waitlist of students from current course
     * @return Arraylist of users/students currently waitlisted for the course.
     */
    public ArrayList<User> getWaitlist() {
        return waitlist;
    }

    /**
     * Get the current size of the waitlist.
     * @return An integer size of the current waitlist.
     */
    public int waitlistSize() {
        return waitlist.size();
    }

    /**
     * Update the current course waitlist.
     * @param waitlist updated arraylist of users for the course.
     */
    public void setWaitlist(ArrayList<User> waitlist) {
        this.waitlist = new ArrayList<User>();
    }

    /**
     * Get the capacity of the course.
     * @return integer value of the size of the course.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Set the capacity of the course
     * @param capacity Updated capacity integer value.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Get the current open slots of the course.
     * @return integer value of the size of the course.
     */
    public int getCurrent() {
        return current;
    }

    /**
     * Set the current open slots of the course
     * @param current Updated capacity integer value.
     */
    public void setCurrent(int current) {
        this.current = current;
    }

    /**
     * Returns base course info for display.
     * @return String of department, name, and capacity of current course.
     */
    public String viewCourseInfo() {
        return this.getDepartment() + this.getId() + "\n" + this.getName() + "\n"
                + "Capacity: " + this.getCapacity();
    }

    /**
     * Returns the course ID and department, used for buttons.
     * @return String of department and ID.
     */
    public String courseCode() {
        return this.getDepartment() + this.getId();
    }

    /**
     * Get class start Date from current course.
     * @return Date of class_start.
     */
    public String getClass_start() {
        return class_start;
    }

    /**
     * Set course start date for current course.
     * @param class_start Date value of start of the course.
     */
    public void setClass_start(String class_start) {
        this.class_start = class_start;
    }

    /**
     * Get Course end Date for current course.
     * @return Date value of class end.
     */
    public String getClass_end() {
        return class_end;
    }

    /**
     * Set the end Date for the current course.
     * @param class_end Date value of current end class.
     */
    public void setClass_end(String class_end) {
        this.class_end = class_end;
    }

    /**
     * Mapping required for adding attributes of User for use on Firebase.
     * @return Mapping of Name and Value.
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("id", id);
        result.put("department", department);
        result.put("courseNum", courseNum);
        result.put("waitlist", waitlist);
        result.put("class_start", class_start);
        result.put("class_end", class_end);
        result.put("capacity", capacity);
        result.put("students", students);
        result.put("current", current);
        return result;
    }
}
