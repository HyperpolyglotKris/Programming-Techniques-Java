
// Name: Kristiyan Stoilov
import java.util.Scanner;

public class Rotate {
    public static void main(String[] args) {
        // Matrix already given to us
        int[][] matrix = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 }
        };
        print(matrix);
        System.out.println("\n##############################\n");
        print(rotate180(matrix));
    }

    public static int[][] rotate180(int[][] matrix) {
        // Making a loop going through the first layer of the matrix
        for (int i = 0; i < matrix.length; i++) {
            // Only executing these lines if the index i is in the first half of the layer,
            // to avoid double swapping
            if (i <= matrix.length / 2 - 1) {
                // Swapping the values to reverse sort the array
                int[] swapArr = matrix[i];
                matrix[i] = matrix[matrix.length - (1 + i)];
                matrix[matrix.length - (1 + i)] = swapArr;
            }
            // Making a loop going through the second layer of the matrix but only the first
            // half of the index j to avoid double swapping
            for (int j = 0; j <= ((matrix[i].length / 2) - 1); j++) {
                // Swapping the values to reverse sort the array
                int swapInt = matrix[i][j];
                int matrixLength = matrix[i].length;
                matrix[i][j] = matrix[i][matrixLength - (1 + j)];
                matrix[i][matrixLength - (1 + j)] = swapInt;
            }
        }
        return matrix;
    }

    // Print method already given to us
    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
