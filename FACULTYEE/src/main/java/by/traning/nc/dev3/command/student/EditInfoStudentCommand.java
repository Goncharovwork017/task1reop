package by.traning.nc.dev3.command.student;

import by.traning.nc.dev3.beans.User;
import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.dao.UserDAO;
import by.traning.nc.dev3.finals.Parameters;
import by.traning.nc.dev3.resource.ConfManager;
import by.traning.nc.dev3.resource.MessManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by ivan on 13.04.2017.
 */
public class EditInfoStudentCommand implements ActionCommand {
    private static String firstName;
    private static String lastName;
    private static String login;
    private static String password;

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("тук-тук");
        String page = null;
        firstName = request.getParameter(Parameters.FIRST_NAME);
        lastName = request.getParameter(Parameters.LAST_NAME);
        login = request.getParameter(Parameters.LOGIN);
        password = request.getParameter(Parameters.PASSWORD);
        try {
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("user");
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByLogin(name);
            editionStud(user.getUserId());
            System.out.println("тук-тук1");
            session.setAttribute("user", login);
            request.setAttribute("first_name", firstName);
            request.setAttribute("last_name", lastName);
            request.setAttribute("login", login);
            request.setAttribute("password", password);
            page = ConfManager.getProperty("path.page.studentEditPage");
        } catch (SQLException e) {
            request.setAttribute("errorLoginPassMessage", MessManager.getProperty("message.errorInfo"));
            page = ConfManager.getProperty("path.page.studentEditPage");
        }
        System.out.println("тук-тук2");
        return page;
    }


    private void editionStud(int user_id) throws SQLException {
        System.out.println("тук-тук3");
        UserDAO dao = new UserDAO();
        User user = new User();
        user.setUserId(user_id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        System.out.println("тук-тук4");
        dao.update(user);
    }




    }

