/**
 * EXAMPLE 2: Star Pattern (Square)
 *
 * Problem Statement:
 * Print a square grid of stars with n rows and n columns
 *
 * Pattern Analysis:
 * - How Many Rows? → n rows (equal to input)
 * - How Many Columns? → n columns per row (each row has n stars)
 * - What to Print? → Stars (*) at every position
 *
 * Example Output for n = 4:
 * ****
 * ****
 * ****
 * ****
 *
 * This is a basic 2D pattern using nested loops
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */

public class PatternExample2 {

    /**
     * Prints a square pattern of stars
     * Demonstrates nested loops concept
     *
     * @param n the size of the square (n x n)
     */
    public static void printPattern2(int n) {
        // Validate input
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        // Outer loop for ROWS
        // This controls how many rows (horizontal lines) to print
        for (int i = 1; i <= n; i++) {

            // Inner loop for COLUMNS
            // This controls how many stars in each row
            for (int j = 1; j <= n; j++) {
                // Print a star without moving to next line
                System.out.print("*");
            }

            // After completing one entire row, move to the next line
            System.out.println();
        }
    }

    /**
     * Alternative version using spaces for visualization
     * Helps understand the nested loop structure better
     *
     * @param n the size of the square
     */
    public static void printPattern2WithSpaces(int n) {
        System.out.println("\n--- WITH SPACES FOR CLARITY ---");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * Version that shows row and column numbers
     * Useful for understanding nested loops
     *
     * @param n the size of the pattern
     */
    public static void printPattern2WithIndices(int n) {
        System.out.println("\n--- WITH ROW AND COLUMN INDICES ---");

        for (int i = 1; i <= n; i++) {
            System.out.print("Row " + i + ": ");
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Rectangle pattern (not square)
     * Demonstrates flexibility of the approach
     *
     * @param rows number of rows
     * @param cols number of columns
     */
    public static void printRectangle(int rows, int cols) {
        System.out.println("\n--- RECTANGLE PATTERN (" + rows + "x" + cols + ") ---");

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Main method to demonstrate the pattern
     */
    public static void main(String[] args) {
        System.out.println("=== PATTERN EXAMPLE 2: Star Pattern (Square) ===\n");

        // Basic square patterns
        System.out.println("For n = 4:");
        printPattern2(4);

        System.out.println("\nFor n = 3:");
        printPattern2(3);

        // With spaces for clarity
        System.out.println("\nFor n = 4 (With Spaces):");
        printPattern2WithSpaces(4);

        // With indices
        System.out.println("For n = 3 (With Indices):");
        printPattern2WithIndices(3);

        // Rectangle variations
        System.out.println("\n--- RECTANGLE VARIATIONS ---");
        printRectangle(3, 5);  // 3 rows, 5 columns

        printRectangle(5, 3);  // 5 rows, 3 columns

        // Edge cases
        System.out.println("\n--- EDGE CASES ---");
        System.out.println("\nFor n = 1:");
        printPattern2(1);

        System.out.println("\nFor n = 0 (Should show error):");
        printPattern2(0);
    }
}

