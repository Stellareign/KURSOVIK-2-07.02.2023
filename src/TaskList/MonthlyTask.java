package TaskList;

import TaskList.Enums.TasksPeriod;
import TaskList.Enums.Type;
import TaskList.Exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, Type type, LocalDateTime dateTime, TasksPeriod tasksPeriod, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, tasksPeriod, description);
        this.tasksPeriod = TasksPeriod.MONTHLYTASK;
    }

    public MonthlyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
        this.tasksPeriod = TasksPeriod.MONTHLYTASK;
    }

    @Override
    boolean appearsIn(LocalDate localDate) {
        return getDateTime ().toLocalDate ().getDayOfMonth () == localDate.getDayOfMonth ();
    }


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
