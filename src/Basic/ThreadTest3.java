package Basic;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest3 {
    private static volatile Integer i = 0;
    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (int j = 0; j < 2; j++) {
            Thread thread = new Thread(() -> {
                for (int k = 0; k < 5000; k++) {
                    synchronized (Integer.valueOf(i.intValue())) {
                        i++;
                    }
                }
            }, "" + j);
            list.add(thread);
        }
        list.stream().forEach(t -> t.start());
        list.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(i);
    }

}