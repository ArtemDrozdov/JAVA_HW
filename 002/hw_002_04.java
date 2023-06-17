import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.Spring;

public class hw_002_04 {
    private static Logger logger = Logger.getLogger(hw_002_04.class.getName());
    public static void main(String[] args) throws IOException{

        // ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = new FileHandler("hw_002_04_log.txt");
        // logger.addHandler(ch);
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        // XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(sFormat);
        // fh.setFormatter(xml);

        // logger.setLevel(Level.INFO);
        logger.log(Level.WARNING, "Тестовое логирование 1");
        logger.info("Тестовое логирование 2");

        Scanner inputScanner = new Scanner(System.in);
        double result = 333;

        System.out.print("Введите первое число: ");
        double first_numb = inputScanner.nextDouble();
        logger.log(Level.INFO, String.format("Введено первое число: %f \n", first_numb));

        System.out.print("Введите второе число: ");
        double second_numb = inputScanner.nextDouble();
        logger.log(Level.INFO, String.format("Введено второе число: %f \n", second_numb));

        System.out.print("Введите арифметическое действие '+' '-' '*' '/': ");
        String operation = inputScanner.next();
        logger.log(Level.INFO, String.format("Введено арифметическое действие: %s \n", operation));

        result = calcSimple(first_numb, second_numb, operation);//.toString();
        System.out.printf("%f %s %f = %f", first_numb, operation, second_numb, result);
        logger.log(Level.INFO, String.format("%f %s %f = %f \n", first_numb, operation, second_numb, result));

        inputScanner.close();

    }
    private static double calcSimple (double first_numb, double second_numb, String operation) {
        switch (operation) {
            case "+":
                return first_numb + second_numb;
                // break;
            case "-":
                return first_numb - second_numb;
                // break;
            case "*":
                return first_numb * second_numb;
                // break;
            case "/":
                return first_numb / second_numb;
                // break;
            default:
                System.out.println("ошибочная операция");
                return 333;
                // continue;
        }
    }
}
