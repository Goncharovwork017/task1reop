package by.nc.dev3.interfaces;

import by.nc.dev3.exceptions.MyException;

/**
 * Created by ivan on 02.04.2017.
 */
public interface TeacherActions {

    void addCourse() throws MyException;
    void viewCourse() throws MyException;
    void viewSheetListStudents() throws  MyException;
    void addTeacher() throws  MyException;
    void finish() throws MyException;

}
