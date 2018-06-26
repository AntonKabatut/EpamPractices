package Practice5;

import java.util.Scanner;

public class SpammingMessage {

    public static void main(String[] args) throws InterruptedException {
        long[] time = new long[]{1000, 2000};
        String[] messages = new String[]{"Hello", "Bye"};
        Spam spam = new Spam(time, messages);
        spam.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        spam.stop();
    }

}
