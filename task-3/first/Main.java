package first;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int min = 100;
        int max = 999;
        int x = min + random.nextInt(max - min + 1);
        int sum = 0;
        int tempX = x;
        for (int i = 0; i < 3; i++) {
            sum += tempX % 10;
            tempX /= 10;
        }
        System.out.println(x);
        System.out.println(sum);
    }
}
