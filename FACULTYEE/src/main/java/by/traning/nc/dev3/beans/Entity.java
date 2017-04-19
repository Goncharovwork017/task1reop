package by.traning.nc.dev3.beans;

import java.io.Serializable;

/**
 * Created by ivan on 11.04.2017.
 */
public abstract class Entity implements Serializable {
    protected int id;

    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Entity [" +
                "id=" + id +
                ']';
    }



}
