// Kristiyan Stoilov (260990847)

public class Trap {
    // Variables declaration
    private static int cheeseAmount;
    private static int cheeseLost;
    private static int activeTraps;

    // Getters and Setters
    public static int getCheeseAmount() {
        return cheeseAmount;
    }

    public static void setCheeseAmount(int cheeseAmount) {
        Trap.cheeseAmount = cheeseAmount;
    }

    public static int getCheeseLost() {
        return cheeseLost;
    }

    public static synchronized void setCheeseLost(int cheeseLost, int source, int i) {
        Trap.cheeseLost = cheeseLost;
        // Execute if coming from MouseThread and is caught
        if (source == 0) {
            System.out.println();
            System.out.println("[Status] Mouse-" + MouseThread.miceArray.get(i).getId() + " got caught by a trap.");
            Trap.setActiveTraps(Trap.getActiveTraps() - 1);
            MouseThread.miceArray.get(i).setCaught();
        }
        // Execute if coming from MouseThread but ate cheese
        else if (source == 1) {
            System.out.println();
            System.out.println("[Action] Mouse-" + MouseThread.miceArray.get(i).getId() + " ate " + MouseThread.miceArray.get(i).getHunger() + " grams of cheese.");
            Trap.setCheeseAmount(Trap.getCheeseAmount() - MouseThread.miceArray.get(i).getHunger());
            System.out.println("[Status] Cheese left: " + Trap.getCheeseAmount());
            MouseThread.miceArray.get(i).setNewHunger();
        }
        // Execute if coming from MachineThread
        else if (source ==2) {
            Trap.setCheeseAmount(Trap.getCheeseAmount() + 10);
            System.out.println();
            System.out.println("[Action] Cheese Machine added 10 grams of cheese.");
            System.out.println("[Status] Cheese left: " + Trap.getCheeseAmount());
        }
        // Execute if coming from OwnerThread
        else if (source == 3) {
            System.out.println("=========================");
            for (int j = 0; j < MouseThread.miceArray.size(); j++) {
                if (MouseThread.miceArray.get(j).getStatus() == true) {
                    System.out.println("[Action] Store owner removed Mouse-" + MouseThread.miceArray.get(j).getId());
                    Trap.setActiveTraps(Trap.getActiveTraps()+1);
                    MouseThread.miceArray.remove(j);
                    j--;
                }
            }
            System.out.println("=========================");
        }
    }

    public static int getActiveTraps() {
        return activeTraps;
    }

    public static void setActiveTraps(int activeTraps) {
        Trap.activeTraps = activeTraps;
    }
}
