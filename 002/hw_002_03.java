import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 3) Дана json-строка (можно сохранить в файл и читать из файла)
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст
 * строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
 * Пример вывода:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 */
public class hw_002_03 {
    // private static Logger logger = Logger.getLogger(hw_002_03.class.getName());

    public static void main(String[] args) {
        // logger.log(Level.INFO, String.format("Старт записи %d", 333));

        // String stud = "Студент ";
        // String get = "получил ";
        // String subject = "по предмету ";

        String strIn = readStringFile();
        System.out.printf("Изначальная строка JSON: \n%s\n", strIn);
        strIn = crop(strIn);

        // StringBuilder sb_out = new StringBuilder();

        // String[] persons = strIn.replaceAll("[\"{]", "").split("},");
        String[] persons = strIn.replaceAll("[\"{}]", "").split(", ");
        // System.out.println(Arrays.toString(persons));

        System.out.println("Вывод результата:");
        for (String per : persons) {
            // System.out.println(per);

            String[] keyValues = per.split(",");
            String name = null, grade = null, subject = null;

            for (String keyValue : keyValues) {
                // System.out.println(keyValue);
                String[] keyValueParts = keyValue.split(":");
                String key = keyValueParts[0];
                String value = keyValueParts[1];

                if (key.equalsIgnoreCase("фамилия"))
                    name = value;
                else if (key.equalsIgnoreCase("оценка"))
                    grade = value;
                else if (key.equalsIgnoreCase("предмет"))
                    subject = value;
                else
                    throw new IllegalStateException("Неизвестное поле");
            }
            System.out.printf("Студент %s получил %s по предмету %s.\n", name, grade, subject);
        }

    }

    private static String readStringFile() {
        String fileName = "hw_002_03_in.txt";
        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                result.append(line);
                // result.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private static String crop(String str) {
        return str.substring(1, str.length() - 1);
    }

}
