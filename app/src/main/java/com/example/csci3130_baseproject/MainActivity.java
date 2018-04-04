package com.example.csci3130_baseproject;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * MainActivity Class that handles view states of application.
 */
public class MainActivity extends AppCompatActivity {
    private static CourseDatabase courses = new CourseDatabase();
    private static UserDatabase users = new UserDatabase();
    private MyApplicationData myApplicationData;

    /**
     * Sets content view to activity main and calls super onCreate.
     * @param savedInstanceState previously saved Instance State.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myApplicationData = new MyApplicationData();



        /**courses**/
        //science
        Course sci1 = new Course("Intro to Biology", "100", "BIOL", new ArrayList<User>(), "8:30", "9:30", 500, 500, new ArrayList<User>());
        Course sci2 = new Course("Organic Chemistry", "240", "CHEM", new ArrayList<User>(), "11:30", "12:30", 75, 60, new ArrayList<User>());
        Course sci3 = new Course("Physical Cosmology", "435", "PHYC", new ArrayList<User>(), "1:30", "2:30", 40, 20, new ArrayList<User>());
        Course sci4 = new Course("Animal Behaviour", "350", "NESC", new ArrayList<User>(), "9:30", "10:30", 100, 40, new ArrayList<User>());

        //business and economics
        Course bande1 = new Course("Strategy Implementation", "460", "BUSI", new ArrayList<User>(), "2:30", "3:30", 50, 30, new ArrayList<User>());
        Course bande2 = new Course("Innovation Management", "320", "BUSI", new ArrayList<User>(), "10:30", "11:30", 100, 100, new ArrayList<User>());
        Course bande3 = new Course("Intro to Macroeconomics", "110", "ECON", new ArrayList<User>(), "10:30", "11:30", 300, 250, new ArrayList<User>());
        Course bande4 = new Course("Public Finance", "310", "ECON", new ArrayList<User>(), "3:30", "4:30", 150, 50, new ArrayList<User>());

        //engineering
        Course eng1 = new Course("Engineering Design", "200", "ENGI", new ArrayList<User>(), "9:30", "10:30", 200, 100, new ArrayList<User>());
        Course eng2 = new Course("Mechanics of Materials", "260", "ENGI", new ArrayList<User>(), "4:30", "5:30", 200, 100, new ArrayList<User>());
        Course eng3 = new Course("Thermo-Fluid Engineering", "330", "ENGI", new ArrayList<User>(), "1:30", "2:30", 150, 140, new ArrayList<User>());
        Course eng4 = new Course("Engineering Design", "120", "ENGI", new ArrayList<User>(), "11:30", "12:30", 300, 200, new ArrayList<User>());

        //other
        Course other1 = new Course("Software Engineering", "350", "CSCI", new ArrayList<User>(), "8:30", "9:30", 100, 90, new ArrayList<User>());
        Course other2 = new Course("Ancient Greek Philosophy", "240", "PHIL", new ArrayList<User>(), "9:30", "10:30", 200, 100, new ArrayList<User>());
        Course other3 = new Course("American Literature", "310", "ENGL", new ArrayList<User>(), "11:30", "12:30", 50, 20, new ArrayList<User>());
        Course other4 = new Course("Basic French", "120", "FREN", new ArrayList<User>(), "2:30", "3:30", 30, 10, new ArrayList<User>());

        /**users**/
        //empty course list
        ArrayList<Course> user1Courses = new ArrayList<Course>();
        ArrayList<Course> user2Courses = new ArrayList<Course>();
        ArrayList<Course> user3Courses = new ArrayList<Course>();
        ArrayList<Course> user4Courses = new ArrayList<Course>();

        //starting users
        //this user has a full course load, no waitlist
        User user1 = new User("120", "janesmith@dal.ca", "dalhousie", user1Courses);
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
        User user2 = new User("333", "johndoe@dal.ca", "baseball", user2Courses);
        user2.getCourses().add(eng3);
        eng3.getStudents().add(user2);
        user2.getCourses().add(eng4);
        eng4.getStudents().add(user2);
        user2.getCourses().add(bande3);
        bande3.getStudents().add(user2);
        user2.getCourses().add(bande4);
        bande4.getStudents().add(user2);

