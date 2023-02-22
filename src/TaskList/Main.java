package TaskList;

import TaskList.Enums.TasksPeriod;
import TaskList.Enums.Type;
import TaskList.Exceptions.TaskNotFoundException;

import java.time.LocalDateTime;

public class Main {
//   public Task(String title, Type type, LocalDateTime dateTime, TasksPeriod tasksPeriod, String description
    public static void main(String[] args) throws TaskNotFoundException {
     TaskService TASK_SERVICE = new TaskService();

// СОЗДАЁМ ЗАДАЧИ ЧЕРЕЗ КОНСТРУКТОР:
     Task task1 = new YearlyTask("Прививка Буся", Type.PERSONAL, LocalDateTime.of(2023, 12, 13, 11, 20),
             TasksPeriod.YEARLYTASK,"Природа");
     Task task2 = new YearlyTask("Прививка Мисти", Type.PERSONAL, LocalDateTime.of(2023, 07, 06, 12, 00),
             TasksPeriod.YEARLYTASK,"Природа");
     Task task3 = new YearlyTask("Прививка Бегемот", Type.PERSONAL, LocalDateTime.of(2023, 10, 10, 10,
             00), TasksPeriod.YEARLYTASK,"Природа");
     Task task4 = new WeeklyTask("Продлёнка", Type.PERSONAL, LocalDateTime.of(2023, 02, 28, 19, 00),
             TasksPeriod.WEEKLYTASK,"SkyPro");
     Task task5 = new OneTimeTask("Курсовик", Type.PERSONAL, LocalDateTime.of(2023, 02, 20, 21, 00),
             TasksPeriod.ONETIMETASK,"Сдать курсовик");
     Task task6 = new MonthlyTask("Коммуналка", Type.PERSONAL, LocalDateTime.of(2023, 02, 23, 21, 00),
             TasksPeriod.MONTHLYTASK,"Передать показания");
     Task task7 = new DalyTask("Учёба", Type.PERSONAL, LocalDateTime.of(2023, 02, 15, 20, 30),
             TasksPeriod.DALYTASK,"Учиться, как завещал дедушка Ленин");
     Task task8 = new OneTimeTask("Сдать деньги", Type.WORK, LocalDateTime.of(2023, 02, 27, 10, 00),
             TasksPeriod.ONETIMETASK,"Если ещё кто-нибудь родится или умрёт, я останусь без зарплаты)");

     // ДОБАВЛЯЕМ ЗАДАЧИ В МАПУ:
     TASK_SERVICE.addToMap(task1);
     TASK_SERVICE.addToMap(task2);
     TASK_SERVICE.addToMap(task3);
     TASK_SERVICE.addToMap(task4);
     TASK_SERVICE.addToMap(task5);
     TASK_SERVICE.addToMap(task6);
     TASK_SERVICE.addToMap(task7);
     TASK_SERVICE.addToMap(task8);


     TaskListMenu.TaskListMaintenance(); // божечки, задачи со сканера добавляются к задачам из конструктора :)

    }
}