package by.nc.dev3.entities;

import java.io.Serializable;

/**
 * Created by ivan on 02.04.2017.
 */
public class Mark implements Serializable {


    private int mark;

    public Mark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "mark=" + mark +
                '}';
    }
}





