package TaskList;

import TaskList.Enums.TasksPeriod;
import TaskList.Enums.Type;
import TaskList.Exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, Type type, LocalDateTime dateTime, TasksPeriod tasksPeriod, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, TasksPeriod.MONTHLYTASK, description);
    }


    @Override
    boolean appearsIn(LocalDate localDate) {
        return getDateTime ().toLocalDate ().getDayOfMonth () == localDate.getDayOfMonth ();
    }



}
