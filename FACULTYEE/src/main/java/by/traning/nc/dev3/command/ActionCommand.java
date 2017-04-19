package by.traning.nc.dev3.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ivan on 11.04.2017.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}
