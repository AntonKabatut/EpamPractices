package Practice5;

import java.util.ArrayList;
import java.util.List;

public class SyncWorkingThreads {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        Counter counter = new Counter(0, 0);

        for (int j = 0; j < 2; j++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(counter.countOne > counter.countTwo);
                    counter.countOne++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter.countTwo++;
                }
            });
            thread.start();
            threads.add(thread);
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int j = 0; j < 2; j++) {
            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    synchronized (counter) {
                        System.out.print(Thread.currentThread() + " ");
                        System.out.println(counter.countOne > counter.countTwo);
                        counter.countOne++;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        counter.countTwo++;
                    }
                }
            }).start();
        }

    }

}
