package by.traning.nc.dev3.beans;

/**
 * Created by ivan on 14.04.2017.
 */
public class Course extends Entity {
    private int idCourse;
    private String name;
    private int teacher;
    private String courseDescription;


    @Override
    public String toString() {
        return "Course{" +
                "idCourse=" + idCourse +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", courseDescription='" + courseDescription + '\'' +

                '}';
    }



    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }


}
