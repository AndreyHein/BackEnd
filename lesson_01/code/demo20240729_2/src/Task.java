public class Task implements Runnable {
    int quantity;

    public Task(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantity; i++) {
            Main.add();
        }
    }
}

