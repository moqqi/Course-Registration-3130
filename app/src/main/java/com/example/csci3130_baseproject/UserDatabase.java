package com.example.csci3130_baseproject;
import java.util.ArrayList;

/**
 * Class acting as User database for functionality.
 */
public class UserDatabase {
    private ArrayList<User> userList = new ArrayList<User>();

    public ArrayList<User> getUsers() {
        return userList;
    }

    /**
     * Add a user to the database.
     * @param user for adding into the database.
     */
    public void add(User user){
        userList.add(user);
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
