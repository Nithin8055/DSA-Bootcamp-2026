/**
 * ArrayAdvantagesDisadvantages.java - Demonstrates array strengths and weaknesses
 *
 * Covers:
 * 1. Random Access (Advantage) - O(1) time
 * 2. Cache Locality (Advantage) - Better CPU cache utilization
 * 3. Fixed Size Problem (Disadvantage) - Cannot grow dynamically
 * 4. Insertion/Deletion Performance (Disadvantage) - O(n) time
 *
 * Time Complexity Analysis:
 * - Access: O(1)
 * - Search (unsorted): O(n)
 * - Search (sorted with binary): O(log n)
 * - Insertion: O(n)
 * - Deletion: O(n)
 */

public class ArrayAdvantagesDisadvantages {

    public static void main(String[] args) {
        System.out.println("=== ARRAY ADVANTAGES AND DISADVANTAGES ===\n");

        // ============ ADVANTAGES ============
        System.out.println("========== ADVANTAGES ==========\n");

        demonstrateRandomAccess();
        System.out.println("\n" + new String(new char[50]).replace('\0', '=') + "\n");

        demonstrateCacheLocality();
        System.out.println("\n" + new String(new char[50]).replace('\0', '=') + "\n");

        // ============ DISADVANTAGES ============
        System.out.println("\n========== DISADVANTAGES ==========\n");

        demonstrateFixedSizeProblem();
        System.out.println("\n" + new String(new char[50]).replace('\0', '=') + "\n");

        demonstrateInsertionDeleteionCost();
        System.out.println("\n" + new String(new char[50]).replace('\0', '=') + "\n");

        // ============ PERFORMANCE COMPARISON ============
        System.out.println("\n========== PERFORMANCE COMPARISON ==========\n");
        performanceComparison();
    }

    /**
     * ADVANTAGE 1: Random Access - O(1) Time Complexity
     *
     * Unlike linked lists where you must traverse sequentially,
     * arrays allow direct access to any element using its index.
     *
     * Formula: Address = BaseAddress + (index × sizeOfDataType)
     */
    public static void demonstrateRandomAccess() {
        System.out.println("ADVANTAGE 1: Random Access - O(1)\n");
        System.out.println("Array supports instant access to any element!");
        System.out.println("Memory addressing formula:");
        System.out.println("  Address = BaseAddress + (index × sizeOfDataType)\n");

        int[] arr = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

        System.out.println("Array: " + arrayToString(arr));
        System.out.println("Array size: " + arr.length);
        System.out.println("Data type: int (4 bytes)\n");

        System.out.println("Access performance (all take same time):");

        // Access different positions
        int[] positions = {0, 5, 9};
        for (int pos : positions) {
            long start = System.nanoTime();
            int value = arr[pos];
            long end = System.nanoTime();
            long timeNanos = end - start;

            System.out.printf("arr[%d] = %d → Time: %d ns%n", pos, value, timeNanos);
        }

        System.out.println("\n✓ Whether accessing first, middle, or last element,");
        System.out.println("  time is always constant - O(1)!");
        System.out.println("\nComparison with Linked List:");
        System.out.println("  Linked List: Need to traverse from start → O(n) worst case!");
    }

    /**
     * ADVANTAGE 2: Cache Locality
     *
     * Arrays store elements in contiguous memory.
     * When CPU fetches one element, neighboring elements are also
     * loaded into cache, making subsequent access much faster.
     *
     * This is spatial locality - huge performance benefit!
     */
    public static void demonstrateCacheLocality() {
        System.out.println("ADVANTAGE 2: Cache Locality\n");
        System.out.println("Array elements stored in continuous memory blocks:");
        System.out.println("+----+----+----+----+----+----+----+----+");
        System.out.println("| 10 | 20 | 30 | 40 | 50 | 60 | 70 | 80 |");
        System.out.println("+----+----+----+----+----+----+----+----+");
        System.out.println(" 1000 1004 1008 1012 1016 1020 1024 1028 (Memory addresses)\n");

        System.out.println("CPU Cache Behavior:");
        System.out.println("1. When accessing arr[0], CPU loads it into L1 cache");
        System.out.println("2. Neighboring elements arr[1], arr[2], etc. are also loaded");
        System.out.println("3. Next access to arr[1] finds it in FAST cache!");
        System.out.println("4. Eliminates main memory access (very slow)\n");

        // Demonstrate cache hit vs miss
        System.out.println("Performance Impact:\n");

        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // Sequential access (cache-friendly)
        long start1 = System.nanoTime();
        long sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
        }
        long time1 = System.nanoTime() - start1;

