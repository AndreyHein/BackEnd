public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        for (int i=1000; i<1010; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " finish");
    }
}

