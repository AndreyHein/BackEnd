public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread 1 start");

        for (int i = 100; i < 110; i++) {
            System.out.println(getName() + " " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("MyThread 1 finish");
    }
}
