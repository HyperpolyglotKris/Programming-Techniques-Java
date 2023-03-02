// Kristiyan Stoilov (260990847)

import java.util.concurrent.locks.ReentrantLock;

public class OwnerThread implements Runnable{
    private static ReentrantLock lock = new ReentrantLock();

    // Method to be executed by the Thread
    @Override
    public void run() {
        while (MouseThread.miceArray.size() > 0) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Remove all caught mice and print (source == 3)
            Trap.setCheeseLost(Trap.getCheeseLost(),3,0);
        }
    }
}
