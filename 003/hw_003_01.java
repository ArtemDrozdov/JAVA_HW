import java.util.ArrayList;
import java.util.Random;

/**
 * Пусть дан произвольный список целых чисел.
 * 1) Нужно удалить из него чётные числа
 * 2) Найти минимальное значение
 * 3) Найти максимальное значение
 * 4) Найти среднее ариф. значение
 */
public class hw_003_01 {
    public static void main(String[] args) {
        ArrayList<Integer> collection = createArrayListRnd(10, 10, 99);

        System.out.printf("Произвольный список целых чисел:\n%s \n", collection);
        System.out.printf("Нужно удалить из него чётные числа:\n%s \n", deleteEvenArrayList(collection));
        System.out.printf("Найти минимальное значение:\n%d \n", getMinValue(collection));
        System.out.printf("Найти максимальное значение:\n%d \n", getMaxValue(collection));
        System.out.printf("Найти среднее ариф. значение:\n%f \n", getAverage(collection));

    }

    private static ArrayList<Integer> createArrayListRnd(int size, int min, int max) {
        ArrayList<Integer> collection = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < size; i++) {
            collection.add(rnd.nextInt(max - min + 1) + min);
        }
        return collection;
    }

    private static ArrayList<Integer> deleteEvenArrayList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                --i;
            }
        }
        return list;
    }

    private static int getMinValue(ArrayList<Integer> list) {
        int min_pos = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(min_pos)) 
                min_pos = i;
            
        }
        return list.get(min_pos);
    }

    private static int getMaxValue(ArrayList<Integer> list) {
        int max_pos = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(max_pos)) 
                max_pos = i;
            
        }
        return list.get(max_pos);
    }

    private static double getAverage(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum/list.size();
    }
    
}
