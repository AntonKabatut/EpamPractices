package Practice5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AsyncWorkingThreads {

    public static void main(String[] args) {
        int[][] matrix = fillMatrix(4, 100);

        int max = 0;
        long time = System.currentTimeMillis();
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                if (anAMatrix > max) {
                    max = anAMatrix;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("Without using threads, time: " + (System.currentTimeMillis() - time) + " ,value: " + max);

        paralelCalculate(matrix);

    }

    private static int[][] fillMatrix(int a, int b) {
        int[][] array = new int[a][b];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int count = (int) (Math.random() * 100);
                array[i][j] = count;
            }
        }
        return array;
    }

    private static void paralelCalculate(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                int max = 0;
                for (int j = 0; j < 100; j++) {
                    if (matrix[finalI][j] > max) {
                        max = matrix[finalI][j];
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                list.add(max);
            });
            thread.start();
            threads.add(thread);
        }
        threads.forEach((e) -> {
            try {
                e.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        System.out.println("Using paralel threads, time: " + (System.currentTimeMillis() - time) + " ,value: " + Collections.max(list));
    }

}
