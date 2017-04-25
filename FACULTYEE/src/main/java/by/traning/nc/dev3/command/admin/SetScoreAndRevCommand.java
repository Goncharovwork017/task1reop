package by.traning.nc.dev3.command.admin;

import by.traning.nc.dev3.beans.Course;
import by.traning.nc.dev3.beans.SheetList;
import by.traning.nc.dev3.beans.UserSHeetlist;
import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.dao.CourseDAO;
import by.traning.nc.dev3.dao.SheetListDAO;
import by.traning.nc.dev3.finals.Parameters;
import by.traning.nc.dev3.resource.ConfManager;
import com.mysql.jdbc.exceptions.MySQLDataException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 24.04.2017.
 */
public class SetScoreAndRevCommand implements ActionCommand {
    private static String id;


    @Override
    public String execute(HttpServletRequest request) {

        String page = null;
        String[] sheetId = request.getParameterValues("sheetId");
        String[] scores = request.getParameterValues("score");
        String[] comments = request.getParameterValues("shortcomment");
        HttpSession session = request.getSession();
        id = request.getParameter(Parameters.COURSE_ID);
        try {
            SheetListDAO sheetListDAO = new SheetListDAO();
            SheetList sheetList = new SheetList();
            for (int i = 0; i < scores.length; i++) {
                sheetList.setScore(Integer.parseInt(scores[i]));
                sheetList.setShortComment(comments[i]);
                sheetList.setSheetId(Integer.parseInt(sheetId[i]));
                sheetListDAO.update(sheetList);
            }

            List<UserSHeetlist> userSHeetlists = sheetListDAO.findStudentWithEndedCourse(Integer.parseInt(id));
            session.setAttribute(Parameters.USERSHEET, userSHeetlists);


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        page = ConfManager.getProperty("path.page.setScoreAndRev");


        return page;
    }
}