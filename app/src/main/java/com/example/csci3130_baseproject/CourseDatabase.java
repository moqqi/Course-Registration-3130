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

    public void connectToFirebase(DatabaseReference appData){
        this.appData = appData;


        appData.addValueEventListener(new ValueEventListener() {
                                      @Override
                                      public void onDataChange(DataSnapshot dataSnapshot) {
                                          Course course = dataSnapshot.getValue(Course.class);
                                          Map<String, Course> td = (HashMap<String,Course>) dataSnapshot.getValue();

                                          courseList = new ArrayList<Course>(td.values());

                                      }
                                      @Override
                                      public void onCancelled(DatabaseError databaseError) {
                                          System.out.println("The read failed: " + databaseError.getCode());
                                      }

                                  });
    }

    /**
     * Add a class to the Database.
     * @param course Course object to be added to database.
     */
    public void addCourse(Course course) {
        String cID = appData.push().getKey();//each entry needs a unique Id
        //courseList.add(course);
        appData.child(cID).setValue(course);
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
            if (courseList.get(i).getId().equals(cID))
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
