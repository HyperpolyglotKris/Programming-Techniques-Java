import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

// Kristiyan Stoilov (260990847)

public class MouseThread implements Runnable {
    public static ArrayList<Mouse> miceArray = new ArrayList<>();
    private static ReentrantLock lock = new ReentrantLock();

    public MouseThread(int amountMice) {
        for (int i = 0; i <amountMice; i++) {
            miceArray.add(new Mouse());
        }
    }

    // Method to be executed by the Thread
    @Override
    public void run() {
        while (MouseThread.miceArray.size()>0) {
            // Start timer
            long startTime = System.nanoTime();
                for (int i = 0; i < miceArray.size(); i++) {
                    // If Mouse is already caught continue;
                    if (miceArray.get(i).getStatus() == true) {
                        continue;
                    }
                    // If Mouse's hunger is greater or equal the amount of cheese available
                    else if (miceArray.get(i).getHunger() <= Trap.getCheeseAmount()) {
                        // Verify if it gets caught (50% chance)
                        double random = Math.random();
                        // If caught, set to caught (source == 0)
                        if (random >= 0.5 && Trap.getActiveTraps() > 0) {
                            Trap.setCheeseLost(Trap.getCheeseLost(), 0, i);
                            continue;
                        }
                        // If not caught, eat cheese and reduce remaining amount of cheese and set new hunger (source == 1)
                        else {
                            Trap.setCheeseLost(Trap.getCheeseLost() + miceArray.get(i).getHunger(), 1, i);
                        }
                    }
                }
            // End timer
            long elapsedTime = System.nanoTime() - startTime;
            elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
            try {
                Thread.sleep(1000 - elapsedTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // When there are no mice left, print total loss of cheese
        if (MouseThread.miceArray.size()==0){
            System.out.println("Total Cheese lost = "+ Trap.getCheeseLost());
        }
    }
}
