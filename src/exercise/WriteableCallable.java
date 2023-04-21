package exercise;

import java.util.List;
import java.util.concurrent.Callable;

public class WriteableCallable implements Callable<List> {

    List<String> list;

    public WriteableCallable(List<String> list) {
        this.list = list;
    }

    @Override
    public List call() {
        list.add("Hello");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        list.add("World");

        return list;
    }
}
