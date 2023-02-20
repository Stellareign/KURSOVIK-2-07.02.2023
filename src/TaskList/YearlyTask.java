package TaskList;

import TaskList.Enums.TasksPeriod;
import TaskList.Enums.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(String title, Type type, LocalDateTime dateTime, TasksPeriod tasksPeriod, String description) {
        super(title, type, dateTime, tasksPeriod,  description);
        this.tasksPeriod = TasksPeriod.YEARLYTASK;
        }

    public YearlyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
        this.tasksPeriod = TasksPeriod.YEARLYTASK;
    }

    // ежегодная повторяемость
    @Override
    boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getDateTime().toLocalDate(); // this(?)
        return localDate.equals(taskDate) || (localDate.isAfter(taskDate) && localDate.getDayOfMonth() == taskDate.getDayOfMonth() &&
                localDate.getMonth().equals(taskDate.getMonth())); // дата равно или после даты задачи: день и месяц
    }

    @Override
    public int getIdGenerator() {
        return super.getIdGenerator();
    }

    @Override
    public TasksPeriod getTasksPeriod() {
        return super.getTasksPeriod();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public Type getType() {
        return super.getType();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public LocalDateTime getDateTime() {
        return super.getDateTime();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public Task setTitle(String title) {
        return super.setTitle(title);
    }

    @Override
    public Task setTasksPeriod(TasksPeriod tasksPeriod) {
        return super.setTasksPeriod(tasksPeriod);
    }

    @Override
    public Task setType(Type type) {
        return super.setType(type);
    }

    @Override
    public Task setDescription(String description) {
        return super.setDescription(description);
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
