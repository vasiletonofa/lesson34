package exercise;

import java.util.List;

public class Writeable implements Runnable {

    List<String> list;

    public Writeable(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.add("Hello");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        list.add("World");
    }
}
