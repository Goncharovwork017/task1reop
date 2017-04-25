package by.traning.nc.dev3.command.user;

import by.traning.nc.dev3.beans.Course;
import by.traning.nc.dev3.beans.SheetList;
import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.dao.CourseDAO;
import by.traning.nc.dev3.dao.SheetListDAO;
import by.traning.nc.dev3.finals.Parameters;
import by.traning.nc.dev3.resource.ConfManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Светлана on 22.04.2017.
 */
public class RegisterForCourseCommand implements ActionCommand {



    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("Регистрация на курс вошел");
      //  sheetId = request.getParameter(Parameters.SHEET_ID);
      // userId = request.getParameter(Parameters.SHEET_USER_ID);
       String sheet = request.getParameter(Parameters.SHEET_COURSE_ID);
       int courseId = Integer.parseInt(sheet);
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId");

        SheetList sheetList = new SheetList();
        sheetList.setIdStudent(userId);
        sheetList.setIdCourse(courseId);
        SheetListDAO sheetListDAO = new SheetListDAO();
        try {
            sheetListDAO.createEntity(sheetList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String page = null;
        try {
            String login = (String) session.getAttribute("user");
            CourseDAO courseDAO = new CourseDAO();
            List<Course> courseList = courseDAO.findCurrentCoursesForStudents(String.valueOf(session.getAttribute("user")));
            session.setAttribute(Parameters.COURSE_LIST, courseList);
            page = ConfManager.getProperty("path.page.currentCourse");
        } catch (SQLException e){
            System.out.println("Ошибка с бд");
            System.out.println(e.getMessage());
        }

        System.out.println("Регистрация на курс вышел");
        return page;

        //  score = request.getParameter(Parameters.SHEET_SCORE);
      //  shortcomment = request.getParameter(Parameters.SHEET_COMMENT);

    }
}
