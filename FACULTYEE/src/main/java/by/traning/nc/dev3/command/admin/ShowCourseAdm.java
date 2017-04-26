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
 * Created by ivan on 19.04.2017.
 */
public class ShowCourseAdm implements ActionCommand {
    private static String id;
    @Override
    public String execute(HttpServletRequest request) {
           String page = null;
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId");
        try{

            id = request.getParameter(Parameters.COURSE_ID);

            CourseDAO courseDAO = new CourseDAO();
            List<Course> courseList = courseDAO.findCourseWithTeacher(userId);
            request.setAttribute("idCourse", id);
            session.setAttribute(Parameters.COURSE_LIST, courseList);
            page = ConfManager.getProperty("path.page.course1");
        } catch (SQLException e){
            System.out.println("Ошибка с бд");
        }
        System.out.println("ShowCourseAdm");
        return page;
    }
    }

