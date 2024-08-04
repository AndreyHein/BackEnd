public class Main {
    public static void main(String[] args) {
        System.out.println("Main start");
        Long timer1 = System.currentTimeMillis();

        MyThread thread1 = new MyThread();
        Thread thread2 = new Thread(new Task());
        Thread thread3= new Thread(new Daemon());
        thread3.setDaemon(true);

        //thread1.run();   // not correct!!!
        thread1.start();
        thread2.start();
        thread3.start();


        for (int i = 1; i < 10; i++) {
            System.out.println("Main " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Long timer2= System.currentTimeMillis();
        System.out.println("Main finish  " + (timer2-timer1));
    }
}
