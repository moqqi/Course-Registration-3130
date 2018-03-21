package com.example.csci3130_baseproject;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class used for Course Objects used throughout application.
 */
public class Course {
    private String name, id, department, semester;
    private Date drop_deadline, current;
    private ArrayList<User> waitlist;
    private Date class_start;
    private Date class_end;
    private int capacity;
    private  ArrayList<User> students ;

    /**
     * Constructor for course.
     */
    public Course (){

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
     * Get the deadline date value of course
     * @return Date value of deadline for course.
     */
    public Date getDrop_deadline() {
        return drop_deadline;
    }

    /**
     * Update the deadline date value of course.
     * @param drop_deadline Date value for course deadline.
     */
    public void setDrop_deadline(Date drop_deadline) {
        this.drop_deadline = drop_deadline;
    }

    /**
     * Get the current Date of the course
     * @return Date value of current date of course.
     */
    public Date getCurrent() {
        return current;
    }

    /**
     * Set current Date of course.
     * @param current Date value of current date of course.
     */
    public void setCurrent(Date current) {
        this.current = current;
    }

    /**
     * Set the semester of the course.
     * @param semester String value of semester.
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Get the semester value from current course.
     * @return String value of semester.
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Returns base course info for display.
     * @return String of department, name, and capacity of current course.
     */
    public String viewCourseInfo() {
        return this.getDepartment() + "\n" + this.getName() + "\n"
                + "Capacity: " + this.getCapacity();
    }

    /**
     * Get class start Date from current course.
     * @return Date of class_start.
     */
    public Date getClass_start() {
        return class_start;
    }

    /**
     * Set course start date for current course.
     * @param class_start Date value of start of the course.
     */
    public void setClass_start(Date class_start) {
        this.class_start = class_start;
    }

    /**
     * Get Course end Date for current course.
     * @return Date value of class end.
     */
    public Date getClass_end() {
        return class_end;
    }

    /**
     * Set the end Date for the current course.
     * @param class_end Date value of current end class.
     */
    public void setClass_end(Date class_end) {
        this.class_end = class_end;
    }
}
