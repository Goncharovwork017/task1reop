package by.traning.nc.dev3.command.admin;

import by.traning.nc.dev3.beans.User;
import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.dao.UserDAO;
import by.traning.nc.dev3.resource.ConfManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by ivan on 13.04.2017.
 */
public class AdminEditPageCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("AdminEditPageCommandТУК_ТУК1");
        String page = null;
        UserDAO userDao = new UserDAO();
        System.out.println("userDao"+userDao);
        HttpSession session = request.getSession();
        System.out.println("session"+session);
        String name = (String) session.getAttribute("user");
        System.out.println("AdminEditPageCommandТУК_ТУК2");
        System.out.println("AdminEditPageCommandТУК_ТУК2.1"+name);
        try {
            System.out.println("AdminEditPageCommandТУК_ТУК3");

            User user = userDao.getUserByLogin(name);
            System.out.println("AdminEditPageCommandТУК_ТУК4"+name);
            page = ConfManager.getProperty("path.page.adminEditPage");
            request.setAttribute("first_name", user.getFirstName());
            request.setAttribute("last_name", user.getLastName());
            request.setAttribute("login", user.getLogin());
            request.setAttribute("password", user.getPassword());
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        System.out.println("AdminEditPageCommand");
        return page;
    }
}
