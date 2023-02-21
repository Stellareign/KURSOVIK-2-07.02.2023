package TaskList;

import TaskList.Enums.TasksPeriod;
import TaskList.Enums.Type;
import TaskList.Exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, Type type, LocalDateTime dateTime, TasksPeriod tasksPeriod, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, TasksPeriod.WEEKLYTASK, description);
    }

    @Override
    boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        if (localDate.equals(taskDate) || (localDate.isAfter(taskDate) && localDate.getDayOfWeek().equals(taskDate.getDayOfWeek()))) {
            return true;
        } else return false;
    }

}