import java.util.Random;

// Kristiyan Stoilov (260990847)

public class Mouse {
    // Variables declaration (+initialization)
    private static int idReference = 0;
    private int id;
    private int hunger;
    private boolean caught;

    // Class constructor
    public Mouse(){
        this.id = idReference +1;
        idReference++;
        Random randomHunger = new Random();;
        this.hunger = randomHunger.nextInt((3-1) + 1) + 1;
        this.caught = false;
    }

    // Create new random hunger for mouse
    public void setNewHunger() {
        Random randomHunger = new Random();;
        this.hunger = randomHunger.nextInt((3-1) + 1) + 1;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public int getHunger() {
        return hunger;
    }

    public boolean getStatus() {
        return caught;
    }

    public void setCaught() {
        this.caught = true;
    }
}
