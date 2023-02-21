package TaskList;


import TaskList.Exceptions.IncorrectArgumentException;
import TaskList.Exceptions.TaskNotFoundException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TaskListMenu {
    // СКАННЕР ДЛЯ ОБСЛУЖИВАНИЯ ЛИСТА ЗАДАЧ
    Task TASK;
    static TaskService TASK_SERVICE = new TaskService();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        public static void TaskListMaintenance() throws TaskNotFoundException, IncorrectArgumentException {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Выберите действие: \n 1 - Создать задачу; \n 2 - Удалить задачу; \n " +
                        "3 - Показать задачи на указанную дату; \n 4 - Показать все задачи; " +
                        "\n 5 - Изменить название или описание задачи; \n 6 - Сортировать задачи по дате; \n 0 - Выход.");
                int scanChoise = scanner.nextInt();
                if (scanChoise >= 0 && scanChoise <= 8) {
                    switch (scanChoise) {
                        case 1: // СОЗДАТЬ ЗАДАЧУ
                            TaskService.ServiceTask.scanTask(scanner);
                            break;

                        case 2: // УДАЛИТЬ ЗАДАЧУ
                            System.out.println("Введите ID задачи для удаления из списка");
                            int scanID = scanner.nextInt();

                            if (TASK_SERVICE.getTasksMap().containsKey(scanID)) {
                                TaskService.deleteTasksArchive(scanID);
                                TaskService.printRemoveTasksMap();
                            } else
                                throw new TaskNotFoundException("Такой задачи нет. Выберите другую задачу для удаления.");
                            break;

                        case 3: // ЗАДАЧИ НА ДАТУ
                            Scanner scanner1 = new Scanner(System.in);
                            System.out.println("Введите дату.");
                            String scanDate = scanner1.nextLine();
                            try {
                                if (scanDate != null && !scanDate.isBlank()) {
                                    LocalDate scanDateFormat = LocalDate.parse(scanDate, DATE_FORMATTER);
                                    if ((scanDateFormat.equals(LocalDate.now()) || (scanDateFormat.isAfter(LocalDate.now())))) {
                                        TASK_SERVICE.allByDateTasks(scanDateFormat);
                                    } else {
                                        System.out.println("На " + scanDate + " задач нет");
                                    }
                                }
                            } catch (DateTimeParseException e) {
                                System.out.println("Неправильный формат даты! Введите верно дату в формате дд.мм.гггг:");
                            }
                            break;

                        case 4: // ПОКАЗАТЬ ВСЕ ЗАДАЧИ
                            TaskService.printAllTasksMap();
                            break;

                        case 5: // ИЗМЕНИТЬ ЗАДАЧУ:
                            System.out.println("Введите ID задачи изменения названия или описания");
                            TaskService.printAllTasksMap();
                            int scanID2 = scanner.nextInt();
                            if (TASK_SERVICE.getTasksMap().containsKey(scanID2)) {
                                TASK_SERVICE.scanChangeTask(scanID2);
                            } else
                                throw new IncorrectArgumentException("Такой задачи нет. Выберите другую задачу");
                            break;

                        case 6:
                            TASK_SERVICE.sortTasksByDate();

                        case 0: // ВЫХОД
                            System.exit(0);
                    }
                } else
                    throw new IncorrectArgumentException("Введено некорректное значение. Выберите пункт меню от 1 до 8");
            } catch (TaskNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
    }
    }
}


