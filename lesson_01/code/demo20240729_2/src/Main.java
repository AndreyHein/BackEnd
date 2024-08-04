public class Main {
    static int counter =0;

    public static void main(String[] args) {
        Thread thread1= new Thread(new Task(1_000_000));
        Thread thread2= new Thread(new Task(1_000_000));
        Thread thread3= new Thread(new Task(1_000_000));
        Thread thread4= new Thread(new Task(1_000_000));

        Thread[] threads = {thread1,thread2,thread3,thread4};
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(counter);

    }


    public static void  add(){
        counter++;
    }
}

