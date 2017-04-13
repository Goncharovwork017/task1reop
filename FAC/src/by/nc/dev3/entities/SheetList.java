package by.nc.dev3.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ivan on 04.04.2017.
 */
public class SheetList implements Serializable {

    private static List<Course> courseList = new ArrayList<>();
    private static Map<Student, List<Course>> map = new HashMap<>();






    private static String nameList;



    public SheetList() {
    }



    public static List<Course> getCourseList() {
        return courseList;
    }

    public static String getNameList() {
        return nameList;
    }

    public static void setNameList(String nameList) {
        SheetList.nameList = nameList;
    }

    public static void setCourseList(List<Course> courseList) {
        SheetList.courseList = courseList;
    }

    public static Map<Student, List<Course>> getMap() {
        return map;
    }

    public static void setMap(Map<Student, List<Course>> map) {
        SheetList.map = map;
    }
}
