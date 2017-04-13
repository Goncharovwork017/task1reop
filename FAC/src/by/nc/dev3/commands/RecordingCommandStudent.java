package by.nc.dev3.commands;

import by.nc.dev3.exceptions.MyException;

/**
 * Created by ivan on 02.04.2017.
 */
public class RecordingCommandStudent extends ActCommandStudent {

    @Override
    public void execute()throws MyException {
        acts.recCourse();
    }
}
