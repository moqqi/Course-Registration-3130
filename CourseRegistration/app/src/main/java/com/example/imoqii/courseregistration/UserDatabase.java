package com.example.imoqii.courseregistration;
import java.util.ArrayList;
public class UserDatabase {
    private ArrayList<User> userList = new ArrayList<User>();

    public ArrayList<User> getUsers() {
        return userList;
    }

    public void add(User user){
        userList.add(user);
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
