package FunctionTask;

 // НЕ ПОНЯЛА, ПОЧЕМУ ЗАДАЧА НЕ ПЕРЕНЕСЛАСЬ С ППРОШЛОГО ФАЙЛА ПРОЕКТА, случайно заметила её отсутствие

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
 public static void main(String[] args)  {
  String myString = "Полюшко, поле, \n" +
          "Полюшко - широко поле, \n" +
          "Едут да по полю герои, \n" +
          "Эх, да Красной армии герои.";
  System.out.println(myString);

  Arrays.stream(myString.split("[, \n-]"))
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
          .entrySet()
          .stream()// создаём поток
          .sorted(Map.Entry.<String, Long> comparingByValue (Comparator.reverseOrder())
                  .thenComparing(Map.Entry.comparingByKey()))
          .limit(10)
          .forEach(a -> System.out.println(a.getKey() + " - " + a.getValue()));
 }
}