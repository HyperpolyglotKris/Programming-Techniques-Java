// Kristiyan Stoilov (260990847)

import java.util.concurrent.locks.ReentrantLock;

public class MachineThread implements Runnable{
    private static ReentrantLock lock = new ReentrantLock();

    // Method to be executed by the Thread
    @Override
    public void run() {
        while (MouseThread.miceArray.size()>0) {
            // Add available cheese amount and print (source == 2)
            Trap.setCheeseLost(Trap.getCheeseLost(),2, 0);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
