public class Main2 {
    private static int counter=0;

    public static void main(String[] args) {
        Task1 thread1= new Task1(1,1_000_001);
        Task1 thread2= new Task1(1_000_001,2_000_001);

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

    public static synchronized void incrementCounter(){
        counter++;
    }
    public static boolean isAcceptableNumber(int i) {
        return i % 21 == 0;
    }
}
class Task1 extends Thread{
    private int rangeStart;
    private int rangeEnd;

    public Task1(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void run() {
        for (int i = rangeStart; i < rangeEnd ; i++) {
            if(Main2.isAcceptableNumber(i) ){
                Main2.incrementCounter();
            }
        }
    }
}


