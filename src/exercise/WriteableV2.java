package exercise;

import java.util.*;
public class WriteableV2 extends Thread {

    List<String> list;
    public WriteableV2(List<String> list) {
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
