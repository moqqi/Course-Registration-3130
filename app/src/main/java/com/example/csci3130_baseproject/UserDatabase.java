package com.example.csci3130_baseproject;

import com.google.firebase.database.DatabaseReference;
import java.util.ArrayList;
/**
 * Class acting as User database for functionality.
 */
public class UserDatabase{
    private ArrayList<User> userList = new ArrayList<User>();
    private DatabaseReference appData;

    public void connectToFirebase(DatabaseReference appData){
        this.appData = appData;
    }

    public void updateUser(User user){
        appData.child(user.getId()).setValue(user);
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
        if(user.getCourses() != null){
            for(Course course : user.getCourses()){
                course.setStudents(null);
                course.setWaitlist(null);
                courses.add(course);
            }
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
    public User login(String email, String password) {
        User result = null;

        for(int i=0; i<userList.size(); i++)
            if(userList.get(i).getEmail().equals(email)) {
                if(userList.get(i).getPassword().equals(password))
                    result = userList.get(i);
            }

        return result;
    }
    public void setUserList(ArrayList<User> userList){
        this.userList = userList;
    }
}
