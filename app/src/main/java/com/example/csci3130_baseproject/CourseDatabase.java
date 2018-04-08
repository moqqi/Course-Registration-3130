package com.example.csci3130_baseproject;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
/**
 * Class acting as Database for course objects.
 */
public class CourseDatabase {
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private DatabaseReference appData;

    public void connectToFirebase(DatabaseReference appData){
        this.appData = appData;
    }

    public void updateCourse(Course course){
        appData.child(course.getId()).setValue(course);
    }

    /**
     * Add a class to the Database.
     * @param course Course object to be added to database.
     */
    public void addCourse(Course course) {
        String cID = appData.push().getKey();//each entry needs a unique ID
        course.setId(cID);
        //course.setWaitlist(null);
        //course.setStudents(null);
        ArrayList<User> students = new ArrayList<User>();
        for(User student : course.getStudents()){
            student.setCourses(null);
            students.add(student);
        }
        course.setStudents(students);

        ArrayList<User> waitlist = new ArrayList<User>();
        for(User student : course.getWaitlist()){
            student.setCourses(null);
            waitlist.add(student);
        }
        course.setStudents(students);
        appData.child(cID).setValue(course);
        courseList.add(course);
    }

    /**
     * Get a class from the Database.
     * @param course Course object to be fetched from the database.
     */
    public Course getCourse(int index) {
        return courseList.get(index);
    }

    /**
     * Get the size of the database
     */
    public int size() {
        return courseList.size();
    }

    /**
     * Remove selected course from database.
     * @param id of course requested to be removed from database.
     */
    public void removeCourse(String cID) {
        if(cID != null){
            appData.child(cID).removeValue();
        }

        /**
         if(courseList.size()<1)
         return;

         boolean courseRemoved = false;

         for(int i=0; i<courseList.size(); i++) {
         if(courseList.get(i).getId().equals(id)) {
         courseList.remove(i);
         courseRemoved = true;
         }
         }**/
    }

    /**
     * Retrieve Course from database.
     * @param id of Course requested from database.
     * @return Course with requested id.
     */
    public Course searchByID(String cID) {

        if(courseList.size()<1) return null;

        for(int i=0; i<courseList.size(); i++) {
            if (courseList.get(i).getCourseNum().equals(cID))
                return courseList.get(i);
        }
        return null;
    }

    /**
     * Search for a course by name rather than id.
     * @param name Name of course requested from Database.
     * @return Course from Database with requested name.
     */
    public Course searchByName(String name) {
        if(courseList.size()<1) return null;

        for(int i=0; i<courseList.size(); i++) {
            if (courseList.get(i).getName().equals(name))
                return courseList.get(i);
        }

        return null;
    }

    /**
     * Search for a course by course code
     * @param code Code of course requested from Database.
     * @return Course from Database with requested code.
     */
    public Course searchByCode(String code) {
        if(courseList.size()<1) return null;

        for(int i=0; i<courseList.size(); i++) {
            if (courseList.get(i).courseCode().equals(code))
                return courseList.get(i);
        }

        return null;
    }

    public void setCourseList(ArrayList<Course> courseList){
        this.courseList = courseList;
    }
}
