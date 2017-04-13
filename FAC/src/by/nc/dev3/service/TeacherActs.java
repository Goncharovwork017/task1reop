package by.nc.dev3.service;

import by.nc.dev3.entities.*;
import by.nc.dev3.exceptions.MyException;
import by.nc.dev3.interfaces.TeacherActions;
import by.nc.dev3.tools.FileWorker;
import by.nc.dev3.tools.Operations;
import sun.plugin2.gluegen.runtime.CPU;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.*;

import static by.nc.dev3.service.StudentActs.student;

/**
 * Created by ivan on 02.04.2017.
 */
public class TeacherActs implements TeacherActions {

    @Override
    public void addCourse() throws MyException {

        Faculty.setCourseList((List<Course>) FileWorker.readObject(FileWorker.getFilePath() + "Faculty.txt"));
        Course course = new Course(Operations.inputString(), Operations.inputNumberforCourse(), Operations.inputString());
        checkCours(course);
        writeCours();
        System.out.println(course);

    }

    public void writeCours() {
        FileWorker.writeObject(Faculty.getCourseList(), new File(FileWorker.getFilePath() + "Faculty.txt"));
        Faculty.getCourseList().removeAll(Faculty.getCourseList());
    }


    public List<Course> checkCours(Course course) throws MyException {
        int flag = 0;
        for (int i = 0; i < Faculty.getCourseList().size(); i++)
            if (course.getTitle().equals(Faculty.getCourseList().get(i).getTitle())) {
                if (course.getAmount() == Faculty.getCourseList().get(i).getAmount()) {
                    Faculty.getCourseList().get(i).setAmount(Faculty.getCourseList().get(i).getAmount() - course.getAmount());
                    flag++;
                } else {
                    flag++;
                    throw new MyException("Невозможно добавить такой курс");
                }
            }
        if (flag == 0)
            Faculty.getCourseList().add(course);
        return Faculty.getCourseList();
    }


    @Override
    public void viewCourse() throws MyException {
        List<Course> list = (List<Course>) FileWorker.readObject(FileWorker.getFilePath() + "Faculty.txt");
        for (Course ob : list)
            System.out.println(ob);


    }

    @Override
    public void viewSheetListStudents() throws MyException {
        SheetList.setMap(FileWorker.readSheetList(FileWorker.getFilePath() + "SheetList.txt"));
        for (Map.Entry<Student, List<Course>> entry : SheetList.getMap().entrySet()) {
            System.out.println("===========================");
            System.out.println("Студент " + entry.getKey());
            System.out.println("Список курсов " + entry.getValue());
            System.out.println("===========================");
        }
    }

    @Override
    public void addTeacher() throws MyException {
        List<Course> list = (List<Course>) FileWorker.readObject(FileWorker.getFilePath() + "Faculty.txt");
        for (Course ob : list)
            System.out.println(ob);
        System.out.println("Введите курс к которому добавить препода:");

        int number = Operations.inputNumber();
        System.out.println("Введите Имя, Фамилию");
        Teacher teacher = new Teacher(Operations.inputString(), Operations.inputString());
        list.get(number - 1).setTeacher(teacher);
        FileWorker.writeObject(list, new File(FileWorker.getFilePath() + "Faculty.txt"));

    }

    @Override
    public void finish() throws MyException {
       // boolean bool;


        List<Course> list = (List<Course>) FileWorker.readObject(FileWorker.getFilePath() + "Faculty.txt");
        for (Course ob : list)
            System.out.println(ob);
        System.out.println("Введите курс который нужно закончить:");
        int number = Operations.inputNumber();
        System.out.println("Введите END");
        StatusFaculty statusFaculty1 = new StatusFaculty(Operations.inputString());
        list.get(number - 1).setStatusFaculty(statusFaculty1);
        FileWorker.writeObject(list, new File(FileWorker.getFilePath() + "Faculty.txt"));
   /*

        SheetList.setMap(FileWorker.readSheetList(FileWorker.getFilePath() + "SheetList.txt"));
        List<Course> courseList = new ArrayList(SheetList.getMap().values());
        for(Course ob : courseList)
            System.out.println(ob);
        System.out.println("Введите курс который нужно закончить:");
        int number = Operations.inputNumber();
        System.out.println("Введите END");
        StatusFaculty statusFaculty1 = new StatusFaculty(Operations.inputString());
        courseList.get(number - 1).setStatusFaculty(statusFaculty1);
        // FileWorker.writeObject(list, new File(FileWorker.getFilePath() + "Faculty.txt"));
        FileWorker.writeSheetList(SheetList.getMap(), new File(FileWorker.getFilePath() + "SheetList.txt"));
*/





        SheetList.setMap(FileWorker.readSheetList(FileWorker.getFilePath() + "SheetList.txt"));
        List<Student> studentList = new ArrayList(SheetList.getMap().keySet());
        for(Student ob : studentList)
            System.out.println(ob);
        System.out.println("Введите студента которому нужна оценка:");
        int number1 = Operations.inputNumber();
        System.out.println("Оценку");
        Mark mark = new Mark(Operations.inputNumber());
        studentList.get(number1 - 1).setMark(mark);
        // FileWorker.writeObject(list, new File(FileWorker.getFilePath() + "Faculty.txt"));
        FileWorker.writeSheetList(SheetList.getMap(), new File(FileWorker.getFilePath() + "SheetList.txt"));


      //  SheetList.setMap(FileWorker.readSheetList(FileWorker.getFilePath() + "SheetList.txt"));
/*
        SheetList.setMap(FileWorker.readSheetList(FileWorker.getFilePath() + "SheetList.txt"));
        List<Student> students = new ArrayList<>();
        for (Map.Entry<Student, List<Course>> entry : SheetList.getMap().entrySet()) {
            System.out.println(entry);}
        System.out.println("Введите студента для оценки:");
        int number2 = Operations.inputNumber();
        System.out.println("Введите END");
        Mark mark = new Mark(Operations.inputNumber());
        students .get(number2 - 1).setMark(mark);
        FileWorker.writeSheetList(SheetList.getMap(), new File(FileWorker.getFilePath() + "SheetList.txt"));
*/
        //  List<Course> courseList = new ArrayList(SheetList.getMap().keySet());

////////////////////////////////////////////////////
     //   List<Course> courseList1 = new ArrayList<>();
     //   SheetList.setMap(FileWorker.readSheetList(FileWorker.getFilePath() + "SheetList.txt"));
     //   for (Map.Entry<Student, List<Course>> entry : SheetList.getMap().entrySet())
       //     System.out.println("Студент " + entry.getKey());

       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      //  String str = Operations.inputString();
////////////////////////////////////////////////////



        }


    }




