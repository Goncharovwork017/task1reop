package by.nc.dev3.entities;

import by.nc.dev3.commands.ActCommandStudent;
import by.nc.dev3.commands.RecordingCommandStudent;
import by.nc.dev3.commands.ViewCommandStudent;
import by.nc.dev3.commands.ViewRecCommandStudent;
import by.nc.dev3.enums.StudentAct;
import by.nc.dev3.exceptions.InvalidSerializationException;
import by.nc.dev3.exceptions.MyException;
import by.nc.dev3.service.StudentActs;
import by.nc.dev3.tools.FileWorker;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ivan on 02.04.2017.
 */
public class Student extends User implements Serializable {

    private String study;
    private Mark mark;
  //  private String mark;
  private String review;
    private Map<StudentAct, ActCommandStudent> acts = new HashMap<>();

    public Student(String review) {
        this.review = review;
    }


    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void fillMap() {
        acts.put(StudentAct.RECORDING, new RecordingCommandStudent());
        acts.put(StudentAct.VIEW, new ViewCommandStudent());
        acts.put(StudentAct.VIEWCOURSE, new ViewRecCommandStudent());

    }

   // private List<Mark> markList = new ArrayList<>();


    public void doAction(StudentAct act){
        System.out.println(this);
        FileWorker sz = new FileWorker();
        String students = FileWorker.getFilePath() + "students.txt";
        Student res = null;
        try {
            res = (Student) sz.deserialization(students);
        } catch (InvalidSerializationException e) {
            System.out.println(e.getMessage());
        }
        new StudentActs(res);
        for (Map.Entry<StudentAct, ActCommandStudent> entry : acts.entrySet()) {
            if (act.equals(entry.getKey())) {
                try {
                    entry.getValue().execute();
                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


    public Student() {
    }



    public Student(String name, String surname, String study) {
        super(name, surname);
        this.study = study;
    }

    public Student(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return study != null ? study.equals(student.study) : student.study == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (study != null ? study.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name="+ getName() +'\''  +
                ", surname="+ getSurname() +'\''  +
                ", study='" + study + '\'' +
                ", mark='" + mark + '\''+
                '}';
    }
}
