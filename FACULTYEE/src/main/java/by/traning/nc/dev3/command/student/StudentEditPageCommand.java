package by.traning.nc.dev3.command.student;

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
public class StudentEditPageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("тук-тук1StudentEditPageCommand");
        String page = null;
        UserDAO userDao = new UserDAO();
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("user");
        System.out.println("тук-тук2StudentEditPageCommand"+name);
        try {
            User user = userDao.getUserByLogin(name);
            System.out.println("тук-тук3StudentEditPageCommand"+name);
            page = ConfManager.getProperty("path.page.studentEditPage");
            request.setAttribute("first_name", user.getFirstName());
            request.setAttribute("last_name", user.getLastName());
            request.setAttribute("login", user.getLogin());
            request.setAttribute("password", user.getPassword());
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}
