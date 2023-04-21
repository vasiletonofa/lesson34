package exercise;

import java.util.List;
import java.util.concurrent.Callable;

public class PrintableCallable implements Callable<List> {

    List<String> list;

    public PrintableCallable(List<String> list) {
        this.list = list;
    }

    @Override
    public List call() {
        for(String value : list) {
            System.out.println(value);
        }

        return list;
    }
}
