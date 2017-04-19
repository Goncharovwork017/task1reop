package by.traning.nc.dev3.command.user;

import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.resource.ConfManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ivan on 11.04.2017.
 */
public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfManager.getProperty("path.page.index");
        request.getSession().invalidate();
        System.out.println("LogoutCommand");
        return page;
    }
}
