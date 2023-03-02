import java.util.Scanner;

// Kristiyan Stoilov (260990847)

public class Main {
    public static void main(String[] args) {

//  Scanner for inputs (Was later instructed to hard-code instead)
//        Scanner myObj = new Scanner(System.in);
//        System.out.println();
//        System.out.print("Enter the amount of mice:");
//        int miceAmount = Integer.parseInt(myObj.nextLine());
//        System.out.println("You've entered : " + miceAmount + " mice.");
//        System.out.println();
//        System.out.print("Enter the amount of traps:");
//        int trapsAmount = Integer.parseInt(myObj.nextLine());
//        System.out.println("You've entered : " + trapsAmount + " traps.");
//        System.out.println();

//        X = Mice, Y = Traps
        int x = 5;
        int y = 3;

        Trap.setActiveTraps(y);

        // Create and start thread that runs the MouseThread runnable
        MouseThread mouseThread = new MouseThread(x);
        Thread mouseThreadThread = new Thread(mouseThread);
        mouseThreadThread.start();

        // Create and start thread that runs the MachineThread runnable
        MachineThread machineThread = new MachineThread();
        Thread machineThreadThread = new Thread(machineThread);
        machineThreadThread.start();

        // Create and start thread that runs the OwnerThread runnable
        OwnerThread ownerThread = new OwnerThread();
        Thread ownerThreadThread = new Thread(ownerThread);
        ownerThreadThread.start();
    }
}
