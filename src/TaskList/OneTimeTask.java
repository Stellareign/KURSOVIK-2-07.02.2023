package TaskList;

import TaskList.Enums.TasksPeriod;
import TaskList.Enums.Type;
import TaskList.Exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, Type type, LocalDateTime dateTime, TasksPeriod tasksPeriod, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, TasksPeriod.ONETIMETASK, description);
    }


    @Override
    boolean appearsIn(LocalDate localDate) {
        return localDate.equals(this.getDateTime().toLocalDate()); // сегодняшняя дата равна дате задачи
    }

}
