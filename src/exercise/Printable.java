package exercise;

import java.util.*;

public class Printable implements Runnable {

    List<String> list;

    public Printable(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for(String value : list) {
            System.out.println(value);
        }
    }
}
