public class Daemon implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

