package by.nc.dev3.tools;

import by.nc.dev3.entities.Faculty;
import by.nc.dev3.entities.Student;
import by.nc.dev3.entities.Teacher;
import by.nc.dev3.enums.Role;
import by.nc.dev3.enums.SortingIndex;
import by.nc.dev3.enums.StudentAct;
import by.nc.dev3.enums.TeacherAct;

/**
 * Created by ivan on 02.04.2017.
 */
public class Menu {

    private static Student student;
    private static Teacher teacher;

    public static void menu() {
        int flag = 0;
        role:
        while (true) {
            System.out.println("===========================================================");
            System.out.println("==================" + Faculty.getName() + "==================================");
            System.out.println("===========================================================");
            System.out.println("Выберите пользователя:");
            System.out.println("1. Препод");
            System.out.println("2. Студент");
            System.out.println("0. Выход");
            System.out.println("===========================================================");
            out2:

            switch (Operations.inputNumber()) {
                case 1:
                    while (flag == 0) {
                        System.out.println("===========================================================");
                        System.out.println("1. Вход");
                        System.out.println("2. Регистрация");
                        System.out.println("0. Назад");
                        System.out.println("===========================================================");

                        switch (Operations.inputNumber()) {
                            case 1:
                                teacher = (Teacher) Operations.checkUser(Role.TEACHER);
                                flag++;
                                break;
                            case 2:
                                System.out.println("===========================================================");
                                System.out.println("Введите данные об преподе");
                                System.out.println("Имя,Фамилия,Логин,Пароль");
                                teacher = (Teacher) Operations.registrationUser(Role.TEACHER);
                                flag++;
                                break;
                            case 0:
                                System.out.println("===========================================================");
                                System.out.println(flag);
                                break out2;
                            default:
                                System.out.println("===========================================================");
                                System.out.println("Неверный выбор либо формат. Повторите...");
                        }
                    }

                    teacher.fillMap();
                    out:
                    while (true) {
                        System.out.println("===========================================================");
                        System.out.println("1. Добавить курс");
                        System.out.println("2. Показать курсы");
                        System.out.println("3. Показать курсы со студентами");
                        System.out.println("4. Добавить препода к курсу");
                        System.out.println("5. Закончить курс");
                        System.out.println("6. Сортировка курсов");
                        System.out.println("0. Назад");
                        System.out.println("===========================================================");

                        switch (Operations.inputNumber()) {
                            case 1:
                                System.out.println("Title,amount,desc");
                                teacher.doAction(TeacherAct.ADD);
                                break;
                            case 2:

                                teacher.doAction(TeacherAct.VIEW);
                                break;
                            case 3:

                                teacher.doAction(TeacherAct.VIEWSTUDENTSHEETLIST);
                                break;
                            case 4:

                                teacher.doAction(TeacherAct.ADDTEACHER);
                                break;
                            case 5:

                                teacher.doAction(TeacherAct.ENDCURSE);
                                break;

                            case 6:
                                System.out.println("===========================================================");
                                label:
                                while (true) {
                                    System.out.println("1. По Тайтлу");
                                    System.out.println("2. По количеству");
                                    System.out.println("3. По деску");

                                    switch (Operations.inputNumber()) {
                                        case 1:
                                            Operations.sortServices(SortingIndex.TITLE);
                                            break label;
                                        case 2:
                                            Operations.sortServices(SortingIndex.AMOUNT);
                                            break label;
                                        case 3:
                                            Operations.sortServices(SortingIndex.DESC);
                                            break label;
                                        default:
                                            System.out.println("Неверный выбор. Повторите");
                                    }
                                }
                                break;

                            case 0:
                                System.out.println("===========================================================");
                                flag = 0;
                                break;
                            default:
                                System.out.println("===========================================================");
                                System.out.println("Неверный выбор либо формат. Повторите...");
                        }
                        break;

                    }
                case 2:
                    while (flag == 0) {
                        System.out.println("===========================================================");
                        System.out.println("1. Вход");
                        System.out.println("2. Регистрация");
                        System.out.println("0. Назад");
                        System.out.println("===========================================================");

                        switch (Operations.inputNumber()) {
                            case 1:
                                student = (Student) Operations.checkUser(Role.STUDENT);
                                flag++;
                                break;
                            case 2:
                                System.out.println("===========================================================");
                                System.out.println("Введите данные о студенте");
                                System.out.println("Имя,Фамилия,форма обучнеия");
                                student = (Student) Operations.registrationUser(Role.STUDENT);
                                flag++;
                                break;
                            case 0:
                                System.out.println("===========================================================");
                                break out2;
                            default:
                                System.out.println("===========================================================");
                                System.out.println("Неверный выбор либо формат. Повторите...");
                        }
                    }
                    student.fillMap();
                    toMenu:
                    while (true) {
                        System.out.println("===========================================================");
                        System.out.println("1. Показаать все курсы");
                        System.out.println("2. Записаться на курс");
                        System.out.println("3. Показать курсы на которые зарегился");
                        System.out.println("4. Сортировка курсов");
                        System.out.println("0. Назад");
                        System.out.println("===========================================================");

                        switch (Operations.inputNumber()) {
                            case 1:
                                System.out.println("===========================================================");
                                student.doAction(StudentAct.VIEW);
                                break;
                            case 2:
                                System.out.println("===========================================================");
                                student.doAction(StudentAct.RECORDING);
                                break;
                            case 3:
                                System.out.println("===========================================================");
                                student.doAction(StudentAct.VIEWCOURSE);
                                break;
                            case 4:
                                System.out.println("===========================================================");
                                label:
                                while (true) {
                                    System.out.println("1. По Тайтлу");
                                    System.out.println("2. По количеству");
                                    System.out.println("3. По деску");

                                    switch (Operations.inputNumber()) {
                                        case 1:
                                            Operations.sortServices(SortingIndex.TITLE);
                                            break label;
                                        case 2:
                                            Operations.sortServices(SortingIndex.AMOUNT);
                                            break label;
                                        case 3:
                                            Operations.sortServices(SortingIndex.DESC);
                                            break label;
                                        default:
                                            System.out.println("Неверный выбор. Повторите");
                                    }
                                }
                                break;
                            case 0:
                                System.out.println("===========================================================");
                                flag = 0;
                                break toMenu;
                            default:
                                System.out.println("===========================================================");
                                System.out.println("Неверный выбор либо формат. Повторите...");
                        }
                    }
                    break;
                case 0:
                    System.out.println("===========================================================");
                    System.out.println("Работа завершена...");
                    System.out.println("===========================================================");
                    System.exit(0);
                default:
                    System.out.println("===========================================================");
                    System.out.println("Неверный выбор либо формат. Повторите...");
            }
        }
    }
}