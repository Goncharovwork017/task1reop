package by.traning.nc.dev3.command.user;

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
 * Created by ivan on 14.04.2017.
 */
public class ShowCourseCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try{
            HttpSession session = request.getSession();
            CourseDAO courseDAO = new CourseDAO();
            List<Course> courseList = courseDAO.findAll();
            session.setAttribute(Parameters.COURSE_LIST, courseList);
            page = ConfManager.getProperty("path.page.course");
        } catch (SQLException e){
            System.out.println("Ошибка с бд");
        }
        System.out.println("ShowCourseCommand");
        return page;
    }
}
