package by.nc.dev3.entities;

import java.io.Serializable;

/**
 * Created by ivan on 02.04.2017.
 */
public class Course implements Serializable {

    private String title;
    private int amount;
    private String description;


// private boolean

    private Teacher teacher;


    private StatusFaculty statusFaculty;


  //  private List<Student> studentList = new ArrayList<>();

   // private Set<Teacher> teacherSet = new HashSet<>();

    private static int numberObjects;





    public Course() {
        numberObjects++;
    }

    public Course(StatusFaculty statusFaculty) {
        this.statusFaculty = statusFaculty;
    }

    public Course(String title, int amount, String description) {
        this.title = title;
        this.amount = amount;
        this.description = description;
        numberObjects++;
    }



    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", status='" + statusFaculty + '\'' +
                ", teacher='" + teacher + '\'' +
             //   ", mark='" + mark + '\''+
                '}';
    }


    public StatusFaculty getStatusFaculty() {
        return statusFaculty;
    }

    public void setStatusFaculty(StatusFaculty statusFaculty) {
        this.statusFaculty = statusFaculty;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getNumberObjects() {
        return numberObjects;
    }

    public static void setNumberObjects(int numberObjects) {
        Course.numberObjects = numberObjects;
    }
}
