package by.nc.dev3.entities;

import java.io.Serializable;
import java.util.*;

/**
 * Created by ivan on 02.04.2017.
 */
public class Faculty implements Serializable {


    private final static String name = "training.by";

  //  private Course course;????????????????????????????????
    private Teacher teacher;
    private StatusFaculty statusFaculty;

    private static List<Course> courseList = new ArrayList<>();

    private static Map<Teacher, Course> teacherCourseMap = new HashMap<>();



    public Faculty() {
    }

    public static String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public StatusFaculty getStatusFaculty() {
        return statusFaculty;
    }

    public void setStatusFaculty(StatusFaculty statusFaculty) {
        this.statusFaculty = statusFaculty;
    }

    public static List<Course> getCourseList() {
        return courseList;
    }

    public static void setCourseList(List<Course> courseList) {
        Faculty.courseList = courseList;
    }
}
