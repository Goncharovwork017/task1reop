package by.traning.nc.dev3.command.user;

import by.traning.nc.dev3.beans.User;
import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.finals.Parameters;
import by.traning.nc.dev3.dao.UserDAO;
import by.traning.nc.dev3.filters.UserType;
import by.traning.nc.dev3.resource.ConfManager;
import by.traning.nc.dev3.resource.MessManager;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by ivan on 11.04.2017.
 */
public class LoginCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("LoginCommand зашел");
        String page = null;
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        try{
            User user = null;
            if((user = new UserDAO().isAuth(login,password)) != null){
                String role = new UserDAO().checkRole(login,password);
                if(role.equals("admin")){
                    request.setAttribute("user",login);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("userType", UserType.ADMIN);
                    session.setAttribute("user", login);
                    session.setAttribute("userId", user.getUserId());
                    page = ConfManager.getProperty("path.page.main");
                } else if (role.equals("student")){
                    request.setAttribute("user",login);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("userType", UserType.STUDENT);
                    session.setAttribute("user", login);
                    session.setAttribute("userId", user.getUserId() );
                    page = ConfManager.getProperty("path.page.user");
                }
            }else {
                request.setAttribute("errorLoginPassMessage", MessManager.getProperty("message.loginerror"));
                request.getSession().setAttribute("userType", UserType.GUEST);
            }
        } catch (SQLException e){
            System.out.println("err");
            System.out.println(e.getMessage());
        }
        System.out.println("LoginCommand авторизовался");
        return page;
    }

}
