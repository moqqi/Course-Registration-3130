package com.example.csci3130_baseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * MainActivity Class that handles view states of application.
 */
public class MainActivity extends AppCompatActivity {
    private static CourseDatabase courses = new CourseDatabase();
    private static UserDatabase users = new UserDatabase();
    private DatabaseReference appData;
    private ValueEventListener listener;
    private ProgressBar spinner;
    private EditText userField, pwField;
    private TextView loginMessage;
    private Button loginButton;



    /**
     * Sets content view to activity main and calls super onCreate.
     * @param savedInstanceState previously saved Instance State.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.VISIBLE);

        userField = findViewById(R.id.username);
        userField.setVisibility(View.GONE);

        pwField = findViewById(R.id.password);
        pwField.setVisibility(View.GONE);

        loginMessage = findViewById(R.id.loginMessage);
        loginMessage.setVisibility(View.GONE);

        loginButton = (Button)findViewById(R.id.button4);
        loginButton.setVisibility(View.GONE);

        appData = FirebaseDatabase.getInstance().getReference();

        listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                appData.removeEventListener(listener);
                Map<String, Object> objectMap = (HashMap<String, Object>)
                        dataSnapshot.getValue();

                Map<String, Object> firebaseCourses = (HashMap<String, Object>) objectMap.get("course");
                ArrayList<Course> courseList = new ArrayList<Course>();
                Map<String, Object> firebaseUsers = (HashMap<String, Object>) objectMap.get("user");
                ArrayList<User> userList = new ArrayList<User>();
                for (Object obj : firebaseCourses.values()) {
                    if (obj instanceof Map) {
                        Map<String, Object> mapObj = (Map<String, Object>) obj;
                        Course course = new Course(mapObj);
                        courseList.add(course);
                    }
                }

                courses.setCourseList(courseList);

                for (Object obj : firebaseUsers.values()) {
                    if (obj instanceof Map) {
                        Map<String, Object> mapObj = (Map<String, Object>) obj;
                        User user = new User(mapObj);
                        userList.add(user);
                    }
                }

                users.setUserList(userList);

                spinner.setVisibility(View.GONE);
                userField.setVisibility(View.VISIBLE);
                pwField.setVisibility(View.VISIBLE);
                loginMessage.setVisibility(View.VISIBLE);
                loginButton.setVisibility(View.VISIBLE);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                appData.removeEventListener(this);
                System.out.println("The read failed: " + databaseError.getCode());
            }
        };
        appData.addValueEventListener(listener);

        /**courses**/
        //empty waitlist
        ArrayList<User> emptyWaitlist = new ArrayList<User>();
        ArrayList<User> emptyStudentlist = new ArrayList<User>();

        //science
        Course sci1 = new Course("Intro to Biology", null,  "100", "BIOL", emptyWaitlist, "8:30", "9:30", 500, 500, emptyStudentlist);
        Course sci2 = new Course("Organic Chemistry", null, "240", "CHEM", emptyWaitlist, "11:30", "12:30", 75, 60, emptyStudentlist);
        Course sci3 = new Course("Physical Cosmology", null, "435", "PHYC", emptyWaitlist, "1:30", "2:30", 40, 20, emptyStudentlist);
        Course sci4 = new Course("Animal Behaviour", null,"350", "NESC", emptyWaitlist, "9:30", "10:30", 100, 40, emptyStudentlist);

        //business and economics
        Course bande1 = new Course("Strategy Implementation", null, "460", "BUSI", emptyWaitlist, "2:30", "3:30", 50, 30, emptyStudentlist);
        Course bande2 = new Course("Innovation Management", null, "320", "BUSI", emptyWaitlist, "10:30", "11:30", 100, 100, emptyStudentlist);
        Course bande3 = new Course("Intro to Macroeconomics", null, "110", "ECON", emptyWaitlist, "10:30", "11:30", 300, 250, emptyStudentlist);
        Course bande4 = new Course("Public Finance", null, "310", "ECON", emptyWaitlist, "3:30", "4:30", 150, 50, emptyStudentlist);

        //engineering
        Course eng1 = new Course("Engineering Design", null, "200", "ENGI", emptyWaitlist, "9:30", "10:30", 200, 100,emptyStudentlist);
        Course eng2 = new Course("Mechanics of Materials", null,"260", "ENGI", emptyWaitlist, "4:30", "5:30", 200, 100,emptyStudentlist);
        Course eng3 = new Course("Thermo-Fluid Engineering", null,"330", "ENGI", emptyWaitlist, "1:30", "2:30", 150, 140,emptyStudentlist);
        Course eng4 = new Course("Engineering Design", null,"120", "ENGI", emptyWaitlist, "11:30", "12:30", 300, 200, emptyStudentlist);

