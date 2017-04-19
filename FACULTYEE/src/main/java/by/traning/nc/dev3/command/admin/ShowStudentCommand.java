package by.traning.nc.dev3.command.admin;

import by.traning.nc.dev3.beans.User;
import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.dao.UserDAO;
import by.traning.nc.dev3.finals.Parameters;
import by.traning.nc.dev3.resource.ConfManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 13.04.2017.
 */
public class ShowStudentCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            UserDAO userDAO = new UserDAO();
            List<User> list = userDAO.findAll();
            session.setAttribute(Parameters.USER_LIST, list);
            page = ConfManager.getProperty("path.page.showStudents");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        System.out.println("ShowStudentCommand");
        return page;
    }
}
