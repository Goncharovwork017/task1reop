package by.traning.nc.dev3.command.factory;

import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.resource.MessManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ivan on 11.04.2017.
 */
public class ActionFactory {

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = null;
        String action = request.getParameter("command");

        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + MessManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
