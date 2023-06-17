// package hw_002;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// import hw_002_02;

/**
 * 2) Реализуйте алгоритм сортировки пузырьком числового массива,
 * результат после каждой итерации запишите в лог-файл.
 */
public class hw_002_02 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(hw_002_02.class.getName());
        // ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = new FileHandler("hw_002_02_log.txt");
        // logger.addHandler(ch);
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        // XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(sFormat);
        // fh.setFormatter(xml);

        // logger.setLevel(Level.INFO);
        logger.log(Level.WARNING, "Тестовое логирование 1");
        logger.info("Тестовое логирование 2");

        int[] array = new int[] {1, 9, 2, 8, 3, 7, 4, 6, 5, 0};
        int count = 0;
        String msg = null;

        for (int current = 0; current < array.length - 1; current++) {
            for (int i = 0; i < (array.length - 1 - current); i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    msg = String.format("%5d. Массив стал %s \n", count++, Arrays.toString(array));
                } else {
                    msg = String.format("%5d. Массив не изменился с предыдущей итерации \n", count++);
                }

                logger.log(Level.INFO, msg);
            }
        }
        msg = String.format("Произведено операций: %d.\nРезультат сортировки: %s", count, Arrays.toString(array));
        logger.log(Level.INFO, msg);

    }
}
