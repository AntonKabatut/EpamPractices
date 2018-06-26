package Practice5;

import java.util.ArrayList;
import java.util.List;

class Spam {

    private long[] time;
    private String[] messages;
    private List<Thread> threads;

    Spam(long[] time, String[] messages) {
        this.time = time;
        this.messages = messages;
        threads = new ArrayList<>();
    }

    void start() {
        for (int i = 0; i < time.length; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                String message = messages[finalI];
                long time = this.time[finalI];
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(time);
                        System.out.println(message);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }
    }

    void stop() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

}
