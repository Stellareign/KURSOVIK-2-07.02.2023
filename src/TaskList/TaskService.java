package TaskList;

import TaskList.Enums.TasksPeriod;
import TaskList.Enums.Type;
import TaskList.Exceptions.IncorrectArgumentException;
import TaskList.Exceptions.TaskNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TaskService {
    // СОЗДАНИЕ ЗАДАЧ, УДАЛЕНИЕ, ГРУППИРОВАНИЕ

    // МАПА ДЛЯ ЗАДАЧ:
    private static final Map<Integer, Task> tasksMap = new HashMap<>(); // мапа с задачами
    private static final Map<Integer, Task> removeTaskMap = new HashMap<>();

    // ДОБАВЛЕНИЕ В МАПУ:
    public Map addToMap(Task task) { // метод добавления в мапу
        this.tasksMap.put(task.getId(), task);
        return tasksMap;
    }

    // ПЕЧАТАЕМ ВСЕ ЗАДАЧИ (в порядке создания):
    public static void printAllTasksMap() {
        System.out.println("\"Список задач: ");
        for (Entry<Integer, Task> task1 : tasksMap.entrySet()) {
            System.out.println(task1.getKey() + " " + task1.getValue());
        }
    }
    // СОРТИРОВКА ЗАДАЧ:
    public void sortTasksByDate() {
        System.out.println("Отсортированный по датам список задач: ");
          Comparator <Map.Entry<Integer, Task>> myComparator = Comparator.comparing(o-> o.getValue().getDateTime()); // создаём условие компаратора по дате
          Map<Integer, Task> sortedTasksMap = tasksMap.entrySet().stream()
             .sorted(myComparator) // сортировать по условию компаратора
             .collect(Collectors.toMap(
                     Map.Entry::getKey,
                     Map.Entry::getValue,
                (oldKey, newKey) -> oldKey, // заменяем ключ = id на ключ = dateTime
                LinkedHashMap :: new
        ));
        sortedTasksMap.entrySet().forEach(System.out::println);
}


    // ДОБАВЛЕНИЕ ЗАДАЧ В КОЛЛЕКЦИЮ ПО ДАТЕ:
    public Collection<Task> allByDateTasks(LocalDate localDate) {
        ArrayList<Task> taskList = new ArrayList<>();
        for (int i = 1; i < tasksMap.size() + 1; i++) {
            if (tasksMap.get(i).appearsIn(localDate)) {
                taskList.add(tasksMap.get(i));
            }
        }
        if (taskList.isEmpty()) {
            System.out.println("На " + localDate + " задач нет.");}
        String separator = "\n";
        String list = taskList.stream().map(Object::toString).collect(Collectors.joining(separator)); // выводим задачи с новой строки
        System.out.println("Список задач на " + localDate + "\n" + list);
            return taskList;
        }

    // УДАЛЕНИЕ ЗАДАЧИ:
    public static Map deleteTasksArchive(int id) throws TaskNotFoundException {
            Task task = tasksMap.remove((id));
            removeTaskMap.put(task.getId(), task); // доработали метод - добавление в список удалённых
            tasksMap.remove(id); // удалить задачу с указанным id
        return removeTaskMap;
    }
    public static void printRemoveTasksMap() { // выводим в консоль список удалённых задач
        System.out.println("\"Список удалённых адач: ");
        for (Entry<Integer, Task> task1 : removeTaskMap.entrySet()) { // проходимся по мапе
            System.out.println(task1.getKey() + " " + task1.getValue());
        }
    }

    // СКАНИРУЕМ ИЗМЕНЕНИЯ НАЗВАНИЯ И ОПИСАНИЯ ЗАДАЧИ:
    public Map scanChangeTask(int id) throws IncorrectArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пункт меню: \n 1 - Изменить название; \n 2 - Изменить описание.");
        int change = scanner.nextInt();
            switch (change) {
                case 1:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Введите новое название задачи.");
                    String changeTitle = scanner1.nextLine();
                    tasksMap.get(id).setTitle(changeTitle); // указываем в каком объекте менять название
                    break;
                case 2:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Введите новое описание задачи.");
                    String changeDescription = scanner2.nextLine();
                    tasksMap.get(id).setDescription(changeDescription);
                    break;
            }
       return tasksMap;
    }
    // геттеры, сеттеры и пр.
    public Map<Integer, Task> getTasksMap() {
        return tasksMap;
    }

    @Override
    public String toString() {
        return "TaskService{" +
                "tasksMap=" + tasksMap +
                '}';
    }

    //СОЗДАНИЕ ЗАДАЧИ С КОНСОЛИ:
    public static class ServiceTask {
        private static final TaskService TASK_SERVICE = new TaskService();

        //Task (String title, Type type, LocalDateTime dateTime, TasksPeriod tasksPeriod, String description
        public static void scanTask(Scanner scanner) { // пробуем создать задачу
            String title = TaskScanner.scanTitle(scanner);
            Type type = TaskScanner.scanType(scanner);
            LocalDateTime dateTime = TaskScanner.scanDateTime(scanner);
            TasksPeriod tasksPeriod = TaskScanner.scanPeriod(scanner);
            String description = TaskScanner.scanDescription(scanner);
            Task task = new Task(title, type, dateTime, tasksPeriod, description) { // не получается инициализировать по-другому, я пробовала, но в switch выскакивает ошибка
                @Override
                boolean appearsIn(LocalDate localDate) {
                    return false;
                }
            };
            switch (tasksPeriod) {
                case ONETIMETASK:
                    task = new OneTimeTask(title, type, dateTime, TasksPeriod.ONETIMETASK, description);
                    break;
                case DALYTASK:
                    task = new DalyTask(title, type, dateTime, TasksPeriod.DALYTASK, description);
                    break;
                case WEEKLYTASK:
                    task = new WeeklyTask(title, type, dateTime, TasksPeriod.WEEKLYTASK, description);
                    break;
                case MONTHLYTASK:
                    task = new MonthlyTask(title, type, dateTime, TasksPeriod.MONTHLYTASK, description);
                    break;
                case YEARLYTASK:
                    task = new YearlyTask(title, type, dateTime, TasksPeriod.YEARLYTASK, description);
                    break;
            }            ;
            TASK_SERVICE.addToMap(task); // я пробовала Task task, но тогда у меня не читается task в этой строке. :(

        }
    }
}



