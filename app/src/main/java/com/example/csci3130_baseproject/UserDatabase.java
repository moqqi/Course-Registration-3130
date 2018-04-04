package com.example.csci3130_baseproject;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class acting as User database for functionality.
 */
public class UserDatabase{
    private ArrayList<User> userList = new ArrayList<User>();
    private DatabaseReference appData;

    public void connectToFirebase(DatabaseReference appData){
        this.appData = appData;

        appData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Object> objectMap = (HashMap<String, Object>)
                        dataSnapshot.getValue();
                for (Object obj : objectMap.values()) {
                    if (obj instanceof Map) {
                        Map<String, Object> mapObj = (Map<String, Object>) obj;
                        User user = new User(mapObj);
                        userList.add(user);
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }

        });
    }

    public ArrayList<User> getUsers() {
        return userList;
    }

    /**
     * Add a user to the database.
     * @param user for adding into the database.
     */
    public void add(User user){
        String uID = appData.push().getKey();//each entry needs a unique Id
        user.setId(uID);

        ArrayList<Course> courses = new ArrayList<Course>();
        for(Course course : user.getCourses()){
            course.setStudents(null);
            course.setWaitlist(null);
            courses.add(course);
        }
        user.setCourses(courses);

        appData.child(uID).setValue(user);
        userList.add(user);
    }

    public void remove(String uID){
        if(uID != null){
            appData.child(uID).removeValue();
        }
    }

    /**
     * Login method for handling functionality.
     * @param email email of user.
     * @param password password of user.
     * @return Boolean check if login was successful.
     */
    public boolean login(String email, String password) {
        boolean loginResult = false;

        for(int i=0; i<userList.size(); i++)
            if(userList.get(i).getEmail().equals(email)) {
                if(userList.get(i).getPassword().equals(password))
                    loginResult = true;
            }

        return loginResult;
    }

    public void setUserList(ArrayList<User> userList){
        this.userList = userList;
    }
}
