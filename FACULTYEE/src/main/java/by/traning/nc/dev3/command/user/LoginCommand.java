package by.traning.nc.dev3.command.user;

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
public class LoginCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        try{
            if(new UserDAO().isAuth(login,password)){
                String role = new UserDAO().checkRole(login,password);
                if(role.equals("admin")){
                    request.setAttribute("user",login);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("userType", UserType.ADMIN);
                    System.out.println("pokaji usera" + login);
                    page = ConfManager.getProperty("path.page.main");
                } else if (role.equals("student")){
                    request.setAttribute("user",login);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("userType", UserType.STUDENT);
                    page = ConfManager.getProperty("path.page.user");
                }
            }else {
                request.setAttribute("errorLoginPassMessage", MessManager.getProperty("message.loginerror"));
                request.getSession().setAttribute("userType", UserType.GUEST);
            }
        } catch (SQLException e){
            System.out.println("err");
        }
        System.out.println("LoginCommand");
        return page;
    }
}
