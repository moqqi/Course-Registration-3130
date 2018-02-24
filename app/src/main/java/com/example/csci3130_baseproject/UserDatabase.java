package com.example.csci3130_baseproject;
import java.util.ArrayList;
public class UserDatabase {
    private ArrayList<User> userList ;

    public ArrayList<User> getUsers() {
        return userList;
    }

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
