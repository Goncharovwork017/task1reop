package by.traning.nc.dev3.command.admin;

import by.traning.nc.dev3.beans.Course;
import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.dao.CourseDAO;
import by.traning.nc.dev3.finals.Parameters;
import by.traning.nc.dev3.resource.ConfManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 25.04.2017.
 */
public class CreatedCourseCommand implements ActionCommand {
    private static String id;
    private static String[] teacher;

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("CreatedCourseCommand");
        String page = null;
        HttpSession session = request.getSession();
        id = request.getParameter("idCourse");

        int userId = (Integer) session.getAttribute("userId");
      // int idCourse = (Integer) session.getAttribute("idCourse");
     //   int teacher = Integer.parseInt( request.getParameter(Parameters.COURSE_TEACHER));
       // int idCourse = (Integer) session.getAttribute("idCourse");
       // String[] idCourse = request.getParameterValues("idCourse");
       // String[] teacher = request.getParameterValues("teacher");
      //  id = request.getParameterValues("idCourse");

        String[] name = request.getParameterValues("name");
       // teacher = request.getParameterValues("teacher");
        String[] tae = request.getParameterValues("teacher");
        String[] courseDescription = request.getParameterValues("courseDescription");
        String[] status = request.getParameterValues("status");
        try {
            CourseDAO courseDAO = new CourseDAO();
            Course course = new Course();
            for (int i = 0; i < name.length; i++) {
                course.setIdCourse(Integer.parseInt(id));
                course.setName(name[i]);
                course.setCourseDescription(courseDescription[i]);
                course.setTeacher(userId);
                course.setStatus(status[i]);
                courseDAO.addCourseUpdate(course);
            }

            List<Course> courseList = courseDAO.findLastCourse(userId);
            session.setAttribute(Parameters.COURSE_LIST, courseList);


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        page = ConfManager.getProperty("path.page.createdCourse");
        return page;
    }

    }

