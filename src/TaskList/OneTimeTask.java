package TaskList;

import TaskList.Enums.TasksPeriod;
import TaskList.Enums.Type;
import TaskList.Exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, Type type, LocalDateTime dateTime, TasksPeriod tasksPeriod, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, tasksPeriod, description);
        this.tasksPeriod = TasksPeriod.ONETIMETASK;
    }

    public OneTimeTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
        this.tasksPeriod = TasksPeriod.ONETIMETASK;
    }

    @Override
    boolean appearsIn(LocalDate localDate) {
        return localDate.equals(this.getDateTime().toLocalDate()); // сегодняшняя дата равна дате задачи
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
