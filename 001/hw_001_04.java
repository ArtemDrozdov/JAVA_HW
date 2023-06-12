/*
4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. 
Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
Требуется восстановить выражение до верного равенства. 
Предложить хотя бы одно решение или сообщить, что его нет.
Под знаком вопроса - одинаковые цифры
Введите уравнение: ?? + ?? = 44
Ответ: 22 + 22 = 44
 */

public class hw_001_04 {
    public static void main(String[] args) {
        String uravnenie = "2? + ?5 = 69"; // 4
        String [] letters = uravnenie.split(" ");

        System.out.println(String.join(", ", letters));
        // System.out.println(Arrays.toString(letters));


        String[] strArray = { "молоко", "мясо", "хлеб" };
        System.out.println(String.join(", ", strArray));
    }
}
