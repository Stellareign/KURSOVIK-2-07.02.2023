package TaskList;

import TaskList.Enums.TasksPeriod;
import TaskList.Enums.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(String title, Type type, LocalDateTime dateTime, TasksPeriod tasksPeriod, String description) {
        super(title, type, dateTime, TasksPeriod.YEARLYTASK, description);
    }

    // ежегодная повторяемость
    @Override
    boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getDateTime().toLocalDate(); // this(?)
        return localDate.equals(taskDate) || (localDate.isAfter(taskDate) && localDate.getDayOfMonth() == taskDate.getDayOfMonth() &&
                localDate.getMonth().equals(taskDate.getMonth())); // дата равно или после даты задачи: день и месяц
    }

}