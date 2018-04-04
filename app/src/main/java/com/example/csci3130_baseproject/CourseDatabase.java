package com.example.csci3130_baseproject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class acting as Database for course objects.
 */
public class CourseDatabase {
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private DatabaseReference appData;
    private ValueEventListener listener;

    public void connectToFirebase(final DatabaseReference appData){
        this.appData = appData;

        listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                appData.removeEventListener(listener);
                Map<String, Object> objectMap = (HashMap<String, Object>)
                        dataSnapshot.getValue();

                for (Object obj : objectMap.values()) {
                    if (obj instanceof Map) {
                        Map<String, Object> mapObj = (Map<String, Object>) obj;
                        Course course = new Course(mapObj);
                        courseList.add(course);
                    }
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                appData.removeEventListener(this);
                System.out.println("The read failed: " + databaseError.getCode());
            }
        };

        this.appData.addValueEventListener(listener);
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
     * @param index Course object to be fetched from the database.
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
     * @param cID of course requested to be removed from database.
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
     * @param cID of Course requested from database.
     * @return Course with requested id.
     */
    public Course searchByID(String cID) {

        if(courseList.size()<1) return null;

        for(int i=0; i<courseList.size(); i++) {
            if (courseList.get(i).courseCode().equals(cID))
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

    public void setCourseList(ArrayList<Course> courseList){
        this.courseList = courseList;
    }
}
