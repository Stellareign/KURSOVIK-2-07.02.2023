package TaskList;

import TaskList.Enums.TasksPeriod;
import TaskList.Enums.Type;
import TaskList.Exceptions.IncorrectArgumentException;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import static java.lang.System.out;


//  public Task(String title, Type type, LocalDateTime dateTime, TasksPeriod tasksPeriod, String description
//                 ) throws IncorrectArgumentException {
public class TaskScanner {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    Scanner scanner = new Scanner(System.in);

    public static String scanTitle(Scanner scanner) {
        while (true) { // позволяет перезапускать программу при ошибке
            try {
                out.println("Введите название задачи: ");
                String scanTitle = scanner.nextLine();
                if (scanTitle != null && !scanTitle.isBlank() && !scanTitle.isEmpty()) {
                    return scanTitle;
                } else throw new IncorrectArgumentException("Не указано название задачи. Введите название задачи!");
            }catch (IncorrectArgumentException e) {
                out.println(e.getMessage());
            }
        }
    }

    public static Type scanType(Scanner scanner) {
        while (true) {
            try {
                out.println("Введите тип задачи (цифрой): 0 - личная, 1 - рабочая:");
                String numberOfType = scanner.nextLine();
                int typeNumber = Integer.parseInt(numberOfType);
                if (typeNumber == 0) {
                    return Type.PERSONAL;
                } else if (typeNumber == 1) {
                    return Type.WORK;
                }
            } catch (NumberFormatException e) {
                out.println("Тип задачи указан неверно. Введите правильно тип задачи (цифрой):  0 - личная или 1 - рабочая");
            }
        }
    }

    public static TasksPeriod scanPeriod(Scanner scanner) {
        while (true) {
            try {
                out.println("Укажите периодичность задачи (цифрой): \n" +
                        "0 - однократная; 1 - ежедневная, 2 - еженедельная, 3 - ежемесячная; 4 - ежегодная");
                String numberOfPeriod = scanner.nextLine();
                int periodNumber = Integer.parseInt(numberOfPeriod);
                if (periodNumber == 0) {
                    return TasksPeriod.ONETIMETASK;
                }
                if (periodNumber == 1) {
                    return TasksPeriod.DALYTASK;
                }
                if (periodNumber == 2) {
                    return TasksPeriod.WEEKLYTASK;
                }
                if (periodNumber == 3) {
                    return TasksPeriod.MONTHLYTASK;
                }
                if (periodNumber == 4) {
                    return TasksPeriod.YEARLYTASK;
                }
            } catch (NumberFormatException e) {
                out.println("Периодичность указана неверно. Введите правильно периодичность задачи (цифрой): \n" +
                        "0 - однократная; 1 - ежедневная, 2 - еженедельная, 3 - ежемесячная; 4 - ежегодная");
            }
            }
    }
    public static String scanDescription(Scanner scanner) {
        out.println("Введите описание задачи (необязательно): ");
        return scanner.nextLine();
                }

    public static LocalDate scanDate(Scanner scanner) {
        while (true) {
            try {
                out.println("Введите запланированную дату в формате дд.мм.гггг: ");
                String dateLine = scanner.nextLine();
                if (dateLine != null && !dateLine.isBlank()) {
                    LocalDate dateLineFormat = LocalDate.parse(dateLine, DATE_FORMATTER);
                    if (dateLineFormat.equals(LocalDate.now()) || dateLineFormat.isAfter(LocalDate.now()) ) {
                        return dateLineFormat;
                    } else throw new IncorrectArgumentException("Дата в прошлом! Введите правильно дату в формате дд.мм.гггг ");
                } else throw new IncorrectArgumentException("Дата указана неверно!");
            } catch (IncorrectArgumentException e) {
                out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                out.println("Неверный формат! Укажите дату в формате дд.мм.гггг.");
            }
        }
    }
    public static LocalTime scanTime (Scanner scanner) {
        while (true) {
            try {
                out.println("Введите запланированное время в формате чч:мм: ");
                String timeLine = scanner.nextLine();
                if (timeLine != null && !timeLine.isBlank()) {
                    LocalTime timeLineFormat = LocalTime.parse(timeLine, TIME_FORMATTER);
                    return timeLineFormat;
                } else
                    throw new IncorrectArgumentException("Неверный формат! Введите правильно запланированное время в формате чч:мм.");
            } catch (IncorrectArgumentException e) {
                out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                out.println("Время указано неверно.Введите правильно запланированное время в формате чч:мм.");
            }
        }
    }

    public static LocalDateTime scanDateTime(Scanner scanner) { // принимаем со сканера введённые дату и время в одну "строку"
        LocalDate localDate = scanDate(scanner);
        LocalTime localTime = scanTime(scanner);
        return localDate.atTime(localTime);
    }
}