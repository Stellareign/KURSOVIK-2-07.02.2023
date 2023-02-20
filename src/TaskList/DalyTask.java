package TaskList;

import TaskList.Enums.TasksPeriod;
import TaskList.Enums.Type;
import TaskList.Exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DalyTask extends Task {
    public DalyTask(String title, Type type, LocalDateTime dateTime, TasksPeriod tasksPeriod, String description)
            throws IncorrectArgumentException {
        super(title, type, dateTime, tasksPeriod, description);
        this.tasksPeriod = TasksPeriod.DALYTASK;
    }

    public DalyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
        this.tasksPeriod = TasksPeriod.DALYTASK;
    }

    @Override
    boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        if (localDate.equals(taskDate) || localDate.isAfter(taskDate)) { // указанная дата равна или после даты задачи
            return true;
        } else return false;
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
