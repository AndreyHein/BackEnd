public class Main3 {

    public static void main(String[] args) {
        Task2 thread1= new Task2(1,1_000_001);
        Task2 thread2= new Task2(1_000_001,2_000_001);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("result: " + (thread1.getCounter()+thread2.getCounter()));

    }

    public static boolean isAcceptableNumber(int i) {
        return i % 21 == 0;
    }
}
class Task2 extends Thread{
    private int rangeStart;
    private int rangeEnd;
    private int counter=0;

    public Task2(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        for (int i = rangeStart; i < rangeEnd ; i++) {
            if(Main3.isAcceptableNumber(i) ){
                counter++;
            }
        }
    }
}


