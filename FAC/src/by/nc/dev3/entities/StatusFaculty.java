package by.nc.dev3.entities;

import java.io.Serializable;

/**
 * Created by ivan on 05.04.2017.
 */
public class StatusFaculty implements Serializable {
    private String status;

    public StatusFaculty(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "StatusFaculty{" +
                "status='" + status + '\'' +
                '}';
    }
}
