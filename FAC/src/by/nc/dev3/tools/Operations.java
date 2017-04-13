package by.nc.dev3.tools;

import by.nc.dev3.entities.*;
import by.nc.dev3.enums.Role;
import by.nc.dev3.enums.SortingIndex;
import by.nc.dev3.exceptions.InvalidSerializationException;

import java.util.*;

/**
 * Created by ivan on 02.04.2017.
 */
public class Operations {

    private static FileWorker sz = new FileWorker();
    private static Scanner input = new Scanner(System.in);

    private Operations() {
    }

    public static String inputString() {
        input = new Scanner(System.in);
        return input.next();
    }


    public static void sortServices(SortingIndex index) {
        Faculty.setCourseList((List<Course>) FileWorker.readObject(FileWorker.getFilePath() + "Faculty.txt"));
        Collections.sort(Faculty.getCourseList(), new ServiceComparator(index));
        for (Course course : Faculty.getCourseList())
            System.out.println(course);
    }


    public static User registrationUser(Role role) {
        String teachers = FileWorker.getFilePath() + "teachers.txt";
        String students = FileWorker.getFilePath() + "students.txt";
        boolean in;
        if (role.equals(role.TEACHER)) {
            Teacher teacher = new Teacher(Operations.inputString(),Operations.inputString(), Operations.inputString(), Operations.inputString());
            System.out.println(teacher);
            in = sz.serialization(teacher, teachers);
            return teacher;
        } else if (role.equals(role.STUDENT)) {
            Student student = new Student(Operations.inputString(),Operations.inputString(),Operations.inputString());
            System.out.println(student);
            in = sz.serialization(student, students);
            return student;
        } else return null;
    }

    public static User checkUser(Role role) {
        int flag = 0;
        String teachers = FileWorker.getFilePath() + "teachers.txt";
        String students = FileWorker.getFilePath() + "students.txt";
        boolean in;
        User res = null;
        int flag1 = 0;
        if (role.equals(role.TEACHER)) {
            try {
                res = (Teacher) sz.deserialization(teachers);
            } catch (InvalidSerializationException e) {
                System.out.println(e.getMessage()+ ", зарегистрируйтесь под администратором");
                res = registrationUser(role.TEACHER);
            }
            System.out.println(res);
            do {
                System.out.println("Введите данные об преподе");
                Teacher teacher = new Teacher(Operations.inputString(),Operations.inputString(), Operations.inputString(), Operations.inputString());
                if (teacher.equals(res)) {
                    flag1 = 1;
                }
            } while (flag1 == 0);
        } else if (role.equals(role.STUDENT)) {
            try {
                res = (Student) sz.deserialization(students);
            } catch (InvalidSerializationException e) {
                System.out.println(e.getMessage() + ", зарегистрируйтесь под студентом");
                res = registrationUser(role.STUDENT);
            }
            System.out.println(res);
            do {
                System.out.println("Введите данные о студенте");
                Student student = new Student(Operations.inputString(), Operations.inputString(), Operations.inputString());
                if (student.equals(res)) {
                    flag1 = 1;
                }
            } while (flag1 == 0);
        }
        return res;
    }

    public static int inputNumber() {
        int number = -1;
        while (number < 0) {
            try {
                input = new Scanner(System.in);
                number = input.nextInt();
                if (number  >= 0) {
                    return number;
                } else {
                    System.out.println("Параметр не может быть отрицательным. Повторите ввод...");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат. Повторите ввод...");
                continue;
            }
        }
        return 0;
    }



    public static int inputNumberforCourse() {
        int number = -1;
        while (number <= 0) {
            try {
                input = new Scanner(System.in);
                number = input.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Параметр не может быть отрицательным, либо 0. Повторите ввод...");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат. Повторите ввод...");
                continue;
            }
        }
        return 0;
    }



}

