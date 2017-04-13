package by.nc.dev3.tools;

import by.nc.dev3.entities.Course;
import by.nc.dev3.enums.SortingIndex;

import java.util.Comparator;

/**
 * Created by ivan on 05.04.2017.
 */
public class ServiceComparator implements Comparator<Course> {
    private SortingIndex index;

    public ServiceComparator(SortingIndex index) {
        this.index = index;
    }

    @Override
    public int compare(Course o1, Course o2) {
        switch (index){
            case TITLE:
                return o1.getTitle().compareTo(o2.getTitle());
            case AMOUNT:
                return Integer.compare(o1.getAmount(),o2.getAmount());
            case DESC:
                return o1.getDescription().compareTo(o2.getDescription());
                default:
                    throw new EnumConstantNotPresentException(SortingIndex.class, index.name());
        }
    }
}
