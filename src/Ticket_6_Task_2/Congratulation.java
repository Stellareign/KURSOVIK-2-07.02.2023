package Ticket_6_Task_2;

import java.time.LocalDate;
import java.util.Scanner;

public class Congratulation {
    static String toWhom;
    static LocalDate congratulationDate;
    static String congratulationText;
    static String friendName;
public static void congratulation() throws CongratulationException {
    Scanner scanner = new Scanner(System.in);
    try {
        if ((LocalDate.now().isBefore(LocalDate.of(2023, 02, 23))
                && LocalDate.now().isBefore(LocalDate.of(2023, 03, 8)))) {
            System.out.println("Кого вы хотите поздравить: мужчину - 1, женщину - 2");
            int addressee = scanner.nextInt();
            if (addressee > 0 && addressee <= 2) {
                switch (addressee) {
                    case 1:
                        toWhom = "Поздравление с Днём защитника Отечества получателю";
                        congratulationDate = LocalDate.of(2023, 02, 23);
                        break;
                    case 2:
                        toWhom = "Поздравление с Международным женским днём получателю";
                        congratulationDate = LocalDate.of(2023, 03, 8);
                }
            } else
                throw new CongratulationException("Вы никого не выбрали для поздравления. Укажите, кого Вы хотите поздравить!");
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите текст поздравления!");
            String congratulationTextScan = scanner1.nextLine();
            if (congratulationTextScan != null && !congratulationTextScan.isBlank() && !congratulationTextScan.isEmpty()) {
                congratulationText = congratulationTextScan;
            } else throw new CongratulationException("Напишите поздравление!");
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Введите имя получателя");
            String friendNameScan = scanner2.nextLine();
            if (!congratulationTextScan.isBlank()) {
                friendName = friendNameScan;
            } else throw new CongratulationException("Укажите имя получателя!");
            System.out.println(toWhom + " " + friendName + " *" + congratulationText + "* будет отправлено " + congratulationDate);
        } else
            throw new CongratulationException("Вы опоздали, не забудьте поздравить друзей и близких в следующем году");
    } catch (CongratulationException e) {
        System.out.println(e.getMessage());
    }
}
}

