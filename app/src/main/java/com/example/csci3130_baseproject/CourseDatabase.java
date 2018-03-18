package com.example.csci3130_baseproject;
import java.util.ArrayList;
public class CourseDatabase {
    private ArrayList<Course> courseList = new ArrayList<Course>();

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public void removeCourse(String id) {
        if(courseList.size()<1)
            return;

        boolean courseRemoved = false;

        for(int i=0; i<courseList.size(); i++) {
            if(courseList.get(i).getId().equals(id)) {
                courseList.remove(i);
                courseRemoved = true;
            }
        }
		//if(courseRemoved==false)
          //  System.out.print("Course does not exist");
    }

    public Course searchByID(String id) {
        if(courseList.size()<1) return null;

        for(int i=0; i<courseList.size(); i++) {
            if (courseList.get(i).getId().equals(id))
                return courseList.get(i);
                //courseList.get(i).viewCourseInfo();
        }

        return null;
    }

    public Course searchByName(String name) {
        if(courseList.size()<1) return null;

        for(int i=0; i<courseList.size(); i++) {
            if (courseList.get(i).getName().equals(name))
                return courseList.get(i);
                //courseList.get(i).viewCourseInfo();
        }

        return null;
    }

	/*public void searchByTime() {

	}*/

    /*public void getTimetableBySem(String semester) {
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
    }*/
}
