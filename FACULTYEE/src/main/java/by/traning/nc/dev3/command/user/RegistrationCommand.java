package by.traning.nc.dev3.command.user;

import by.traning.nc.dev3.beans.Faculty;
import by.traning.nc.dev3.beans.User;
import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.finals.Parameters;
import by.traning.nc.dev3.dao.UserDAO;
import by.traning.nc.dev3.filters.UserType;
import by.traning.nc.dev3.resource.ConfManager;
import by.traning.nc.dev3.resource.MessManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by ivan on 11.04.2017.
 */
public class RegistrationCommand implements ActionCommand {
    private static String firstName;
    private static String lastName;
    private static String login;
    private static String password;

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        firstName = request.getParameter(Parameters.FIRST_NAME);
        lastName = request.getParameter(Parameters.LAST_NAME);
        login = request.getParameter(Parameters.LOGIN);
        password = request.getParameter(Parameters.PASSWORD);
        try{
            registrate();
            request.setAttribute("user", login);
            HttpSession session = request.getSession(true);
            session.setAttribute("userType", UserType.STUDENT);
            page = ConfManager.getProperty("path.page.user");
        } catch (SQLException e) {
            request.setAttribute("errorLoginPassMessage", MessManager.getProperty("message.regerror"));
            request.getSession().setAttribute("userType", UserType.GUEST);
            page = ConfManager.getProperty("path.page.registration");
        }
        System.out.println("RegistrationCommand");
        return page;
    }




    private void registrate() throws SQLException {
        UserDAO dao = new UserDAO();
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        user.setRoleId(dao.GetRoleById());
        System.out.println("registrate");
        dao.create(user);
    }

}
