import java.util.Scanner;

/* 
3) Реализовать простой калькулятор (+-/*)
sc.next() - считывает 1 элемент
sc.nextInt() - считывает только число
sc.nextLine() - считывает строчку
Введите число: 4 \n
Введите знак: 
*/

public class hw_001_03 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        double result = 333;

        System.out.print("Введите первое число: ");
        double first_numb = inputScanner.nextDouble();
        System.out.print("Введите второе число: ");
        double second_numb = inputScanner.nextDouble();
        System.out.print("Введите арифметическое действие '+' '-' '*' '/': ");
        String operation = inputScanner.next();

        // if(operation == "+")
        // if("+".equals(operation))
        //      result =  first_numb + second_numb;
        
        switch (operation) {
                case "+":
                result =  first_numb + second_numb;
                break;
            case "-":
                result =  first_numb - second_numb;
                break;
            case "*":
                result =  first_numb * second_numb;
                break;
            case "/":
                result =  first_numb / second_numb;
                break;
            default:
                System.out.println("ошибочная операция");
                break;// return;
        }
        System.out.printf("%f %s %f = %f", first_numb, operation, second_numb, result);
        // System.out.printf(first_numb + " " + operation + " " + second_numb + " = " + result);
        inputScanner.close();
    }
}
