package TaskList;

import TaskList.Enums.TasksPeriod;
import TaskList.Enums.Type;
import TaskList.Exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task  {
   private static int idGenerator = 1;
    private String  title;

   private int id;
    private LocalDateTime dateTime;
    private String description;
    protected TasksPeriod tasksPeriod;
    private Type type;

   // конструктор:

    public Task(String title, Type type, LocalDateTime dateTime,  TasksPeriod tasksPeriod, String description) throws IncorrectArgumentException {
        this.id = idGenerator++;
        try {
            if (title != null && !title.isBlank() && !title.isEmpty()) {
                this.title = title;
            } else throw new IncorrectArgumentException("Укажите название задачи");
        } catch (IncorrectArgumentException e) {
            setDescription(e.getMessage());
        }

        if (dateTime.isAfter(LocalDateTime.now())) {
            this.dateTime = dateTime;
        }else this.dateTime = LocalDateTime.now();

        this.tasksPeriod = tasksPeriod;
        this.description = description;
        this.type = Objects.requireNonNullElse(type, Type.PERSONAL);
    }

    // ежегодная повторяемость
    abstract boolean appearsIn(LocalDate localDate);
// геттеры и сеттеры:

    public int getIdGenerator() {
        return idGenerator;
    }

    public TasksPeriod getTasksPeriod() {
        return tasksPeriod;
    }

    public String getTitle() {

        return title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

     public String getDescription() {
        return description;
    }
    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public Task setTasksPeriod(TasksPeriod tasksPeriod) {
        this.tasksPeriod = tasksPeriod;
        return this;
    }

    public Task setType(Type type) {
        this.type = type;
        return this;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }
// иквалс и хэшкод

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getId() == task.getId() && getTitle().equals(task.getTitle()) &&
                getDateTime().equals(task.getDateTime()) && getDescription().equals(task.getDescription())
                && getTasksPeriod() == task.getTasksPeriod() && getType() == task.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getId(), getDateTime(),
                getDescription(), getTasksPeriod(), getType());
    }

// тустринг:

    @Override
    public String toString() {
        return "Задача ID " + id + " на "  + dateTime.getDayOfMonth()
                + "." + dateTime.getMonthValue() + "." + dateTime.getYear() + " / " +  dateTime.getHour() + ":" + dateTime.getMinute() +
                "\n Название: '" + title + '\'' +
                " \n Тип: " + type +" \n Периодичность выполнения: " + tasksPeriod +
                "\n Описание: " + description;
    }
}
