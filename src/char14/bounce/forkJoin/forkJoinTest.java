package char14.bounce.forkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 16:52.
 */
public class forkJoinTest {
    public static void main(String[] args) {
        final int SIZE = 10000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) numbers[i] = Math.random();
        Counter counter = new Counter(numbers, 0, numbers.length, new Filter() {
            @Override
            public boolean accept(double t) {
                return t > 0.5;
            }
        });
    }
}

interface Filter{
    boolean accept(double t);
}

class Counter extends RecursiveTask<Integer>{
    public static final int THREHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private Filter filter;

    public Counter(double[] values, int from, int to, Filter filter){
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    protected Integer compute(){
        if(to - from < THREHOLD){
            int count = 0;
            for (int i = from; i < to; i++){
                if(filter.accept(values[i])) count++;
            }
            return count;
        }else{
            int mid = (from + to) /2;
            Counter first = new Counter(values, from, mid, filter);
            Counter second = new Counter(values, mid, to, filter);
            invokeAll(first,second);
            return first.join() + second.join();
        }
    }
}
