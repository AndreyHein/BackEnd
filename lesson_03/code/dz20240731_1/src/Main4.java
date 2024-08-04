import java.util.concurrent.atomic.AtomicInteger;

public class Main4 {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Task3 thread1= new Task3(1,1_000_001);
        Task3 thread2= new Task3(1_000_001,2_000_001);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("result: " + counter);

    }

    public static  void incrementCounter(){
        counter.getAndIncrement();
    }
    public static boolean isAcceptableNumber(int i) {
        return i % 21 == 0;
    }
}

class Task3 extends Thread{
    private int rangeStart;
    private int rangeEnd;

    public Task3(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void run() {
        for (int i = rangeStart; i < rangeEnd ; i++) {
            if(Main4.isAcceptableNumber(i) ){
                Main4.incrementCounter();
            }
        }
    }
}