        //2 waitlisted course, 1 regular course
        User user3 = new User("653", "jasonmacdonald@dal.ca", "thebeatles", user3Courses);
        user3.getCourses().add(sci1);
        sci1.getWaitlist().add(user3);
        user3.getCourses().add(bande2);
        bande2.getWaitlist().add(user3);
        user3.getCourses().add(other4);
        other4.getStudents().add(user3);

        //no courses added yet
        User user4 = new User("738", "lisahunt@dal.ca", "soccer", user4Courses);

        //adding all courses and all users to the database
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

        //user database
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        //Get the app wide shared variables
        /**
        DatabaseReference firebaseDatabase= FirebaseDatabase.getInstance().getReference("user");


        UserDatabase testUserDatebase = new UserDatabase();
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
        String courseCode = ((Button)v).getText().toString();

        //searching for the course
        Course course = new Course();

        for (int i = 0; i < courses.size(); i++) {
            if (courses.getCourse(i).courseCode().equals(courseCode))
                course = courses.getCourse(i);
        }

        setContentView(R.layout.course_info);

        ((TextView)findViewById(R.id.courseInfo)).setText(course.viewCourseInfo());

        if(this.myApplicationData.getMainUser().contains(course))
            ((Button)findViewById(R.id.addDropButton)).setText("Drop");
        else
            ((Button)findViewById(R.id.addDropButton)).setText("Add");

        this.myApplicationData.setMainCourse(course);
    }

    /**
            * Method for adding or dropping a course.
            * @param v Current View of application.
     */
    public void addDropCourse(View v) {
        //grabbed for legibility
        User user = this.myApplicationData.getMainUser();
        Course course = this.myApplicationData.getMainCourse();
        Button button = (Button)v;

        if(user.getCourses().contains(course)==true) {
            ((TextView) findViewById(R.id.addDropFeedback)).setText("Course dropped");
            user.getCourses().remove(course);
            button.setText("Add");

            if(course.isOnWaitlist(user)==true)
                course.removeFromWaitlist(user);
            else
                course.decreaseCurrent();

            ((TextView)findViewById(R.id.courseInfo)).setText(course.viewCourseInfo());
        }
        else {
            if(user.getCourses().size()==5) {
                ((TextView) findViewById(R.id.addDropFeedback)).setText("The maximum allowable courses has already been reached");
            }
            else if(course.isFull()==true) {
                ((TextView) findViewById(R.id.addDropFeedback)).setText("Added to the waitlist");
                user.getCourses().add(course);
                course.addToWaitlist(user);
                button.setText("Drop");
                ((TextView)findViewById(R.id.courseInfo)).setText(course.viewCourseInfo());
            }
            else if(user.conflictCheck(course)==null) {
                ((TextView) findViewById(R.id.addDropFeedback)).setText("Course added");
                user.getCourses().add(course);
                course.increaseCurrent();
                button.setText("Drop");
                ((TextView)findViewById(R.id.courseInfo)).setText(course.viewCourseInfo());
            }
            else {
                ((TextView) findViewById(R.id.addDropFeedback)).setText("Schedule conflict with " + user.conflictCheck(course).getName());
            }
        }
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
            this.myApplicationData.setMainCourse(course);
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

            //invisible by default
            course1.setVisibility(View.INVISIBLE);
            course2.setVisibility(View.INVISIBLE);
            course3.setVisibility(View.INVISIBLE);
            course4.setVisibility(View.INVISIBLE);

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
                course1.setVisibility(View.VISIBLE);

                if(courseNames.get(1)!=null) {
                    course2.setText(courseNames.get(1));
                    course2.setVisibility(View.VISIBLE);
                }

                if(courseNames.get(2)!=null) {
                    course3.setText(courseNames.get(2));
                    course3.setVisibility(View.VISIBLE);
                }

                if(courseNames.get(3)!=null) {
                    course4.setText(courseNames.get(3));
                    course4.setVisibility(View.VISIBLE);
                }
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

            //invisible by default
            course1.setVisibility(View.INVISIBLE);
            course2.setVisibility(View.INVISIBLE);
            course3.setVisibility(View.INVISIBLE);
            course4.setVisibility(View.INVISIBLE);

            //creating a list to add for populating the buttons
            ArrayList<String> courseNames = new ArrayList<String>();

            for (int i = 0; i < courses.size(); i++) {
                if (courses.getCourse(i).getDepartment().equals("ENGI"))
                    courseNames.add(courses.getCourse(i).courseCode());
            }

            if(courseNames.size()>0) {
                course1.setText(courseNames.get(0));
                course1.setVisibility(View.VISIBLE);

                if(courseNames.get(1)!=null) {
                    course2.setText(courseNames.get(1));
                    course2.setVisibility(View.VISIBLE);
                }

                if(courseNames.get(2)!=null) {
                    course3.setText(courseNames.get(2));
                    course3.setVisibility(View.VISIBLE);
                }

                if(courseNames.get(3)!=null) {
                    course4.setText(courseNames.get(3));
                    course4.setVisibility(View.VISIBLE);
                }
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

            //invisible by default
            course1.setVisibility(View.INVISIBLE);
            course2.setVisibility(View.INVISIBLE);
            course3.setVisibility(View.INVISIBLE);
            course4.setVisibility(View.INVISIBLE);

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
                course1.setVisibility(View.VISIBLE);

                if(courseNames.get(1)!=null) {
                    course2.setText(courseNames.get(1));
                    course2.setVisibility(View.VISIBLE);
                }

                if(courseNames.get(2)!=null) {
                    course3.setText(courseNames.get(2));
                    course3.setVisibility(View.VISIBLE);
                }

                if(courseNames.get(3)!=null) {
                    course4.setText(courseNames.get(3));
                    course4.setVisibility(View.VISIBLE);
                }
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

            //invisible by default
            course1.setVisibility(View.INVISIBLE);
            course2.setVisibility(View.INVISIBLE);
            course3.setVisibility(View.INVISIBLE);
            course4.setVisibility(View.INVISIBLE);

            //creating a list to add for populating the buttons
            ArrayList<String> courseNames = new ArrayList<String>();

            for (int i = 0; i < courses.size(); i++) {
                if (courses.getCourse(i).getDepartment().equals("BUSI") ||
                        courses.getCourse(i).getDepartment().equals("ECON"))
                    courseNames.add(courses.getCourse(i).courseCode());
            }

            if(courseNames.size()>0) {
                course1.setText(courseNames.get(0));
                course1.setVisibility(View.VISIBLE);

                if(courseNames.get(1)!=null) {
                    course2.setText(courseNames.get(1));
                    course2.setVisibility(View.VISIBLE);
                }

                if(courseNames.get(2)!=null) {
                    course3.setText(courseNames.get(2));
                    course3.setVisibility(View.VISIBLE);
                }

                if(courseNames.get(3)!=null) {
                    course4.setText(courseNames.get(3));
                    course4.setVisibility(View.VISIBLE);
                }
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
        if(this.myApplicationData.getMainUser().getCourses().size()>0) {
            setContentView(R.layout.daily_schedule_activity);

            TextView course1 = (TextView) findViewById(R.id.schedule1);
            TextView course2 = (TextView) findViewById(R.id.schedule2);
            TextView course3 = (TextView) findViewById(R.id.schedule3);
            TextView course4 = (TextView) findViewById(R.id.schedule4);
            TextView course5 = (TextView) findViewById(R.id.schedule5);

            ArrayList<String> courseSchedule = new ArrayList<String>();

            for (int i = 0; i < this.myApplicationData.getMainUser().getCourses().size(); i++) {
                courseSchedule.add(this.myApplicationData.getMainUser().getCourses().get(i).getSchedule());
            }

            if(courseSchedule.size()>0) {
                course1.setText(courseSchedule.get(0));

                if (courseSchedule.size() > 1)
                    course2.setText(courseSchedule.get(1));

                if (courseSchedule.size() > 2)
                    course3.setText(courseSchedule.get(2));

                if (courseSchedule.size() > 3)
                    course4.setText(courseSchedule.get(3));

                if (courseSchedule.size() > 4)
                    course5.setText(courseSchedule.get(4));
            }
        }
    }

    /**
     * Method for enterring the course info UI section of application.
     * @param v Current View of application.
     */
    public void enterMyCourses(View v) {
        if(this.myApplicationData.getMainUser().getCourses().size()>0) {
            setContentView(R.layout.mycourses_activity);

            Button course1 = (Button) findViewById(R.id.mycourse1);
            Button course2 = (Button) findViewById(R.id.mycourse2);
            Button course3 = (Button) findViewById(R.id.mycourse3);
            Button course4 = (Button) findViewById(R.id.mycourse4);
            Button course5 = (Button) findViewById(R.id.mycourse5);

            //invisible by default
            course1.setVisibility(View.INVISIBLE);
            course2.setVisibility(View.INVISIBLE);
            course3.setVisibility(View.INVISIBLE);
            course4.setVisibility(View.INVISIBLE);
            course5.setVisibility(View.INVISIBLE);

            //white by default
            course1.setTextColor(Color.WHITE);
            course2.setTextColor(Color.WHITE);
            course3.setTextColor(Color.WHITE);
            course4.setTextColor(Color.WHITE);
            course5.setTextColor(Color.WHITE);

            ArrayList<String> courseNames = new ArrayList<String>();

            for (int i = 0; i < this.myApplicationData.getMainUser().getCourses().size(); i++) {
                courseNames.add(this.myApplicationData.getMainUser().getCourses().get(i).courseCode());
            }

            if(courseNames.size()>0) {
                course1.setText(courseNames.get(0));
                course1.setVisibility(View.VISIBLE);

                if(courses.searchByCode(course1.getText().toString()).isOnWaitlist(this.myApplicationData.getMainUser()) == true)
                    course1.setTextColor(Color.parseColor("#ffff4444"));

                if(courseNames.size()>1) {
                    course2.setText(courseNames.get(1));
                    course2.setVisibility(View.VISIBLE);

                   if(courses.searchByCode(course2.getText().toString()).isOnWaitlist(this.myApplicationData.getMainUser())==true)
                       course2.setTextColor(Color.parseColor("#ffff4444"));
                }

                if(courseNames.size()>2) {
                    course3.setText(courseNames.get(2));
                    course3.setVisibility(View.VISIBLE);

                    if(courses.searchByCode(course3.getText().toString()).isOnWaitlist(this.myApplicationData.getMainUser())==true)
                        course3.setTextColor(Color.parseColor("#ffff4444"));
                }

                if(courseNames.size()>3) {
                    course4.setText(courseNames.get(3));
                    course4.setVisibility(View.VISIBLE);

                    if(courses.searchByCode(course4.getText().toString()).isOnWaitlist(this.myApplicationData.getMainUser())==true)
                        course4.setTextColor(Color.parseColor("#ffff4444"));
                }

                if(courseNames.size()>4) {
                    course5.setText(courseNames.get(4));
                    course5.setVisibility(View.VISIBLE);

                    if(courses.searchByCode(course5.getText().toString()).isOnWaitlist(this.myApplicationData.getMainUser())==true)
                        course5.setTextColor(Color.parseColor("#ffff4444"));

                }
            }

        }
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
    public void logout(View v) {
        this.myApplicationData.setMainUser(null);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method for going back to home screen of application.
     * @param v Current View of application.
     */
    public void enterUserFromCourse(View v) {
        ((Button)v).setText("");
        this.myApplicationData.setMainCourse(null);
        setContentView(R.layout.user_activity);
    }

    /**
     * Method for login.
     * @param v Current View of application.
     */
    public void login(View v) {
        EditText userField = findViewById(R.id.username);
        EditText pwField = findViewById(R.id.password);
        String username = userField.getText().toString();
        String password = pwField.getText().toString();
        User loginResult = users.login(username, password);

        //String testSize = (String)users.getUsers().size();
        TextView text = findViewById(R.id.loginMessage);
        text.setText("Invalid login information, please try again");
        if(loginResult != null){
            //set the current user
            this.myApplicationData.setMainUser(loginResult);
            setContentView(R.layout.user_activity);
        }
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