package com.example.csci3130_baseproject;
import java.util.ArrayList;

/**
 * Class acting as Database for course objects.
 */
public class CourseDatabase {
    private ArrayList<Course> courseList = new ArrayList<Course>();

    /**
     * Add a class to the Database.
     * @param course Course object to be added to database.
     */
    public void addCourse(Course course) {
        courseList.add(course);
    }

    /**
     * Remove selected course from database.
     * @param id of course requested to be removed from database.
     */
    public void removeCourse(String id) {
        if(courseList.size()<1)
            return;

        boolean courseRemoved = false;

        for(int i=0; i<courseList.size(); i++) {
            if(courseList.get(i).getId().equals(id)) {
                courseList.remove(i);
                courseRemoved = true;
            }
        }
    }

    /**
     * Retrieve Course from database.
     * @param id of Course requested from database.
     * @return Course with requested id.
     */
    public Course searchByID(String id) {
        if(courseList.size()<1) return null;

        for(int i=0; i<courseList.size(); i++) {
            if (courseList.get(i).getId().equals(id))
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
}
