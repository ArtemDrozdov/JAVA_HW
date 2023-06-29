import java.util.*;
import Laptop;

/**
 * Урок 6. Хранение и обработка данных ч3: множество коллекций Set
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
 * методы. Реализовать в java.
 * Создать множество ноутбуков.
 * Написать метод, который будет запрашивать у пользователя критерий фильтрации
 * и выведет ноутбуки, отвечающие фильтру.
 * NoteBook notebook1 = new NoteBook
 * NoteBook notebook2 = new NoteBook
 * NoteBook notebook3 = new NoteBook
 * NoteBook notebook4 = new NoteBook
 * NoteBook notebook5 = new NoteBook
 * 
 * Например: “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет
 * 
 * Далее нужно запросить минимальные значения для указанных критериев -
 * сохранить параметры фильтрации можно также в Map.
 * 
 * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
 * условиям.
 * 
 * Класс сделать в отдельном файле
 * 
 * приветствие
 * Выбор параметра
 * выбор конкретнее
 * вывод подходящих
 */
public class hw_006_01 {
    // public static Scanner sc = new Scanner(System.in, "cp866");

    public static void main(String[] args) {
        System.out.flush();

        Set<Laptop> laptops = createLaptop();
        // System.out.println(laptops);

        Map<Integer, Object> criteria = getCriteria();
        Set<Laptop> filteredLaptop = filteredLaptop(laptops, criteria);

        for (Laptop item : filteredLaptop) {
            System.out.println(item);
        }

    }

    // Множество ноутбуков
    private static Set<Laptop> createLaptop() {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("HP", 15.6, 4, 256, "Windows", "Black"));
        laptops.add(new Laptop("HP", 14.0, 8, 512, "Ubuntu", "Silver"));
        laptops.add(new Laptop("HP", 17.3, 16, 1024, "Linux", "Red"));
        laptops.add(new Laptop("HP", 13.3, 32, 2048, "Windows", "White"));
        laptops.add(new Laptop("ASUS", 15.6, 4, 256, "Windows", "Black"));
        laptops.add(new Laptop("ASUS", 14.0, 8, 512, "Ubuntu", "Silver"));
        laptops.add(new Laptop("ASUS", 17.3, 16, 1024, "Linux", "Red"));
        laptops.add(new Laptop("ASUS", 13.3, 32, 2048, "Windows", "White"));
        laptops.add(new Laptop("Lenovo", 15.6, 4, 256, "Windows", "Black"));
        laptops.add(new Laptop("Lenovo", 16.0, 8, 512, "Ubuntu", "Silver"));
        laptops.add(new Laptop("Lenovo", 17.3, 16, 1024, "Linux", "Red"));
        laptops.add(new Laptop("Lenovo", 13.3, 32, 2048, "Windows", "White"));
        laptops.add(new Laptop("Xiaomi", 15.6, 4, 256, "Windows", "Black"));
        laptops.add(new Laptop("Xiaomi", 16.0, 8, 512, "Ubuntu", "Silver"));
        laptops.add(new Laptop("Xiaomi", 17.3, 16, 1024, "Linux", "Red"));
        laptops.add(new Laptop("Xiaomi", 13.3, 32, 2048, "Windows", "White"));

