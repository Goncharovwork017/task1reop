package by.traning.nc.dev3.command.admin;

import by.traning.nc.dev3.beans.Course;
import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.dao.CourseDAO;
import by.traning.nc.dev3.finals.Parameters;
import by.traning.nc.dev3.resource.ConfManager;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Светлана on 22.04.2017.
 */
public class EndedCourseCommand implements ActionCommand {
    private static String id;
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("Закнчить курс пришел");
        String page = null;
        HttpSession session = request.getSession();
        id = request.getParameter(Parameters.COURSE_ID);

        int userId = (Integer) session.getAttribute("userId");
        try {

            editStatus(Integer.parseInt(id));
            CourseDAO courseDAO = new CourseDAO();
            List<Course> courseList = courseDAO.findCourseWithTeacher(userId);
            session.setAttribute(Parameters.COURSE_LIST, courseList);
            page = ConfManager.getProperty("path.page.endedCourse");
        }catch (SQLException e){
            System.out.println("Ошибка бд");
            System.out.println(e.getMessage());
        }
        System.out.println("Закнчить курс ушел");
        return page;
    }

    private void editStatus(int idCourse) throws SQLException {
        CourseDAO courseDAO = new CourseDAO();
        Course course = new Course();
        course.setIdCourse(idCourse);

        courseDAO.update(course);
    }



}
