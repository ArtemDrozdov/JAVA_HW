import java.util.*;

/**
 * Задание
 * Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном
 * порядке и каждый из их узлов содержит одну цифру.
 * 1) Умножьте два числа и верните произведение в виде связанного списка.
 * 2) Сложите два числа и верните сумму в виде связанного списка. Одно или два
 * числа могут быть отрицательными.
 * 
 * Даны два Deque, цифры в обратном порядке.
 * [3,2,1] - пример Deque
 * [5,4,3]- пример второго Deque
 * 1) 123 * 345 = 42 435
 * Ответ всегда - связный список, в обычном порядке
 * [4,2,4,3,5] - пример ответа
 * 
 */
public class hw_004_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<String> numbDQ1 = new ArrayDeque<>();
        String inputNumbFirst;
        System.out.println(
                "Введите первое число Deque (цифры в обратном порядке через пробел и если отрицательное, то минус в конце):");
        inputNumbFirst = sc.nextLine();
        numbDQ1 = fillDeque(inputNumbFirst);
        //
        Deque<String> numbDQ2 = new ArrayDeque<>();
        String inputNumbSecond;
        System.out.println(
                "Введите второе число Deque (цифры в обратном порядке через пробел и если отрицательное, то минус в конце):");
        inputNumbSecond = sc.nextLine();
        numbDQ2 = fillDeque(inputNumbSecond);
        //
        String numb_1 = dequeToString(numbDQ1);
        String numb_2 = dequeToString(numbDQ2);

        double res_mult = Double.parseDouble(numb_1) * Double.parseDouble(numb_2);
        double res_summ = Double.parseDouble(numb_1) + Double.parseDouble(numb_2);
        System.out.printf("Произведение: %f\nСумма: %f\n", res_mult, res_summ);
        LinkedList<String> res_mult_LL = rezLL(res_mult);
        LinkedList<String> res_summ_LL = rezLL(res_summ); 

        sc.close();
    }

    private static Deque<String> fillDeque(String inputNumb) {
        Deque<String> numbDQ = new ArrayDeque<>();
        String[] numb = inputNumb.split(" ");

        for (int i = 0; i < numb.length; i++) {
            numbDQ.addFirst(numb[i]);
        }
        System.out.println("numbDQ = " + numbDQ);
        System.out.println("size numbDQ = " + numbDQ.size());
        return numbDQ;
    }

    private static String dequeToString(Deque<String> deque) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deque.size(); i++) {
            sb.append(deque.pollFirst().toString());
            i--; // переспросить почему без него постоянно обрезалось число пополам
        }
        System.out.printf("Число dequeToString: %f\n", Double.parseDouble(sb.toString()));
        return sb.toString();
    }

    private static LinkedList<String> rezLL (double numb) {
        List<String> numb_L = Arrays.asList(Double.toString(numb).split(""));
        LinkedList<String> numb_LL = new LinkedList<>(numb_L);
        System.out.printf("Cвязный список: %s\n", numb_LL);
        return numb_LL;
    }


}
