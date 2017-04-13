package by.nc.dev3.interfaces;

import by.nc.dev3.exceptions.MyException;

/**
 * Created by ivan on 02.04.2017.
 */
public interface Command {
    void execute() throws MyException;
}