        // Random access (cache-unfriendly)
        long start2 = System.nanoTime();
        long sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum2 += arr[(i * 13579) % arr.length];  // Random indices
        }
        long time2 = System.nanoTime() - start2;

        System.out.printf("Sequential access (cache-friendly): %,d ns%n", time1);
        System.out.printf("Random access (cache-unfriendly):   %,d ns%n", time2);
        System.out.printf("Speedup: %.2fx faster with sequential access!%n", (double) time2 / time1);

        System.out.println("\n✓ This spatial locality is why arrays are so fast!");
    }

    /**
     * DISADVANTAGE 1: Fixed Size
     *
     * Array size is determined at creation and cannot be changed.
     * If you need more space, you must create a new, larger array.
     */
    public static void demonstrateFixedSizeProblem() {
        System.out.println("DISADVANTAGE 1: Fixed Size Problem\n");

        System.out.println("Create array of size 3:");
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println("Array: " + arrayToString(arr) + " (size: 3)");
        System.out.println("Used capacity: 3/3\n");

        System.out.println("Problem: Need to add a 4th element!");
        System.out.println("ERROR: arr[3] = 4;  // ArrayIndexOutOfBoundsException\n");

        System.out.println("Solution: Create new larger array");
        int[] newArr = new int[6];  // Double the size
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[3] = 4;

        System.out.println("After resizing: " + arrayToString(newArr) + " (size: 6)");
        System.out.println("Used capacity: 4/6\n");

        System.out.println("Consequences:");
        System.out.println("1. Need to allocate new memory");
        System.out.println("2. Copy all old elements (O(n) operation)");
        System.out.println("3. Old array becomes garbage");
        System.out.println("4. Memory wastage: 2 unused slots (33% waste!)");
        System.out.println("5. For very large arrays, this is expensive!\n");

        System.out.println("Why Arrays Don't Support Growth:");
        System.out.println("  Array size is fixed at declaration: int[] arr = new int[10];");
        System.out.println("  This allows direct memory address calculation");
        System.out.println("  Dynamic growth would complicate memory management");
        System.out.println("  Solution: Use ArrayList or Vector for dynamic behavior");
    }

    /**
     * DISADVANTAGE 2: Expensive Insertion and Deletion
     *
     * Adding or removing elements requires shifting all subsequent elements.
     * This makes insertion/deletion O(n) operations.
     */
    public static void demonstrateInsertionDeleteionCost() {
        System.out.println("DISADVANTAGE 2: Expensive Insertion/Deletion - O(n)\n");

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original: " + arrayToString(arr));
        System.out.println("Goal: Insert 99 at index 1\n");

        System.out.println("Process (showing all shifts):");
        System.out.println("Step 1: [1, 2, 3, 4, 5] → [1, 2, 2, 4, 5]  (shift element at 2)");
        System.out.println("Step 2: [1, 2, 2, 4, 5] → [1, 2, 2, 4, 4]  (shift element at 3)");
        System.out.println("Step 3: [1, 2, 2, 4, 4] → [1, 2, 2, 4, 5]  (shift element at 4)");
        System.out.println("Step 4: [1, 2, 2, 4, 5] → [1, 99, 2, 4, 5] (insert 99)\n");

        System.out.println("Cost Analysis:");
        System.out.println("- Array size n = 5");
        System.out.println("- Insertion position = 1");
        System.out.println("- Elements to shift = 5 - 1 = 4");
        System.out.println("- Time Complexity = O(n-1) ≈ O(n)\n");

        // Demonstrate for different positions
        System.out.println("Insertion cost varies by position:\n");
        System.out.println("Position | Elements to shift | Relative Cost");
        System.out.println("---------|-------------------|-------------");
        for (int pos = 0; pos <= arr.length; pos++) {
            int shifts = arr.length - pos;
            double percentage = (shifts * 100.0) / arr.length;
            System.out.printf("   %d    |        %d         | %.0f%%\n", pos, shifts, percentage);
        }

        System.out.println("\nWorst case: Insert at beginning");
        System.out.println("  Must shift ALL n elements!");
        System.out.println("\nConclusion:");
        System.out.println("  Insertion/Deletion anywhere in array is O(n) operation");
        System.out.println("  Not suitable for frequent add/remove operations");
        System.out.println("  Use LinkedList for frequent insertions/deletions");
    }

    /**
     * Performance comparison between different operations
     */
    public static void performanceComparison() {
        System.out.println("OPERATION PERFORMANCE SUMMARY\n");
        System.out.println("Operation        | Time Complexity | Best Use Case");
        System.out.println("-----------------|-----------------|-------------------------------------");
        System.out.println("Random Access    | O(1)            | Instant access by index");
        System.out.println("Sequential Access| O(n)            | Iteration, streaming");
        System.out.println("Linear Search    | O(n)            | Unsorted data");
        System.out.println("Binary Search    | O(log n)        | Sorted data, faster search");
        System.out.println("Insertion        | O(n)            | Avoid if frequent!");
        System.out.println("Deletion         | O(n)            | Avoid if frequent!");
        System.out.println("Modification     | O(1)            | Change existing element");

        System.out.println("\n\nWhen to Use Arrays:");
        System.out.println("✓ Need fast random access");
        System.out.println("✓ Size is known and fixed");
        System.out.println("✓ Cache performance matters");
        System.out.println("✓ Memory efficiency is important");
        System.out.println("✓ Sequential iteration is common");

        System.out.println("\nWhen NOT to Use Arrays:");
        System.out.println("✗ Frequent insertions/deletions");
        System.out.println("✗ Size varies significantly");
        System.out.println("✗ Need dynamic growth");
        System.out.println("✗ Need O(1) insertion at beginning");
    }

    // Utility method
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

