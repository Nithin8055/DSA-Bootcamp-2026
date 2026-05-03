/**
 * ArrayInsertionDeletion.java - Demonstrates array insertion and deletion operations
 *
 * Key Concepts:
 * 1. Array has FIXED SIZE - cannot be changed after creation
 * 2. To add/remove elements, must create new array
 * 3. All existing elements must be shifted
 *
 * Operations covered:
 * - Insertion at end
 * - Insertion at beginning
 * - Insertion at specific position
 * - Deletion from end
 * - Deletion from beginning
 * - Deletion from specific position
 *
 * Time Complexity:
 * - Insertion/Deletion at end: O(n) - due to array copying
 * - Insertion/Deletion at beginning: O(n) - all elements shift
 * - Insertion/Deletion at middle: O(n) - remaining elements shift
 *
 * Space Complexity: O(n) - new array of larger/smaller size
 */

public class ArrayInsertionDeletion {

    public static void main(String[] args) {
        System.out.println("=== ARRAY INSERTION AND DELETION ===\n");

        // ============ INSERTION OPERATIONS ============
        System.out.println("========== INSERTION OPERATIONS ==========\n");

        // Test Case 1: Insert at end
        System.out.println("1. INSERT AT END");
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + arrayToString(arr1));
        int[] newArr1 = insertAtEnd(arr1, 6);
        System.out.println("After inserting 6 at end: " + arrayToString(newArr1));
        System.out.println("Time Complexity: O(n) - need to copy all elements\n");

        // Test Case 2: Insert at beginning
        System.out.println("2. INSERT AT BEGINNING");
        int[] arr2 = {2, 3, 4, 5};
        System.out.println("Original array: " + arrayToString(arr2));
        int[] newArr2 = insertAtBeginning(arr2, 1);
        System.out.println("After inserting 1 at beginning: " + arrayToString(newArr2));
        System.out.println("Time Complexity: O(n) - all elements must shift right\n");

        // Test Case 3: Insert at specific position
        System.out.println("3. INSERT AT SPECIFIC POSITION");
        int[] arr3 = {1, 2, 3, 5};
        System.out.println("Original array: " + arrayToString(arr3));
        int[] newArr3 = insertAtPosition(arr3, 2, 4);
        System.out.println("After inserting 4 at index 2: " + arrayToString(newArr3));
        System.out.println("Elements after insertion point shift right\n");
        System.out.println("Time Complexity: O(n)\n");

        // Detailed insertion demo
        System.out.println("4. DETAILED INSERTION EXAMPLE");
        insertionDemo();
        System.out.println();

        // ============ DELETION OPERATIONS ============
        System.out.println("\n========== DELETION OPERATIONS ==========\n");

        // Test Case 4: Delete from end
        System.out.println("1. DELETE FROM END");
        int[] arr4 = {10, 20, 30, 40, 50};
        System.out.println("Original array: " + arrayToString(arr4));
        int[] newArr4 = deleteFromEnd(arr4);
        System.out.println("After deleting from end: " + arrayToString(newArr4));
        System.out.println("Time Complexity: O(n) - need to copy remaining elements\n");

        // Test Case 5: Delete from beginning
        System.out.println("2. DELETE FROM BEGINNING");
        int[] arr5 = {10, 20, 30, 40, 50};
        System.out.println("Original array: " + arrayToString(arr5));
        int[] newArr5 = deleteFromBeginning(arr5);
        System.out.println("After deleting from beginning: " + arrayToString(newArr5));
        System.out.println("Time Complexity: O(n) - all elements shift left\n");

