package Practice1;

public class SumOfNumber {

    public static void main(String[] args) {

        int sum = 0;

        int i = Integer.parseInt(args[0]);

        for (int x = i; x != 0; x /= 10) {
            sum += x % 10;
        }

        System.out.println(sum);
    }

}
