package Ticket_6_Task_1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
 public static void main(String[] args) {
  Book book1 = new Book("Война и мир");
  Book book2 = new Book("Мёртвые души");
  Book book3 = new Book("JAVA для новичков");
  Book book4 = new Book("Хороший программист");
  Book book5 = new Book("Бемби");
  Book book6 = new Book("Макс Фрай");
  Book book7 = new Book("Стальная крыса");
  Book book8 = new Book("Волшебник изумрудного города");
  Book book9 = new Book("О дивный новый мир");
  List<Book> allBooks = new ArrayList<>((Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9)));
  String str = "\n";
  String list = allBooks.stream().map(Objects::toString).collect(Collectors.joining(str));
  System.out.println(list);
  // СОЗДАЁМ ЛИСТ КНИГ, ОТСОРТИРОВАННЫХ ПО АЛФАВИТУ И ПО ПОЛКАМ
  System.out.println("\n Книги по полкам: ");
  List<ArrayList<Book>> sortedBooksPerShelves = addBooksPerShelves(allBooks);
  sortedBooksPerShelves.forEach(System.out::println);
 }

  public static List<ArrayList<Book>> addBooksPerShelves (List < Book > allBooks) {
   List<Book> sortedBooks = allBooks.stream()
           .sorted(Comparator.comparing(Book::getBookTitle)) // отсортировали по названию
           .collect(Collectors.toList()); // запулили из потока обратно в лист
   List<ArrayList<Book>> bookcase = IntStream // поток примитивов - для индексов-количества полок в листе-шкафу
           .rangeClosed(0, 4) // поток из диапазона чисел
           .mapToObj(s -> new ArrayList<Book>()) // преобразование в поток "книжный шкаф", состоящий из листов-полок
           .collect(Collectors.toList()); // поток "книжный шкаф" в лист
   int booksPerShelf = sortedBooks.size() / bookcase.size(); // количество книг на полке
   int shelfWithBooks = sortedBooks.size() % bookcase.size(); // количество полок для дозаполнения
   int skip = 0; // уже попавшие на полку книги
   for (int i = 0; i < bookcase.size(); i++) { // проходимся по полкам шкафа
    int limit; // предел кол-ва книг на полке
    if (i + 1 <= shelfWithBooks) limit = booksPerShelf + 1; // если индекс cлед. полки с книгами <= кол-ву необходимых для дозаполн.полок, увеличиваем лимит полки
    else limit = booksPerShelf; //иначе лимит равен кол-ву книг на полке

    List<Book> currentBooks = sortedBooks.stream() // создаём поток отсортированных книг на полке
            .skip(skip) // откидывем те, что уже на полке
            .limit(limit) // ограничиваем лимитом на полку
            .collect(Collectors.toList()); // преобр. в лист
    skip = skip + limit;
    bookcase.get(i).addAll(currentBooks); // добавили все элементы коллекции currentBooks в коллекцию bookcase в порядке итератора currentBooks
   }
   return bookcase;
  }
 }