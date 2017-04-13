package by.nc.dev3.commands;

import by.nc.dev3.enums.TeacherAct;
import by.nc.dev3.interfaces.Command;
import by.nc.dev3.service.TeacherActs;

/**
 * Created by ivan on 02.04.2017.
 */
public abstract class ActCommandTeacher implements Command {
    protected TeacherActs acts = new TeacherActs();
}