        //other
        Course other1 = new Course("Software Engineering", null,"350", "CSCI", emptyWaitlist, "8:30", "9:30", 100, 90, emptyStudentlist);
        Course other2 = new Course("Ancient Greek Philosophy", null,"240", "PHIL", emptyWaitlist, "9:30", "10:30", 200, 100, emptyStudentlist);
        Course other3 = new Course("American Literature", null,"310", "ENGL", emptyWaitlist, "11:30", "12:30", 50, 20, emptyStudentlist);
        Course other4 = new Course("Basic French", null,"120", "FREN", emptyWaitlist, "2:30", "3:30", 30, 10, emptyStudentlist);

        /**users**/
        //empty course list
        ArrayList<Course> emptyCourseList = new ArrayList<Course>();

        //starting users
        //this user has a full course load, no waitlist
        User user1 = new User("120", "janesmith@dal.ca", "dalhousie", emptyCourseList);
        user1.getCourses().add(sci2);
        sci2.getStudents().add(user1);
        user1.getCourses().add(sci3);
        sci3.getStudents().add(user1);
        user1.getCourses().add(sci4);
        sci4.getStudents().add(user1);
        user1.getCourses().add(other1);
        other1.getStudents().add(user1);
        user1.getCourses().add(other2);
        other2.getStudents().add(user1);

        //only 4/5 courses, no waitlist
        User user2 = new User("333", "johndoe@dal.ca", "baseball", emptyCourseList);
        user2.getCourses().add(eng3);
        eng3.getStudents().add(user2);
        user2.getCourses().add(eng4);
        eng4.getStudents().add(user2);
        user2.getCourses().add(bande3);
        bande3.getStudents().add(user2);
        user2.getCourses().add(bande4);
        bande4.getStudents().add(user2);

        //2 waitlisted course, 1 regular course
        User user3 = new User("653", "jasonmacdonald@dal.ca", "thebeatles", emptyCourseList);
        user3.getCourses().add(sci1);
        sci1.getWaitlist().add(user3);
        user3.getCourses().add(bande2);
        bande2.getWaitlist().add(user3);
        user3.getCourses().add(other4);
        other4.getStudents().add(user3);

        //no courses added yet
        User user4 = new User("738", "lisahunt@dal.ca", "soccer", emptyCourseList);

        //courses.getCourse(0);

        //adding all courses and all users to the database
        /**
        courses.addCourse(sci1);
        courses.addCourse(sci2);
        courses.addCourse(sci3);
        courses.addCourse(sci4);

        courses.addCourse(bande1);
        courses.addCourse(bande2);
        courses.addCourse(bande3);
        courses.addCourse(bande4);

        courses.addCourse(eng1);
        courses.addCourse(eng2);
        courses.addCourse(eng3);
        courses.addCourse(eng4);

        courses.addCourse(other1);
        courses.addCourse(other2);
        courses.addCourse(other3);
        courses.addCourse(other4);
         **/

        /**
        //user database
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
         **/


        //Get the app wide shared variables




