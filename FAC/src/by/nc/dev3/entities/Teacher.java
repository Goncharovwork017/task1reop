package by.nc.dev3.entities;

import by.nc.dev3.commands.*;
import by.nc.dev3.enums.TeacherAct;
import by.nc.dev3.exceptions.MyException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivan on 02.04.2017.
 */
public class Teacher extends User implements Serializable {
    private String login;
    private String password;
    private Map<TeacherAct, ActCommandTeacher> acts = new HashMap<>();

    public Teacher() {
    }

    public Teacher(String name, String surname) {
        super(name, surname);
    }

    public Teacher(String name, String surname, String login, String password) {
        super(name, surname);
        this.login = login;
        this.password = password;
    }

    public void fillMap() {
        acts.put(TeacherAct.ADD, new AddCommandTeacher());
        acts.put(TeacherAct.VIEW, new ViewCommandTeacher());
        acts.put(TeacherAct.VIEWSTUDENTSHEETLIST, new ViewListCommandStudent());
        acts.put(TeacherAct.ADDTEACHER, new AddTecherCommandTeacher());
        acts.put(TeacherAct.ENDCURSE, new FinishCommandTeacher());
    }



    public void doAction(TeacherAct act) {
        for (Map.Entry<TeacherAct, ActCommandTeacher> entry : acts.entrySet()) {
            if (act.equals(entry.getKey())) {
                try {
                    entry.getValue().execute();
                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }














        public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (login != null ? !login.equals(teacher.login) : teacher.login != null) return false;
        return password != null ? password.equals(teacher.password) : teacher.password == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name="+ getName() +'\''  +
                ", surname="+ getSurname() +'\''  +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
