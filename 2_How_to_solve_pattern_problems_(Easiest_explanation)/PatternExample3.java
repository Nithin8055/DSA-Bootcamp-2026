/**
 * EXAMPLE 3: Number Pattern with Formatting (Triangle)
 *
 * Problem Statement:
 * Print numbers increasing from 1 to column number in each row
 * Creates a triangular pattern
 *
 * Pattern Analysis:
 * - How Many Rows? → n rows (equal to input)
 * - How Many Columns? → Row number i columns in row i
 *   (Row 1 has 1 column, Row 2 has 2 columns, Row 3 has 3 columns, etc.)
 * - What to Print? → The column number (j) at each position
 *
 * Example Output for n = 4:
 * 1
 * 12
 * 123
 * 1234
 *
 * This demonstrates variable column counts per row
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */

public class PatternExample3 {

    /**
     * Prints a number triangle where each row has numbers from 1 to i
     *
     * Key Insight:
     * The inner loop runs 'i' times (not 'n' times)
     * This is the crucial difference from Example 2
     *
     * @param n the number of rows
     */
    public static void printPattern3(int n) {
        // Validate input
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        // Outer loop for ROWS
        for (int i = 1; i <= n; i++) {

            // Inner loop for COLUMNS
            // IMPORTANT: Loop runs 'i' times, NOT 'n' times!
            // Row 1: runs 1 time
            // Row 2: runs 2 times
            // Row 3: runs 3 times
            // etc.
            for (int j = 1; j <= i; j++) {
                // Print the column number
                System.out.print(j);
            }

            // Newline after each row
            System.out.println();
        }
    }

    /**
     * Version with spaces for better visibility
     *
     * @param n the number of rows
     */
    public static void printPattern3WithSpaces(int n) {
        System.out.println("\n--- WITH SPACES FOR CLARITY ---");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    /**
     * Version that shows detailed information about each row
     * Useful for understanding the logic
     *
     * @param n the number of rows
     */
    public static void printPattern3Verbose(int n) {
        System.out.println("\n--- VERBOSE VERSION ---");

        for (int i = 1; i <= n; i++) {
            System.out.print("Row " + i + " has " + i + " elements: ");
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /**
     * Variation: Reverse numbers (n to 1)
     * Each row has numbers from n down to (n-i+1)
     *
     * @param n the number of rows
     */
    public static void printPattern3Reverse(int n) {
        System.out.println("\n--- REVERSE NUMBERS ---");

        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /**
     * Variation: Using letters instead of numbers
     *
     * @param n the number of rows
     */
    public static void printPattern3WithLetters(int n) {
        System.out.println("\n--- WITH LETTERS ---");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // Convert number to letter (1→A, 2→B, etc.)
                System.out.print((char)('A' + j - 1));
            }
            System.out.println();
        }
    }

    /**
     * Variation: Pyramid alignment (centered)
     *
     * @param n the number of rows
     */
    public static void printPattern3Centered(int n) {
        System.out.println("\n--- CENTERED PYRAMID ---");

        for (int i = 1; i <= n; i++) {
            // Print leading spaces for centering
            for (int space = 1; space <= (n - i); space++) {
                System.out.print(" ");
            }

            // Print the numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /**
     * Main method to demonstrate the pattern
     */
    public static void main(String[] args) {
        System.out.println("=== PATTERN EXAMPLE 3: Number Triangle Pattern ===\n");

        // Basic triangle pattern
        System.out.println("For n = 4:");
        printPattern3(4);

        System.out.println("\nFor n = 5:");
        printPattern3(5);

        // With spaces
        System.out.println("For n = 4 (With Spaces):");
        printPattern3WithSpaces(4);

        // Verbose version
        System.out.println("For n = 3 (Verbose):");
        printPattern3Verbose(3);

        // Reverse numbers
        System.out.println("For n = 4 (Reverse Numbers):");
        printPattern3Reverse(4);

        // With letters
        System.out.println("For n = 4 (With Letters):");
        printPattern3WithLetters(4);

        // Centered pyramid
        System.out.println("For n = 5 (Centered Pyramid):");
        printPattern3Centered(5);

        // Edge cases
        System.out.println("\n--- EDGE CASES ---");
        System.out.println("\nFor n = 1:");
        printPattern3(1);

        System.out.println("\nFor n = 0 (Should show error):");
        printPattern3(0);

        // Comparison note
        System.out.println("\n--- KEY INSIGHT ---");
        System.out.println("Notice: The inner loop runs 'i' times, NOT 'n' times");
        System.out.println("Row 1: 1 element");
        System.out.println("Row 2: 2 elements");
        System.out.println("Row 3: 3 elements");
        System.out.println("This creates a TRIANGLE, not a SQUARE!");
    }
}

