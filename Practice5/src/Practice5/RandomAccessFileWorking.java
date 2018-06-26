package Practice5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class RandomAccessFileWorking {

    private static int position = 0;
    private static long[] positions = new long[]{0, 21, 42, 63, 84, 105, 126, 147, 168, 189};
    private static int number = 0;

    public static void main(String[] args) {

        RandomAccessFile randomAccessFile = null;
        List<Thread> threads = new ArrayList<>();

        try {
            randomAccessFile = new RandomAccessFile("part5.txt", "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {

            RandomAccessFile finalRandomAccessFile = randomAccessFile;
            Thread thread = new Thread(() -> writeToFile(finalRandomAccessFile));
            thread.start();

        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        String st;
        try {
            for (int i = 0; i < 10; i++) {
                if (randomAccessFile != null) {
                    randomAccessFile.seek(positions[i]);
                    st = randomAccessFile.readLine();
                    System.out.println(st);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static synchronized void writeToFile(RandomAccessFile randomAccessFile) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            stringBuilder.append(number);
        }
        stringBuilder.append(System.lineSeparator());

        try {
            randomAccessFile.seek(positions[position]);
            randomAccessFile.writeBytes(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        position++;
        number++;
    }

}
