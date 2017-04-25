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
 * Created by Светлана on 22.04.2017.
 */
public class ShowCurrentCoursesCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try{
            HttpSession session = request.getSession();
            String login = (String) session.getAttribute("user");
            CourseDAO courseDAO = new CourseDAO();
            List<Course> courseList = courseDAO.findCurrentCoursesForStudents(String.valueOf(session.getAttribute("user")));
            session.setAttribute(Parameters.COURSE_LIST, courseList);
            page = ConfManager.getProperty("path.page.currentCourse");
        } catch (SQLException e){
            System.out.println("Ошибка с бд");
            System.out.println(e.getMessage());
        }
        System.out.println("ShowCurrentCoursesCommand");
        return page;
    }
}
