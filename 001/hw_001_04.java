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
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // String uravnenie = "2? + 22 = 44"; // 2
        // String uravnenie = "?? + ?? = 44"; // 2
        String uravnenie = "2? + ?5 = 69"; // 4
        // String uravnenie = "2? + ?5 = 99"; // нет решения

        char[] chars = uravnenie.toCharArray();

        // for (int i = 0; i < chars.length; i++) {
        // if (i == chars.length - 1)
        // System.out.print(chars[i] + "\n");
        // else
        // System.out.print(chars[i] + " | ");
        // }

        String numb1_char1 = Character.toString(chars[0]);
        String numb1_char2 = Character.toString(chars[1]);
        String numb2_char1 = Character.toString(chars[5]);
        String numb2_char2 = Character.toString(chars[6]);
        boolean flag_ok = false;

        String ans_tmp = Character.toString(chars[10]) + Character.toString(chars[11]);
        int ans = Integer.parseInt(ans_tmp);

        for (int i = 0; i < 10; i++) {
            String numb1, numb2;

            if (isNumeric(numb1_char1))
                if (isNumeric(numb1_char2))
                    numb1 = numb1_char1 + numb1_char2;
                else
                    numb1 = numb1_char1 + Integer.toString(i);
            else if (isNumeric(numb1_char2))
                numb1 = Integer.toString(i) + numb1_char2;
            else
                numb1 = Integer.toString(i) + Integer.toString(i);

            if (isNumeric(numb2_char1))
                if (isNumeric(numb2_char2))
                    numb2 = numb2_char1 + numb2_char2;
                else
                    numb2 = numb2_char1 + Integer.toString(i);
            else if (isNumeric(numb2_char2))
                numb2 = Integer.toString(i) + numb2_char2;
            else
                numb2 = Integer.toString(i) + Integer.toString(i);

            if ((Integer.parseInt(numb1) + Integer.parseInt(numb2)) == ans){
                System.out.printf("В уравнении: %s - вопросу соответствует число %d\n", uravnenie, i);
                flag_ok = true;
            }
        }
        if (flag_ok == false)
            System.out.printf("В уравнении: %s - решения нет\n", uravnenie);

    }
}
