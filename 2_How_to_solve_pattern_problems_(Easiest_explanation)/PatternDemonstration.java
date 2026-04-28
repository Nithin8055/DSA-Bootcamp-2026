/**
 * PATTERN DEMONSTRATION: Main Class
 *
 * This class demonstrates all four pattern examples plus practice problems
 * and provides a comprehensive learning resource.
 *
 * All Examples at a Glance:
 * 1. Simple Number Pattern (1, 2, 3, 4...)
 * 2. Star Pattern (Square of stars)
 * 3. Number Triangle (1, 12, 123, 1234...)
 * 4. Row-Number Pattern (1, 22, 333, 4444...)
 *
 * Plus: Practice problems and advanced variations
 */

public class PatternDemonstration {

    // ================== THE THREE KEY QUESTIONS ==================
    // ALWAYS ask these three questions for ANY pattern problem:
    // 1. How many rows?
    // 2. How many columns per row?
    // 3. What to print?
    // ==============================================================

    /**
     * Demonstrates the universal pattern-solving approach
     */
    public static void printPatternApproach() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║          THE THREE KEY CONCEPTS FOR EVERY PATTERN             ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                ║");
        System.out.println("║  QUESTION 1: How many rows?                                   ║");
        System.out.println("║    → Usually equals n (the input)                             ║");
        System.out.println("║    → This controls the outer loop                             ║");
        System.out.println("║                                                                ║");
        System.out.println("║  QUESTION 2: How many columns per row?                        ║");
        System.out.println("║    → May be n (for all rows) or vary per row                  ║");
        System.out.println("║    → Can be constant or dependent on row number (i)           ║");
        System.out.println("║    → This controls the inner loop                             ║");
        System.out.println("║                                                                ║");
        System.out.println("║  QUESTION 3: What to print?                                   ║");
        System.out.println("║    → Could be: row number, column number, stars, letters     ║");
        System.out.println("║    → Could be a formula: i, j, i+j, i*j, etc.               ║");
        System.out.println("║    → This is what goes in System.out.print()                 ║");
        System.out.println("║                                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
    }

    /**
     * Practice Problem 1: Right-aligned triangle of stars
     */
    public static void practiceProblem1() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║  PRACTICE PROBLEM 1: Right-Aligned Triangle of Stars          ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        System.out.println("Expected Output for n=4:");
        System.out.println("   *");
        System.out.println("  **");
        System.out.println(" ***");
        System.out.println("****\n");

        System.out.println("Analysis:");
        System.out.println("- Rows: 4 (equal to n)");
        System.out.println("- Columns: i (Row 1 has 1 star, Row 2 has 2 stars, etc.)");
        System.out.println("- Leading spaces: (n - i) spaces before each row");
        System.out.println("- Print: '*'\n");

        System.out.println("Actual Output:");
        int n = 4;
        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int space = 1; space <= (n - i); space++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Practice Problem 2: Centered pyramid
     */
    public static void practiceProblem2() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║  PRACTICE PROBLEM 2: Centered Pyramid                         ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        System.out.println("Expected Output for n=4:");
        System.out.println("    *");
        System.out.println("   ***");
        System.out.println("  *****");
        System.out.println(" *******\n");

        System.out.println("Analysis:");
        System.out.println("- Rows: 4");
        System.out.println("- Columns: (2*i - 1) stars in row i");
        System.out.println("- Leading spaces: (n - i) spaces");
        System.out.println("- Print: '*'\n");