        return laptops;
    }

    private static void infoMenu() {
        System.out.println("\nИнструкция поиска наличия Ноутбуков:");
        System.out.println("[1]. Выбрать Производителя");
        System.out.println("[2]. Выбрать размер Экрана");
        System.out.println("[3]. Выбрать размер ОЗУ");
        System.out.println("[4]. Выбрать размер Жесткого Диска");
        System.out.println("[5]. Выбрать Операционную Систему");
        System.out.println("[6]. Выбрать Цвет\n");
    }

    // Получение критериев
    private static Map<Integer, Object> getCriteria() {
        try (Scanner sc = new Scanner(System.in)) {
            Map<Integer, Object> criteria = new HashMap<>();

            System.out.println();
            infoMenu();
            int choice = sc.nextInt();

            Object criteriaValue = null;
            switch (choice) {
                case 1:
                    System.out.println("Выберите Производителя: 1 => HP; 2 => ASUS; 3 => Lenovo; 4 => Xiaomi;\n");
                    int brand_choice = sc.nextInt();

                    switch (brand_choice) {
                        case 1:
                            criteriaValue = "HP";
                            break;
                        case 2:
                            criteriaValue = "ASUS";
                            break;
                        case 3:
                            criteriaValue = "Lenovo";
                            break;
                        case 4:
                            criteriaValue = "Xiaomi";
                            break;
                        default: {
                            System.out.println("Некорректный выбор поля.");
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println(
                            "Выберите размер экрана: 1 => 13.3; 2 => 14.0; 3 => 15.6; 4 => 16.0; 5 => 17.3;\n");
                    int screen_choice = sc.nextInt();

                    switch (screen_choice) {
                        case 1:
                            criteriaValue = (double) 13.3;
                            break;
                        case 2:
                            criteriaValue = (double) 14.0;
                            break;
                        case 3:
                            criteriaValue = (double) 15.6;
                            break;
                        case 4:
                            criteriaValue = (double) 16.0;
                            break;
                        case 5:
                            criteriaValue = (double) 17.3;
                            break;
                        default: {
                            System.out.println("Некорректный выбор поля.");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Выберите объем ОЗУ: 1 => 4 ГБ; 2 => 8 ГБ; 3 => 16 ГБ; 4 => 32 ГБ;\n");
                    int ram_choice = sc.nextInt();

                    switch (ram_choice) {
                        case 1:
                            criteriaValue = 4;
                            break;
                        case 2:
                            criteriaValue = 8;
                            break;
                        case 3:
                            criteriaValue = 16;
                            break;
                        case 4:
                            criteriaValue = 32;
                            break;
                        default: {
                            System.out.println("Некорректный выбор поля.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println(
                            "Выберите объем жесткого диска: 1 => 256ГБ; 2 => 512ГБ; 3 => 1024ГБ; 4 => 2048ГБ;\n");
                    int hdd_choice = sc.nextInt();

                    switch (hdd_choice) {
                        case 1:
                            criteriaValue = 256;
                            break;
                        case 2:
                            criteriaValue = 512;
                            break;
                        case 3:
                            criteriaValue = 1024;
                            break;
                        case 4:
                            criteriaValue = 2048;
                            break;
                        default: {
                            System.out.println("Некорректный выбор поля.");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Выберите операционную систему: 1 => Windows; 2 => Ubuntu; 3 => Linux;\n");
                    int os_choice = sc.nextInt();

                    switch (os_choice) {
                        case 1:
                            criteriaValue = "Windows";
                            break;
                        case 2:
                            criteriaValue = "Ubuntu";
                            break;
                        case 3:
                            criteriaValue = "Linux";
                            break;
                        default: {
                            System.out.println("Некорректный выбор поля.");
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Выберите цвет: 1 => Black; 2 => Silver; 3 => Red; 4 => White;\n");
                    int color_choice = sc.nextInt();

                    switch (color_choice) {
                        case 1:
                            criteriaValue = "Black";
                            break;
                        case 2:
                            criteriaValue = "Silver";
                            break;
                        case 3:
                            criteriaValue = "Red";
                            break;
                        case 4:
                            criteriaValue = "White";
                            break;
                        default: {
                            System.out.println("Некорректный выбор поля.");
                            break;
                        }
                    }
                    break;

                default: {
                    System.out.println("Некорректный выбор критерия.");
                    return criteria;
                }
            }
            criteria.put(choice, criteriaValue);
            return criteria;
        }
    }

    // Фильтр ноутбуков по критериям
    private static Set<Laptop> filteredLaptop(Set<Laptop> laptops, Map<Integer, Object> criteria) {
        Set<Laptop> filteredLaptops = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean flagCriteria = false;

            for (Map.Entry<Integer, Object> entry : criteria.entrySet()) {
                int choice = entry.getKey();
                Object filterValue = entry.getValue();

                switch (choice) {
                    case 1:
                        String brand = laptop.getBrand();
                        if (brand.equalsIgnoreCase((String) filterValue)) {
                            flagCriteria = true;
                        }
                        break;
                    case 2:
                        Double screen_size = laptop.getScreenSize();
                        // System.out.println(filterValue.getClass());
                        // System.out.println(screen_size.getClass());
                        if (screen_size.equals(filterValue)) {
                            flagCriteria = true;
                        }
                        break;

                    case 3:
                        int ram = laptop.getRam();
                        if (ram == (int) filterValue) {
                            flagCriteria = true;
                        }
                        break;
                    case 4:
                        int storage = laptop.getHdd();
                        if (storage == (int) filterValue) {
                            flagCriteria = true;
                        }
                        break;
                    case 5:
                        String operatingSystem = laptop.getOpSystem();
                        if (operatingSystem.equalsIgnoreCase((String) filterValue)) {
                            flagCriteria = true;
                        }
                        break;
                    case 6:
                        String color = laptop.getColor();
                        if (color.equalsIgnoreCase((String) filterValue)) {
                            flagCriteria = true; // false;
                        }
                        break;
                    default:
                        flagCriteria = false;
                        break;
                }
                if (!flagCriteria) {
                    break; // Если ноутбук не соответствует хотя бы одному критерию, прекращаем проверку
                }
            }
            if (flagCriteria) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }

}