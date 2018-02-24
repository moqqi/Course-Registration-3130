package com.example.csci3130_baseproject;
import java.util.ArrayList;
public class CourseDatabase {
    private ArrayList<Course> courseList ;

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public void removeCourse(String id) {
        boolean courseRemoved = false;

        for(int i=0; i<courseList.size(); i++) {
            if(courseList.get(i).getId().equals(id)) {
                courseList.remove(i);
                courseRemoved = true;
            }
        }
		if(courseRemoved==false)
            System.out.print("Course does not exist");
    }

    public void searchByID(String id) {
        for(int i=0; i<courseList.size(); i++)
            if(courseList.get(i).getId().equals(id))
                courseList.get(i).viewCourseInfo();
    }

    public void searchByName(String name) {
        for(int i=0; i<courseList.size(); i++)
            if(courseList.get(i).getName().equals(name))
                courseList.get(i).viewCourseInfo();
    }

	/*public void searchByTime() {

	}*/

    public void getTimetableBySem(String semester) {
        for(int i=0; i<courseList.size(); i++)
            if(courseList.get(i).getSemester().equals(semester)) {
                System.out.println(courseList.get(i).viewCourseInfo() + "\n");
        }

    }

    public void getTimetableByDept(String dept) {
        for(int i=0; i<courseList.size(); i++)
            if(courseList.get(i).getDepartment().equals(dept)) {
                System.out.println(courseList.get(i).viewCourseInfo() + "\n");
        }
    }
}
