/**
 * EXAMPLE 4: Row-Number Pattern
 *
 * Problem Statement:
 * Print the row number repeated as many times as the row number
 *
 * Pattern Analysis:
 * - How Many Rows? → n rows
 * - How Many Columns? → Row number i columns in row i
 * - What to Print? → The row number i (repeated i times)
 *
 * Example Output for n = 4:
 * 1
 * 22
 * 333
 * 4444
 *
 * Key Difference from Example 3:
 * In Example 3, we print different numbers (1, 2, 3...)
 * In Example 4, we print the SAME number 'i' multiple times
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */

public class PatternExample4 {

    /**
     * Prints a pattern where row number i is repeated i times
     *
     * Key Concept:
     * The value printed is always the ROW NUMBER (i)
     * The inner loop controls HOW MANY TIMES to print it
     *
     * @param n the number of rows
     */
    public static void printPattern4(int n) {
        // Validate input
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        // Outer loop for ROWS
        for (int i = 1; i <= n; i++) {

            // Inner loop for COLUMNS
            // Runs 'i' times (same as Example 3)
            for (int j = 1; j <= i; j++) {
                // But we print ROW NUMBER (i), not column number (j)
                // This is the KEY DIFFERENCE!
                System.out.print(i);
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
    public static void printPattern4WithSpaces(int n) {
        System.out.println("\n--- WITH SPACES ---");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /**
     * Version that shows what's being printed
     *
     * @param n the number of rows
     */
    public static void printPattern4Verbose(int n) {
        System.out.println("\n--- VERBOSE VERSION ---");

        for (int i = 1; i <= n; i++) {
            System.out.print("Row " + i + ": Print '" + i + "' " + i + " times: ");
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * Variation: Using different symbols (letters)
     * Letter at position i is repeated i times
     *
     * @param n the number of rows
     */
    public static void printPattern4WithLetters(int n) {
        System.out.println("\n--- WITH LETTERS ---");

        for (int i = 1; i <= n; i++) {
            // Convert row number to letter
            char letter = (char)('A' + i - 1);

            for (int j = 1; j <= i; j++) {
                System.out.print(letter);
            }
            System.out.println();
        }
    }

    /**
     * Variation: Using asterisks
     *
     * @param n the number of rows
     */
    public static void printPattern4WithStars(int n) {
        System.out.println("\n--- WITH STARS ---");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Variation: Left-aligned triangle
     *
     * @param n the number of rows
     */
    public static void printPattern4Triangle(int n) {
        System.out.println("\n--- TRIANGLE PATTERN ---");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * Variation: Right-aligned triangle (with leading spaces)
     *
     * @param n the number of rows
     */
    public static void printPattern4RightAligned(int n) {
        System.out.println("\n--- RIGHT-ALIGNED TRIANGLE ---");

        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int space = 1; space <= (n - i); space++) {
                System.out.print(" ");
            }

            // Print the row number i times
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * Variation: Pattern that increases and then decreases
     *
     * @param n the number of rows
     */
    public static void printPattern4Diamond(int n) {
        System.out.println("\n--- DIAMOND PATTERN ---");

        // First half: increasing
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }

        // Second half: decreasing
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * Comparison: What's different from Example 3?
     */
    public static void printComparison() {
        System.out.println("\n=== COMPARISON: Example 3 vs Example 4 ===\n");

        System.out.println("EXAMPLE 3 (Different numbers each row):");
        System.out.println("1");
        System.out.println("12");
        System.out.println("123");
        System.out.println("1234");
        System.out.println("→ Prints COLUMN NUMBER at each position");

        System.out.println("\nEXAMPLE 4 (Same number repeated):");
        System.out.println("1");
        System.out.println("22");
        System.out.println("333");
        System.out.println("4444");
        System.out.println("→ Prints ROW NUMBER at each position");

        System.out.println("\nKEY INSIGHT:");
        System.out.println("Both use the same loop structure: for(j=1; j<=i; j++)");
        System.out.println("But WHAT IS PRINTED is different:");
        System.out.println("- Example 3: System.out.print(j)  ← column number");
        System.out.println("- Example 4: System.out.print(i)  ← row number");
    }

    /**
     * Main method to demonstrate the pattern
     */
    public static void main(String[] args) {
        System.out.println("=== PATTERN EXAMPLE 4: Row-Number Pattern ===\n");

        // Basic pattern
        System.out.println("For n = 4:");
        printPattern4(4);

        System.out.println("\nFor n = 3:");
        printPattern4(3);

        // With spaces
        System.out.println("For n = 4 (With Spaces):");
        printPattern4WithSpaces(4);

        // Verbose version
        System.out.println("For n = 3 (Verbose):");
        printPattern4Verbose(3);

        // With letters
        System.out.println("For n = 4 (With Letters):");
        printPattern4WithLetters(4);

        // With stars
        System.out.println("For n = 4 (With Stars):");
        printPattern4WithStars(4);

        // Right-aligned
        System.out.println("For n = 4 (Right-Aligned):");
        printPattern4RightAligned(4);

        // Diamond pattern
        System.out.println("For n = 4 (Diamond):");
        printPattern4Diamond(4);

        // Comparison with Example 3
        printComparison();

        // Edge cases
        System.out.println("\n--- EDGE CASES ---");
        System.out.println("\nFor n = 1:");
        printPattern4(1);

        System.out.println("\nFor n = 0 (Should show error):");
        printPattern4(0);
    }
}

