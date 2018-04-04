package com.example.csci3130_baseproject;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void viewCourseInfoTest() throws Exception {
        Course testCourse = new Course();
        testCourse.setName("CS1000");
        testCourse.setDepartment("Computer Science");
        //testCourse.setSemester("Fall");
        testCourse.setId("2");
        testCourse.setCapacity(100);

        assertEquals("Computer Science\tSemester: Fall\n2: CS1000\nCapacity: 100", testCourse.viewCourseInfo());
    }

    @Test
    public void loginTest() throws Exception {
        User testUser = new User();
        testUser.setEmail("test@test.com");
        testUser.setPassword("testPassword");
        UserDatabase testDB = new UserDatabase();
        //testDB.add(testUser);

        assertEquals(true, testDB.login("test@test.com", "testPassword"));
    }

    @Test
    public void loginTestWrongPW() throws Exception {
        User testUser = new User();
        testUser.setEmail("test@test.com");
        testUser.setPassword("testPassword");
        UserDatabase testDB = new UserDatabase();
        //testDB.add(testUser);

        assertEquals(false, testDB.login("test@test.com", "wrongpassword"));
    }

    @Test
    public void loginTestWrongEmail() throws Exception {
        User testUser = new User();
        testUser.setEmail("test@test.com");
        testUser.setPassword("testPassword");
        UserDatabase testDB = new UserDatabase();
        //testDB.add(testUser);

        assertEquals(false, testDB.login("test@fake.com", "testPassword"));
    }

    @Test
    public void searchIDTest() throws Exception {
        Course testCourse = new Course();
        testCourse.setId("100");
        CourseDatabase testDB = new CourseDatabase();
        //testDB.addCourse(testCourse);

        assertEquals(testCourse, testDB.searchByID("100"));
    }

    @Test
    public void failedSearchIDTest() throws Exception {
        Course testCourse = new Course();
        testCourse.setId("100");
        CourseDatabase testDB = new CourseDatabase();
        //testDB.addCourse(testCourse);

        assertEquals(null, testDB.searchByID("200"));
    }

    @Test
    public void searchNameTest() throws Exception {
        Course testCourse = new Course();
        testCourse.setName("Test");
        CourseDatabase testDB = new CourseDatabase();
        //testDB.addCourse(testCourse);

        assertEquals(testCourse, testDB.searchByName("Test"));
    }

    @Test
    public void failedSearchNameTest() throws Exception {
        Course testCourse = new Course();
        testCourse.setName("Test");
        CourseDatabase testDB = new CourseDatabase();
        //testDB.addCourse(testCourse);

        assertEquals(null, testDB.searchByName("Wrong"));
    }

    @Test
    public void removeCourseTest() throws Exception {
        Course testCourse = new Course();
        testCourse.setId("100");
        CourseDatabase testDB = new CourseDatabase();
        //testDB.addCourse(testCourse);
        //testDB.removeCourse("100");

        assertEquals(null, testDB.searchByName("100"));
    }
}