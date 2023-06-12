/*
 * 2) Вывести все простые числа от 1 до 1000
 */


public class hw_001_02 {
    public static void main(String[] args) {
        System.out.print("Все простые числа от 1 до 1000: 1, 2");
        for (int i = 3; i < 1001; i++) {
            int cnt = 0;
            for (int j = 1; j <= i/2; j++) {
                cnt = ((i % j) == 0)? ++cnt: cnt;
                if(cnt > 1) break;               
            }
            if(cnt <= 1) {
                System.out.printf(", %d", i);
            }
            
        }
    }
}
