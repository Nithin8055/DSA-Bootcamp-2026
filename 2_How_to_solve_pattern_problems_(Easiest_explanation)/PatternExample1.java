/**
 * EXAMPLE 1: Simple Number Pattern
 *
 * Problem Statement:
 * Print numbers from 1 to n, each on a new line
 *
 * Pattern Analysis:
 * - How Many Rows? → n rows (equal to input)
 * - How Many Columns? → 1 column per row
 * - What to Print? → The row number itself (i)
 *
 * Example Output for n = 4:
 * 1
 * 2
 * 3
 * 4
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class PatternExample1 {

    /**
     * Prints a simple number pattern from 1 to n
     *
     * @param n the upper limit of the pattern
     */
    public static void printPattern1(int n) {
        // Validate input
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        // Outer loop for ROWS
        // This loop controls how many numbers to print
        for (int i = 1; i <= n; i++) {
            // Print the row number
            System.out.print(i);

            // Newline after each row
            System.out.println();
        }
    }

    /**
     * Alternative version with more detailed comments
     *
     * @param n the number of rows
     */
    public static void printPattern1Verbose(int n) {
        System.out.println("\n--- VERBOSE VERSION ---");

        for (int i = 1; i <= n; i++) {
            System.out.println("Row " + i + ": Printing " + i);
        }
    }

    /**
     * Main method to demonstrate the pattern
     */
    public static void main(String[] args) {
        System.out.println("=== PATTERN EXAMPLE 1: Simple Number Pattern ===\n");

        // Test with different values
        System.out.println("For n = 4:");
        printPattern1(4);

        System.out.println("\nFor n = 5:");
        printPattern1(5);

        // Verbose version
        System.out.println("\nFor n = 3 (Verbose):");
        printPattern1Verbose(3);

        // Edge cases
        System.out.println("\n--- EDGE CASES ---");
        System.out.println("\nFor n = 1:");
        printPattern1(1);

        System.out.println("\nFor n = 0 (Should show error):");
        printPattern1(0);
    }
}

