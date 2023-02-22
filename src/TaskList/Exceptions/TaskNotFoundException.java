package TaskList.Exceptions;

public class TaskNotFoundException extends IllegalArgumentException {
    public TaskNotFoundException(String s) {
        super(s);
    }
}
