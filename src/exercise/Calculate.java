package exercise;

import java.util.concurrent.Callable;

public class Calculate implements Callable<Integer> {

    int x;
    int y;

    public Calculate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        return x / y;
    }
}
