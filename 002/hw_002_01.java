// package java_hw.hw_002;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть
 * WHERE этого запроса,
 * используя StringBuilder. Данные для фильтрации приведены ниже в виде
 * json-строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
 * "city":"Moscow", "age":"null"}
 * Пример вывода: "select * from students WHERE name = Ivanov AND country =
 * Russia.....".
 * ==================================================================================================
 * В файле содержится строка с исходными данными в такой форме:
 * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * Требуется на её основе построить и вывести на экран новую строку, в форме SQL
 * запроса:
 * SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
 * Для разбора строки используйте String.split. Сформируйте новую строку,
 * используя StringBuilder.
 * Значения null не включаются в запрос.
 */
public class hw_002_01 {
    public static void main(String[] args) {
        String request_SQL_str0 = "SELECT * FROM students WHERE ";
        // var s = System.currentTimeMillis();
        StringBuilder strOut = new StringBuilder();
        String strIn = readString();
        System.out.printf("Изначальная строка JSON: \n%s\n", strIn);

        // String[] request_SQL = strIn.replaceAll("[\"{}]", "").split(",");
        String[] request_SQL = strIn.replaceAll("[{]", "").split(", ");
        // System.out.println(Arrays.toString(request_SQL));

        strOut.append(request_SQL_str0);

        boolean isFirst = true; // для исключения первого AND

        for (String selectPart : request_SQL) {
            String[] keyValue = selectPart.split(":");
            String key = keyValue[0];
            key = key.substring(1, key.length()-1);
            String value = keyValue[1];
            // System.out.println(key);
            // System.out.println(value);

            if(value.equalsIgnoreCase("\"null\"")) // откидывание пустых ячеек
                continue;
            if(isFirst == false)
                strOut.append(" AND ");
            strOut.append(String.format("%s = %s", key, value));
            
            isFirst = false;
        }
        System.out.println("Полученная строка JSON в SQL:");
        System.out.println(strOut.toString().replace("}", ";"));
    }
    private static String readString() {
        String fileName = "hw_002_01_in.txt";
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

}