        System.out.println("Actual Output:");
        int n = 4;
        for (int i = 1; i <= n; i++) {
            // Leading spaces
            for (int space = 1; space <= (n - i); space++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Practice Problem 3: Diamond pattern
     */
    public static void practiceProblem3() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║  PRACTICE PROBLEM 3: Diamond Pattern                          ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        System.out.println("Expected Output for n=3:");
        System.out.println("  *");
        System.out.println(" ***");
        System.out.println("*****");
        System.out.println(" ***");
        System.out.println("  *\n");

        System.out.println("Analysis:");
        System.out.println("- Two parts: expanding (rows 1 to n) and contracting (rows n-1 to 1)");
        System.out.println("- Columns: (2*i - 1) stars");
        System.out.println("- Leading spaces: (n - i) spaces\n");

        System.out.println("Actual Output:");
        int n = 3;
        // Upper half
        for (int i = 1; i <= n; i++) {
            for (int space = 1; space <= (n - i); space++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            for (int space = 1; space <= (n - i); space++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Practice Problem 4: Number triangle (descending)
     */
    public static void practiceProblem4() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║  PRACTICE PROBLEM 4: Number Triangle (Descending)             ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        System.out.println("Expected Output for n=4:");
        System.out.println("1");
        System.out.println("21");
        System.out.println("321");
        System.out.println("4321\n");

        System.out.println("Analysis:");
        System.out.println("- Rows: 4");
        System.out.println("- Columns: i (Row i has i numbers)");
        System.out.println("- Print: Numbers from i down to 1\n");

        System.out.println("Actual Output:");
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /**
     * Practice Problem 5: Mixed pattern with symbols
     */
    public static void practiceProblem5() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║  PRACTICE PROBLEM 5: Mixed Pattern with Symbols               ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        System.out.println("Expected Output for n=4:");
        System.out.println("1 * 1");
        System.out.println("2 * 2");
        System.out.println("3 * 3");
        System.out.println("4 * 4\n");

        System.out.println("Analysis:");
        System.out.println("- Rows: 4");
        System.out.println("- Pattern: number + space + * + space + number");
        System.out.println("- All rows have the same format\n");

        System.out.println("Actual Output:");
        int n = 4;
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " * " + i);
        }
    }

    /**
     * Print tips for solving pattern problems
     */
    public static void printTipsAndTricks() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║  TIPS AND TRICKS FOR PATTERN PROBLEMS                         ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        System.out.println("✓ TIP 1: Always draw the pattern first");
        System.out.println("  Visualize the output before writing code\n");

        System.out.println("✓ TIP 2: Ask the three key questions");
        System.out.println("  Don't skip this step - it's crucial!\n");

        System.out.println("✓ TIP 3: Use variable names wisely");
        System.out.println("  i = rows (outer loop)");
        System.out.println("  j = columns (inner loop)");
        System.out.println("  n = input number\n");

        System.out.println("✓ TIP 4: Place newline after inner loop");
        System.out.println("  System.out.println() goes after the inner loop ends\n");

        System.out.println("✓ TIP 5: Test with multiple values");
        System.out.println("  Test with n = 1, 3, 4, 5 to verify correctness\n");

        System.out.println("✓ TIP 6: Break complex patterns into parts");
        System.out.println("  Leading spaces + pattern + trailing spaces\n");

        System.out.println("✓ TIP 7: Use temporary variables for complex formulas");
        System.out.println("  Makes code more readable\n");

        System.out.println("✓ TIP 8: Add input validation");
        System.out.println("  Check if n > 0 before processing\n");
    }

    /**
     * Print common mistakes to avoid
     */
    public static void printCommonMistakes() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║  COMMON MISTAKES TO AVOID                                     ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        System.out.println("❌ MISTAKE 1: Forgetting newline after inner loop");
        System.out.println("   Result: Everything prints on one line\n");

        System.out.println("❌ MISTAKE 2: Using n in inner loop when you need i");
        System.out.println("   Result: All rows have same number of elements\n");

        System.out.println("❌ MISTAKE 3: Starting loop from 0 instead of 1");
        System.out.println("   Result: Off-by-one errors\n");

        System.out.println("❌ MISTAKE 4: Printing before inner loop completes");
        System.out.println("   Result: Incorrect pattern output\n");

        System.out.println("❌ MISTAKE 5: Not handling spaces correctly");
        System.out.println("   Result: Alignment issues\n");

        System.out.println("❌ MISTAKE 6: Using print() instead of println()");
        System.out.println("   Result: No line breaks between rows\n");
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                  PATTERN PROBLEMS - COMPLETE GUIDE             ║");
        System.out.println("║            Learn to solve ANY pattern problem efficiently     ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

        // Print the approach
        printPatternApproach();

        // Practice problems
        practiceProblem1();
        practiceProblem2();
        practiceProblem3();
        practiceProblem4();
        practiceProblem5();

        // Tips and tricks
        printTipsAndTricks();

        // Common mistakes
        printCommonMistakes();

        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              Run Individual Files for More Examples            ║");
        System.out.println("║                                                                ║");
        System.out.println("║  - PatternExample1.java   (Simple Number Pattern)             ║");
        System.out.println("║  - PatternExample2.java   (Star Pattern)                      ║");
        System.out.println("║  - PatternExample3.java   (Number Triangle)                   ║");
        System.out.println("║  - PatternExample4.java   (Row-Number Pattern)                ║");
        System.out.println("║                                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
    }
}

