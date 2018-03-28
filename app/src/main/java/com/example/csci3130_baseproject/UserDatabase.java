package com.example.csci3130_baseproject;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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
                User user = dataSnapshot.getValue(User.class);
                Map<String, User> td = (HashMap<String,User>) dataSnapshot.getValue();

                userList = new ArrayList<User>(td.values());
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
        //courseList.add(course);
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
}
