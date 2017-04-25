package by.traning.nc.dev3.command.admin;

import by.traning.nc.dev3.beans.Course;
import by.traning.nc.dev3.beans.SheetList;
import by.traning.nc.dev3.beans.User;
import by.traning.nc.dev3.beans.UserSHeetlist;
import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.dao.CourseDAO;
import by.traning.nc.dev3.dao.SheetListDAO;
import by.traning.nc.dev3.dao.UserDAO;
import by.traning.nc.dev3.finals.Parameters;
import by.traning.nc.dev3.resource.ConfManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 23.04.2017.
 */
public class GetScoreAndRewiewCommand implements ActionCommand {
    private static String id;
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("Поставить оценки пришел");
        String page = null;
        id = request.getParameter(Parameters.COURSE_ID);
        try {
            HttpSession session = request.getSession();
            //createScoreAndRew(Integer.parseInt(id));
            SheetListDAO sheetListDAO = new SheetListDAO();
            List<UserSHeetlist> userSHeetlists = sheetListDAO.findStudentWithEndedCourse(Integer.parseInt(id));
            session.setAttribute(Parameters.USERSHEET, userSHeetlists);
            request.setAttribute("idCourse", id);

            page = ConfManager.getProperty("path.page.getScoreAndRew");
        }catch (SQLException e){
            System.out.println("Ошибка бд");
            System.out.println(e.getMessage());
        }

        return page;
    }


    private void createScoreAndRew(int idCourse) throws SQLException {
        SheetListDAO sheetListDAO = new SheetListDAO();
        sheetListDAO.findStudentWithEndedCourse(idCourse);
    }



}
