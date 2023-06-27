import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap.
 * Программа также должна учитывать, что во входной структуре будут
 * повторяющиеся имена с разными телефонами, их необходимо считать, как одного
 * человека с разными телефонами. Вывод должен быть отсортирован по убыванию
 * числа телефонов.
 * 
 * Пример ввода:
 * Иванов 234234
 * Иванов 32523
 * Иванов 5687
 * Иванов: 234234, 32523, 5687
 * 
 * Варианты Map:
 * Map<String, ArrayList>
 * Map<String, String>
 * 
 * Пример меню:
 * 1. Добавить контакт
 * 2. Вывести всех
 * 3. Выход
 */
public class hw_005_01 {
    public static Scanner sc = new Scanner(System.in, "cp866");

    public static void main(String[] args) {
        phonebook();
    }

    private static void infoMenu() {
        System.out.println("\nИнструкция:");
        System.out.println("[1]. Показать весь справочник");
        System.out.println("[2]. Добавить контакт");
        // System.out.println("[3]. Поиск по справочнику");
        // System.out.println("[4]. Редактировать контакт");
        // System.out.println("[5]. Удалить контакт");
        System.out.println("[0]. Выход\n");
    }

    private static void showAllContacts(Map<String, String> phBook) {
        System.out.println("Весь справочник: ");
        for (var item : phBook.entrySet()) {
            System.out.printf("{%s: %s}\n", item.getKey(), item.getValue());
        }
    }

    private static void addContact(Map<String, String> phBook) {
        System.out.println("Введите фамилию: ");
        String surname = sc.nextLine();
        // name = input("Введите имя: ")
        // patronymic = input("Введите отчество: ")
        System.out.println("Введите телефон: ");
        String phone = sc.nextLine();

        if (phBook.containsKey(surname)) {
            String addPhone = phBook.get(surname);
            addPhone = addPhone + ", " + phone;
            phBook.put(surname, addPhone);
        } else
            phBook.put(surname, phone);
    }

    private static void phonebook() {
        Map<String, String> phBook = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String choice = null;

        while (true) {
            infoMenu();
            System.out.println("Введите операцию: ");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    showAllContacts(phBook);
                    break;
                case "2":
                    addContact(phBook);
                    break;
                case "0":
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("\nНеверный ввод");
                    break;
            }
        }
    }
}
