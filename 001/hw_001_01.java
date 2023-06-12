import java.util.Scanner;

/*
 * 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), 
 * 1 + 2 + 3 + ...
 * n! (произведение чисел от 1 до n)
 * 1*2*3*...
 */


public class hw_001_01 {
    public static void main(String[] args) {
        Scanner input_numb = new Scanner(System.in);
        System.out.print("Введите число: ");
        int numb_tmp = input_numb.nextInt();
        int sum = 0;
        int fact = 1;
        for (int i = 1; i <= numb_tmp; i++) {
            sum += i;
            fact *= i;
        }
        System.out.printf("N-ое треугольное число = %d, факториал = %d", sum, fact);
        input_numb.close();
    }
}

    // Scanner sk = new Scanner(System.in,"cp866");
        // System.out.print("Введите число: ");
        // int n = sk.nextInt();
        // sk.close();
        // System.out.println(n*(n-1)/2);
