package by.traning.nc.dev3.command.admin;

import by.traning.nc.dev3.beans.Course;
import by.traning.nc.dev3.beans.User;
import by.traning.nc.dev3.beans.UserSHeetlist;
import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.dao.CourseDAO;
import by.traning.nc.dev3.dao.UserDAO;
import by.traning.nc.dev3.filters.UserType;
import by.traning.nc.dev3.finals.Parameters;
import by.traning.nc.dev3.resource.ConfManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 19.04.2017.
 */
public class AddCourseCommand implements ActionCommand {
   // private static int id = (int) System.currentTimeMillis();
    private static String name;
    private static String teacher;
    private static String courseDescription;
    private static String status = "null";

 //  private static String status;

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("AddCourseCommand11111111111");
        String page = null;
        HttpSession session = request.getSession();
        //id = request.getParameter(Parameters.COURSE_ID);
         int userId = (Integer) session.getAttribute("userId");
        try {
            CourseDAO dao = new CourseDAO();
            Course course = new Course();
          //  course.setIdCourse(id);

            //course.setIdCourse(id);
            course.setName(name);
            course.setTeacher(userId);
            course.setCourseDescription(courseDescription);
            course.setStatus(status);
            dao.createEntity(course);
           List<Course> courseList = dao.findCourse(userId);
            session.setAttribute(Parameters.COURSE_LIST, courseList);
       //    request.setAttribute("idCourse", idCourse);

            page = ConfManager.getProperty("path.page.addCourse");
        } catch (SQLException e) {
            System.out.println("SQL exception");
            System.out.println(e.getMessage());
        }

        page = ConfManager.getProperty("path.page.addCourse");
        System.out.println("AddCourseCommand22222222222222");
        return page;

    }


//    private void addCourse() throws SQLException {
//        System.out.println("тук-тук1addCourse");
//        CourseDAO dao = new CourseDAO();
//        Course course = new Course();
//        course.setName(name);
//        course.setTeacher(userId);
//        course.setCourseDescription(courseDescription);
//        course.setStatus(status);
//        System.out.println("тук-тук12addCourse");
//        dao.createEntity(course);
//    }



}
