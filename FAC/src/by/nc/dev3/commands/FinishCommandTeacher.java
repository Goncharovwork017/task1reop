package by.nc.dev3.commands;

import by.nc.dev3.exceptions.MyException;

/**
 * Created by ivan on 04.04.2017.
 */
public class FinishCommandTeacher extends ActCommandTeacher {
    @Override
    public void execute() throws MyException {
        acts.finish();
    }
}