        /**UserDatabase testUserDatebase = new UserDatabase();
        testUserDatebase.connectToFirebase(firebaseDatabase);
        User testUser = new User("userID", "userEmail", "userPassword", null, null);
        testUserDatebase.add(testUser);
        firebaseDatabase= FirebaseDatabase.getInstance().getReference("course");

        ArrayList<User> students = new ArrayList<User>();
        students.add(testUser);
        CourseDatabase test = new CourseDatabase();
        test.connectToFirebase(firebaseDatabase);
        Course testCourse = new Course("testName", "testID", "testDepartment", null,
                null, null, 10, students);
        test.addCourse(testCourse);
         **/



    }

    /**
     * Method for enterring the course info UI section of application.
     * @param v Current View of application.
     */
    public void enterCourseInfoUI(View v) {
        //Button button = (Button)v;
        String courseCode = ((Button)v).getText().toString(); //grabbing the full course code
        //grabbing each part individually
        String dept = courseCode.substring(0, 3);
        String id = courseCode.substring(3);

        ((TextView)findViewById((R.id.textView4))).setText(dept);
        ((TextView)findViewById((R.id.textView6))).setText(id);

        //searching for the course
        Course course = new Course();

        for (int i = 0; i < courses.size(); i++) {
            if (courses.getCourse(i).getDepartment().equals(dept) &&
                    courses.getCourse(i).getId().equals(id))
                course = courses.getCourse(i);
        }

        setContentView(R.layout.course_info);

        ((TextView)findViewById((R.id.courseInfo))).setText(course.viewCourseInfo());
    }

    /**
     * Method for enterring the course info UI section of application via search bar.
     * @param v Current View of application.
     */
    public void searchCourse(View v) {
        EditText searchBar = (EditText)findViewById(R.id.searchBar);
        String search = searchBar.getText().toString();
        Course course = new Course();

        if(courses.searchByID(search)!=null)
            course = courses.searchByID(search);
        else if(courses.searchByName(search) !=null)
            course = courses.searchByName(search);
        else
            course = null;

        if(course!=null) {
            setContentView(R.layout.course_info);
            ((TextView) findViewById((R.id.courseInfo))).setText(course.viewCourseInfo());
        }
    }

    /**
     * Method for enterring the Science course info UI section of application.
     * @param v Current View of application.
     */
    public  void enterSci(View v)   {
        if(courses.size()>0) {
            setContentView(R.layout.sci);
            Button course1 = (Button)findViewById(R.id.sci1);
            Button course2 = (Button)findViewById(R.id.sci2);
            Button course3 = (Button)findViewById(R.id.sci3);
            Button course4 = (Button)findViewById(R.id.sci4);

            //creating a list to add for populating the buttons
            ArrayList<String> courseNames = new ArrayList<String>();

            for (int i = 0; i < courses.size(); i++) {
                if (courses.getCourse(i).getDepartment().equals("BIOL") ||
                        courses.getCourse(i).getDepartment().equals("CHEM") ||
                        courses.getCourse(i).getDepartment().equals("PHYC") ||
                        courses.getCourse(i).getDepartment().equals("NESC") ||
                        courses.getCourse(i).getDepartment().equals("PSYC"))
                    courseNames.add(courses.getCourse(i).courseCode());
            }

            if(courseNames.size()>0) {
                course1.setText(courseNames.get(0));

                if(courseNames.get(1)!=null)
                    course2.setText(courseNames.get(1));

                if(courseNames.get(2)!=null)
                    course3.setText(courseNames.get(2));

                if(courseNames.get(3)!=null)
                    course4.setText(courseNames.get(3));

            }
        }
    }

    /**
     * Method for enterring the Engineering course info UI section of application.
     * @param v Current View of application.
     */
    public  void enterEng(View v)   {
        if(courses.size()>0) {
            setContentView(R.layout.eng);
            Button course1 = (Button)findViewById(R.id.eng1);
            Button course2 = (Button)findViewById(R.id.eng2);
            Button course3 = (Button)findViewById(R.id.eng3);
            Button course4 = (Button)findViewById(R.id.eng4);

            //creating a list to add for populating the buttons
            ArrayList<String> courseNames = new ArrayList<String>();

            for (int i = 0; i < courses.size(); i++) {
                if (courses.getCourse(i).getDepartment().equals("ENGI"))
                    courseNames.add(courses.getCourse(i).courseCode());
            }

            if(courseNames.size()>0) {
                course1.setText(courseNames.get(0));

                if(courseNames.get(1)!=null)
                    course2.setText(courseNames.get(1));

                if(courseNames.get(2)!=null)
                    course3.setText(courseNames.get(2));

                if(courseNames.get(3)!=null)
                    course4.setText(courseNames.get(3));

            }
        }
    }

    /**
     * Method for enterring other types of courses UI.
     * @param v Current View of application.
     */
    public  void enterOthers(View v)   {
        if(courses.size()>0) {
            setContentView(R.layout.others);
            Button course1 = (Button)findViewById(R.id.oth1);
            Button course2 = (Button)findViewById(R.id.oth2);
            Button course3 = (Button)findViewById(R.id.oth3);
            Button course4 = (Button)findViewById(R.id.oth4);
            String test = "";

            //creating a list to add for populating the buttons
            ArrayList<String> courseNames = new ArrayList<String>();

            for (int i = 0; i < courses.size(); i++) {
                if (courses.getCourse(i).getDepartment().equals("BIOL") ||
                        courses.getCourse(i).getDepartment().equals("CHEM") ||
                        courses.getCourse(i).getDepartment().equals("PHYC") ||
                        courses.getCourse(i).getDepartment().equals("NESC") ||
                        courses.getCourse(i).getDepartment().equals("PSYC") ||
                        courses.getCourse(i).getDepartment().equals("ENGI") ||
                        courses.getCourse(i).getDepartment().equals("BUSI") ||
                        courses.getCourse(i).getDepartment().equals("ECON"))
                    test = "";
                else
                    courseNames.add(courses.getCourse(i).courseCode());
            }

            if(courseNames.size()>0) {
                course1.setText(courseNames.get(0));

                if(courseNames.get(1)!=null)
                    course2.setText(courseNames.get(1));

                if(courseNames.get(2)!=null)
                    course3.setText(courseNames.get(2));

                if(courseNames.get(3)!=null)
                    course4.setText(courseNames.get(3));

            }
        }
    }

    /**
     * Method for enterring the business and economics portion of course UI.
     * @param v Current View of application.
     */
    public  void enterbande(View v)   {
        if(courses.size()>0) {
            setContentView(R.layout.bande);
            Button course1 = (Button)findViewById(R.id.bande1);
            Button course2 = (Button)findViewById(R.id.bande2);
            Button course3 = (Button)findViewById(R.id.bande3);
            Button course4 = (Button)findViewById(R.id.bande4);

            //creating a list to add for populating the buttons
            ArrayList<String> courseNames = new ArrayList<String>();

            for (int i = 0; i < courses.size(); i++) {
                if (courses.getCourse(i).getDepartment().equals("BUSI") ||
                        courses.getCourse(i).getDepartment().equals("ECON"))
                    courseNames.add(courses.getCourse(i).courseCode());
            }

            if(courseNames.size()>0) {
                course1.setText(courseNames.get(0));

                if(courseNames.get(1)!=null)
                    course2.setText(courseNames.get(1));

                if(courseNames.get(2)!=null)
                    course3.setText(courseNames.get(2));

                if(courseNames.get(3)!=null)
                    course4.setText(courseNames.get(3));

            }
        }
    }

    /**
     * Method for enterring the course main information in UI.
     * @param v Current View of application.
     */
    public void displayCourseMain(View v) {
        setContentView(R.layout.displaycoursesmain);
    }

    /**
     * Method for displaying the schedule of user selected.
     * @param v Current View of application.
     */
    public void displayDailySchedule(View v) {
        setContentView(R.layout.daily_schedule_activity);

        setContentView(R.layout.daily_schedule_activity);
        Course temp = new Course();
        User user = new User ();
        temp.setName("MATH1000");

        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText(temp.getName());

        TextView textView2 = (TextView)findViewById(R.id.textView2);
        stDate(textView2);
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        endDate(textView3);

    }

    /**
     * Method for enterring the course info UI section of application.
     * @param v Current View of application.
     */
    public void enterMyCourses(View v) {
        setContentView(R.layout.mycourses_activity);
    }

    /**
     * Method for enterring the user information portion of UI.
     * @param v Current View of application.
     */
    public void enterUser(View v) {
        setContentView(R.layout.user_activity);
    }

    /**
     * Method for enterring the logout portion of the application UI.
     * @param v Current View of application.
     */
    public void enterLogout(View v) {
        setContentView(R.layout.activity_main);
    }

    /**
     * Method for going back to home screen of application.
     * @param v Current View of application.
     */
    public void backToHome(View v) {
        setContentView(R.layout.user_activity);
    }

    /**
     * Method for login.
     * @param v Current View of application.
     */
    public void login(View v) {
        userField = findViewById(R.id.username);
        pwField = findViewById(R.id.password);
        String username = userField.getText().toString();
        String password = pwField.getText().toString();
        boolean loginResult = users.login(username, password);

        //String testSize = (String)users.getUsers().size();
        loginMessage = findViewById(R.id.loginMessage);
        loginMessage.setText("Invalid login information, please try again");

        if(loginResult==true)
            setContentView(R.layout.user_activity);
    }

    /**
     * Sets the startDate of UI for class selected.
     * @param view Textview of onClick
     */
    public void stDate (TextView view){
        Calendar.getInstance().set(2018,3,12,11,20);
        SimpleDateFormat formatter = new SimpleDateFormat ("EEEEE yyyy HH:mm");
        //String st_strg = "Monday 2018 10:30";
        String date = formatter.format(Calendar.getInstance().getTime());
        view.setText(date);
    }

    /**
     * Sets the endDate value of UI for class selected.
     * @param view Textview of OnClick
     */
    public void endDate (TextView view){
        Calendar.getInstance().set(2018,3,12,12,30);
        SimpleDateFormat formatter = new SimpleDateFormat ("EEEEE yyyy HH:mm");
        //String st_strg = "Monday 2018 10:30";
        String date = formatter.format(Calendar.getInstance().getTime());
        view.setText(date);
    }
}