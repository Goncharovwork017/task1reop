package by.nc.dev3.service;

import by.nc.dev3.entities.Course;
import by.nc.dev3.entities.Faculty;
import by.nc.dev3.entities.SheetList;
import by.nc.dev3.entities.Student;
import by.nc.dev3.enums.Role;
import by.nc.dev3.exceptions.MyException;
import by.nc.dev3.interfaces.StudentActions;
import by.nc.dev3.tools.FileWorker;
import by.nc.dev3.tools.Operations;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by ivan on 02.04.2017.
 */
public class StudentActs implements StudentActions {
    public static Student student;

    public StudentActs() {
    }

    public StudentActs(Student student) {
        this.student = student;
    }

    @Override
    public void recCourse() throws MyException {
        int flag = 0;
        Faculty.setCourseList((List<Course>) FileWorker.readObject(FileWorker.getFilePath() + "Faculty.txt"));
        String title = Operations.inputString();
        SheetList.setMap(FileWorker.readSheetList(FileWorker.getFilePath() + "SheetList.txt"));
        for(Iterator<Course> it = Faculty.getCourseList().iterator(); it.hasNext();){
            Course course = it.next();
            if(title.equals(course.getTitle())){
                flag++;
                int amount = 1;
                if(amount < course.getAmount()){
                    course.setAmount(course.getAmount() - amount);

                    checkStudent(title,  amount, course);
                    FileWorker.writeObject(Faculty.getCourseList(), new File(FileWorker.getFilePath() + "Faculty.txt"));
                    break;
                } else
                    throw new MyException("Нету места для записи на курс");
            }
        }
        if (flag == 0)
            throw new MyException("курса с таким названием нет");
    }


    public void checkStudent(String title, int amount, Course course) {
        int g = 0;
        List<Course> list = new ArrayList<>();
        for (Map.Entry<Student, List<Course>> entry : SheetList.getMap().entrySet()) {
            if (student.equals(entry.getKey())) {
                list = entry.getValue();
                SheetList.getMap().put(student, checkMapSheetList(list, new Course(title, amount, course.getDescription())));
                g++;
            }
        }
        if (g == 0) {
            SheetList.getCourseList().removeAll(SheetList.getCourseList());
            SheetList.getMap().put(student, checkMapSheetList(list, new Course(title, amount, course.getDescription())));
        }
        FileWorker.writeSheetList(SheetList.getMap(), new File(FileWorker.getFilePath() + "SheetList.txt"));
    }
    public List<Course> checkMapSheetList(List<Course> list, Course course) {
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(course.getTitle())) {
                list.get(i).setAmount(course.getAmount() - list.get(i).getAmount());
                flag++;
                break;
            }
        }
        if (flag == 0)
            list.add(course);
        return list;
    }








    @Override
    public void viewAllCourse() throws MyException {
        Faculty.setCourseList((List<Course>) FileWorker.readObject(FileWorker.getFilePath() + "Faculty.txt"));
        for (Course ob : Faculty.getCourseList())
            System.out.println(ob);
    }

    @Override
    public void viewRecCourse() throws MyException {
        String namelist = null;
        for (Map.Entry<Student, List<Course>> entry : FileWorker.readSheetList(FileWorker.getFilePath() + "SheetList.txt").entrySet()) {
            if (student.equals(entry.getKey())) {
                System.out.println("===========================");
                System.out.println(entry.getKey());
                System.out.println("Записи на курсы "+"\n" + entry.getValue());
                System.out.println("===========================");
                for (Course course : entry.getValue()) {
                    namelist += course.getTitle() + "," + course.getTeacher();
                }
            }
        }
        SheetList.setNameList(namelist);
    }
}

