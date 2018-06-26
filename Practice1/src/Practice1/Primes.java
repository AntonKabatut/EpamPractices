package Practice1;

import java.util.Arrays;

public class Primes {

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int[] array = new int[size];
        int count = 0;
        for (int i = 2; count < array.length; i++) {
            if (check(i)) {
                array[count] = i;
                count++;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static boolean check(int number) {
        int count = 0;
        boolean b = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) count++;
        }
        if (count > 0) b = false;

        return b;
    }

}
