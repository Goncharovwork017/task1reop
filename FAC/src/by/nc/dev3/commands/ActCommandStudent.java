package by.nc.dev3.commands;

import by.nc.dev3.enums.StudentAct;
import by.nc.dev3.interfaces.Command;
import by.nc.dev3.service.StudentActs;

import java.io.Serializable;

/**
 * Created by ivan on 02.04.2017.
 */
public abstract class ActCommandStudent implements Command,Serializable {

    protected StudentActs acts = new StudentActs();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActCommandStudent that = (ActCommandStudent) o;

        return acts != null ? acts.equals(that.acts) : that.acts == null;
    }

    @Override
    public int hashCode() {
        return acts != null ? acts.hashCode() : 0;
    }
}
