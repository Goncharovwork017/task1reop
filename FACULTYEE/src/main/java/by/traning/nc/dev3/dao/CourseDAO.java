package by.traning.nc.dev3.dao;



import by.traning.nc.dev3.beans.Course;
import by.traning.nc.dev3.beans.SheetList;
import by.traning.nc.dev3.beans.User;
import by.traning.nc.dev3.beans.UserSHeetlist;
import by.traning.nc.dev3.connectionpool.ConnectionPool;
import by.traning.nc.dev3.dao.DAOImpl.CourseDAOImpl;
import by.traning.nc.dev3.finals.NamesTable;
import by.traning.nc.dev3.finals.Parameters;
import by.traning.nc.dev3.finals.SqlRequests;

import javax.print.attribute.standard.MediaSize;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 14.04.2017.
 */
public class CourseDAO implements CourseDAOImpl<Course> {
    @Override
    public List<Course> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_COURSE);
        ResultSet resultSet = statement.executeQuery();
        List<Course> courseList = new ArrayList<>();

        while(resultSet.next()){
            Course course = new Course();
            course.setIdCourse(Integer.parseInt(resultSet.getString(NamesTable.COURSE_ID)));
            course.setName(resultSet.getString(NamesTable.COURSE_NAME));
            course.setTeacher(resultSet.getInt(NamesTable.COURSE_ID_TEACHER));
            course.setCourseDescription(resultSet.getString(NamesTable.COURSE_DESC));
            course.setStatus(resultSet.getString(NamesTable.COURSE_STATUS));
            courseList.add(course);
        }

        ConnectionPool.INSTANCE.initConnection(connection);
        return courseList;
    }


    public List<Course> findAvailableCourses(String login) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.FIND_CHECK_COURSE);
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        List<Course> courseList = new ArrayList<>();

        while(resultSet.next()){
            Course course = new Course();
            course.setIdCourse(Integer.parseInt(resultSet.getString(NamesTable.COURSE_ID)));
            course.setName(resultSet.getString(NamesTable.COURSE_NAME));
            course.setTeacher(resultSet.getInt(NamesTable.COURSE_ID_TEACHER));
            course.setCourseDescription(resultSet.getString(NamesTable.COURSE_DESC));
            course.setStatus(resultSet.getString(NamesTable.COURSE_STATUS));
            courseList.add(course);
        }

        ConnectionPool.INSTANCE.initConnection(connection);
        return courseList;
    }






    public List<Course> findCurrentCoursesForStudents(String login) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.FIND_CURRENT_COURSE);
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        List<Course> courseList = new ArrayList<>();

        while(resultSet.next()){
            Course course = new Course();
            course.setIdCourse(Integer.parseInt(resultSet.getString(NamesTable.COURSE_ID)));
            course.setName(resultSet.getString(NamesTable.COURSE_NAME));
            course.setTeacher(resultSet.getInt(NamesTable.COURSE_ID_TEACHER));
            course.setCourseDescription(resultSet.getString(NamesTable.COURSE_DESC));
            course.setStatus(resultSet.getString(NamesTable.COURSE_STATUS));
            courseList.add(course);
        }

        ConnectionPool.INSTANCE.initConnection(connection);
        return courseList;
    }







private static final String GET_ALL_COURSE_START = "SELECT course.id_course FROM course where status = ?;";
 public Course changeStatus(String status) throws SQLException {
     Connection connection = ConnectionPool.INSTANCE.getConnection();
     PreparedStatement statement = connection.prepareStatement(GET_ALL_COURSE_START);
     Course course = null;
     statement.setString(1, status);
     ResultSet result = statement.executeQuery();

     while (result.next()) {
          course = new Course();

         course.setStatus(result.getString(NamesTable.COURSE_STATUS));
         ConnectionPool.INSTANCE.initConnection(connection);

     }
     return course;
 }


    @Override
    public void createEntity(Course course) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_COURSE);
        statement.setString(1, course.getName());
        statement.setInt(2, course.getTeacher());
        statement.setString(3, course.getCourseDescription());
        statement.setString(4,course.getStatus());

        statement.executeUpdate();
        ConnectionPool.INSTANCE.initConnection(connection);
    }

    @Override
    public void update(Course course) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.COURSE_UPDATE);

        statement.setInt(1 ,course.getIdCourse());

        statement.executeUpdate();
        ConnectionPool.INSTANCE.initConnection(connection);


    }

    @Override
    public Course getEntityById(int id) throws SQLException {
        return null;
    }




    public List<Course>  findCourse(int idCourse) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.FIND_ALL_STUDENT_FOR_COURSE);
        statement.setString(1, String.valueOf(idCourse));
        ResultSet resultSet = statement.executeQuery();
        List<Course> courseList = new ArrayList<>();

        try{
            while (resultSet.next()) {



            }
            ConnectionPool.INSTANCE.initConnection(connection);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return courseList;
    }



















    public Course getCourseByName(String name) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_COURSE_BY_NAME);
        statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        Course course = new Course();
        while(result.next()){
            course.setIdCourse(result.getInt(Parameters.COURSE_ID));
            course.setName(result.getString(Parameters.COURSE_NAME));
            course.setTeacher(result.getInt(Parameters.COURSE_TEACHER));
            course.setCourseDescription(result.getString(Parameters.COURSE_DESC));
         //   course.setStatus(result.getString(Parameters.COURSE_STATUS));
        }
        ConnectionPool.INSTANCE.initConnection(connection);
        return course;
    }






}