        // Test Case 6: Delete from specific position
        System.out.println("3. DELETE FROM SPECIFIC POSITION");
        int[] arr6 = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + arrayToString(arr6));
        int[] newArr6 = deleteAtPosition(arr6, 2);
        System.out.println("After deleting element at index 2: " + arrayToString(newArr6));
        System.out.println("Remaining elements shift left\n");
        System.out.println("Time Complexity: O(n)\n");

        // Detailed deletion demo
        System.out.println("4. DETAILED DELETION EXAMPLE");
        deletionDemo();
        System.out.println();

        // ============ PRACTICAL EXAMPLE ============
        System.out.println("\n========== PRACTICAL EXAMPLE ==========\n");
        System.out.println("Using Dynamic Array Pattern (simulate ArrayList):");
        dynamicArrayDemo();
    }

    /**
     * Insert element at the end of array
     *
     * Process:
     * 1. Create new array of size n+1
     * 2. Copy all elements from old array
     * 3. Add new element at last position
     * 4. Return new array
     */
    public static int[] insertAtEnd(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];

        // Copy existing elements
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        // Insert new element at end
        newArr[arr.length] = element;

        return newArr;
    }

    /**
     * Insert element at the beginning of array
     *
     * Process:
     * 1. Create new array of size n+1
     * 2. Place new element at index 0
     * 3. Shift all old elements to the right
     * 4. Return new array
     */
    public static int[] insertAtBeginning(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];

        // Insert new element at beginning
        newArr[0] = element;

        // Shift all existing elements to right
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    /**
     * Insert element at specific position
     *
     * @param arr Original array
     * @param position Index where to insert (0-based)
     * @param element Value to insert
     * @return New array with element inserted
     *
     * Process:
     * 1. Create new array of size n+1
     * 2. Copy elements before insertion point
     * 3. Insert new element at position
     * 4. Copy remaining elements (shifted right)
     * 5. Return new array
     */
    public static int[] insertAtPosition(int[] arr, int position, int element) {
        // Validate position
        if (position < 0 || position > arr.length) {
            System.out.println("Invalid position!");
            return arr;
        }

        int[] newArr = new int[arr.length + 1];

        // Copy elements before insertion point
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }

        // Insert new element
        newArr[position] = element;

        // Copy remaining elements (shifted by 1)
        for (int i = position; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    /**
     * Delete element from end of array
     *
     * Process:
     * 1. Create new array of size n-1
     * 2. Copy all elements except last
     * 3. Return new array
     */
    public static int[] deleteFromEnd(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Cannot delete from empty array!");
            return arr;
        }

        int[] newArr = new int[arr.length - 1];

        // Copy all elements except last
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    /**
     * Delete element from beginning of array
     *
     * Process:
     * 1. Create new array of size n-1
     * 2. Copy all elements except first (shifted left)
     * 3. Return new array
     */
    public static int[] deleteFromBeginning(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Cannot delete from empty array!");
            return arr;
        }

        int[] newArr = new int[arr.length - 1];

        // Copy all elements except first (shift left)
        for (int i = 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }

        return newArr;
    }

    /**
     * Delete element at specific position
     *
     * @param arr Original array
     * @param position Index to delete (0-based)
     * @return New array with element removed
     *
     * Process:
     * 1. Create new array of size n-1
     * 2. Copy elements before deletion point
     * 3. Copy remaining elements (shifted left)
     * 4. Return new array
     */
    public static int[] deleteAtPosition(int[] arr, int position) {
        // Validate position
        if (position < 0 || position >= arr.length) {
            System.out.println("Invalid position!");
            return arr;
        }

        int[] newArr = new int[arr.length - 1];

        // Copy elements before deletion point
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }

        // Copy remaining elements (shifted left by 1)
        for (int i = position + 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }

        return newArr;
    }

    /**
     * Detailed insertion demonstration
     */
    public static void insertionDemo() {
        int[] original = {10, 20, 30, 40};
        System.out.println("Original array: " + arrayToString(original));
        System.out.println("Goal: Insert 25 at index 2\n");

        System.out.println("Step 1: Create new array of size " + (original.length + 1));
        int[] newArr = new int[original.length + 1];
        System.out.println("New array (empty): " + arrayToString(newArr) + "\n");

        System.out.println("Step 2: Copy elements before position 2");
        for (int i = 0; i < 2; i++) {
            newArr[i] = original[i];
        }
        System.out.println("After copying: " + arrayToString(newArr));
        System.out.println("Copied indices 0-1: [10, 20]\n");

        System.out.println("Step 3: Insert 25 at index 2");
        newArr[2] = 25;
        System.out.println("After inserting: " + arrayToString(newArr) + "\n");

        System.out.println("Step 4: Copy remaining elements (shifted right)");
        for (int i = 2; i < original.length; i++) {
            newArr[i + 1] = original[i];
        }
        System.out.println("Final array: " + arrayToString(newArr));
        System.out.println("Remaining elements [30, 40] shifted to indices 3-4");
    }

    /**
     * Detailed deletion demonstration
     */
    public static void deletionDemo() {
        int[] original = {10, 20, 30, 40, 50};
        System.out.println("Original array: " + arrayToString(original));
        System.out.println("Goal: Delete element at index 2 (value 30)\n");

        System.out.println("Step 1: Create new array of size " + (original.length - 1));
        int[] newArr = new int[original.length - 1];
        System.out.println("New array (empty): " + arrayToString(newArr) + "\n");

        System.out.println("Step 2: Copy elements before index 2");
        for (int i = 0; i < 2; i++) {
            newArr[i] = original[i];
        }
        System.out.println("After copying: " + arrayToString(newArr));
        System.out.println("Copied indices 0-1: [10, 20]\n");

        System.out.println("Step 3: Copy remaining elements (shifted left)");
        for (int i = 3; i < original.length; i++) {
            newArr[i - 1] = original[i];
        }
        System.out.println("Final array: " + arrayToString(newArr));
        System.out.println("Elements after index 2 [40, 50] shifted to indices 2-3");
    }

    /**
     * Simulate dynamic array behavior
     */
    public static void dynamicArrayDemo() {
        System.out.println("\nSimulating Dynamic Array Operations:\n");

        int[] arr = {};  // Start with empty
        System.out.println("Initial: " + arrayToString(arr) + " (size: " + arr.length + ")");

        // Add elements
        arr = insertAtEnd(arr, 1);
        System.out.println("Add 1: " + arrayToString(arr) + " (size: " + arr.length + ")");

        arr = insertAtEnd(arr, 2);
        System.out.println("Add 2: " + arrayToString(arr) + " (size: " + arr.length + ")");

        arr = insertAtEnd(arr, 3);
        System.out.println("Add 3: " + arrayToString(arr) + " (size: " + arr.length + ")");

        arr = insertAtBeginning(arr, 0);
        System.out.println("Add 0 at beginning: " + arrayToString(arr) + " (size: " + arr.length + ")");

        arr = deleteFromEnd(arr);
        System.out.println("Remove from end: " + arrayToString(arr) + " (size: " + arr.length + ")");
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

