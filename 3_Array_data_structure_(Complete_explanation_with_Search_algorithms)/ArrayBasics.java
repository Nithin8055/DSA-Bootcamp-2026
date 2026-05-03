/**
 * ArrayBasics.java - Demonstrates basic array declaration, initialization, and memory allocation
 *
 * Key Concepts:
 * 1. Array declaration syntax
 * 2. Memory allocation in contiguous blocks
 * 3. Index-based access
 * 4. Array iteration
 *
 * Time Complexity: O(1) for access, O(n) for iteration
 * Space Complexity: O(n) where n is array size
 */

public class ArrayBasics {

    public static void main(String[] args) {
        System.out.println("=== Array Declaration and Memory Allocation ===\n");

        // Example 1: Declaring array with specified size
        System.out.println("1. Array Declaration:");
        int[] arr = new int[5];  // Creates array with 5 elements
        System.out.println("Created array of size: " + arr.length);
        System.out.println("Default value for int array: " + arr[0]);  // Default is 0
        System.out.println();

        // Example 2: Array initialization with values
        System.out.println("2. Array Initialization with Values:");
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Array: ");
        printArray(numbers);
        System.out.println();

        // Example 3: Direct access to array elements (O(1) time)
        System.out.println("3. Direct Access (O(1) - Constant Time):");
        System.out.println("Accessing arr[2]: " + numbers[2]);
        System.out.println("Accessing arr[4]: " + numbers[4]);
        System.out.println("Time taken: Same regardless of position!");
        System.out.println();

        // Example 4: Array with different data types
        System.out.println("4. Arrays with Different Data Types:");
        long[] longArr = {100L, 200L, 300L};
        double[] doubleArr = {1.5, 2.7, 3.14};
        char[] charArr = {'A', 'B', 'C'};

        System.out.println("Long array: ");
        printLongArray(longArr);

        System.out.println("Double array: ");
        printDoubleArray(doubleArr);

        System.out.println("Char array: ");
        printCharArray(charArr);
        System.out.println();

        // Example 5: Modifying array elements
        System.out.println("5. Modifying Array Elements:");
        numbers[0] = 100;
        numbers[2] = 999;
        System.out.println("After modification: ");
        printArray(numbers);
        System.out.println();

        // Example 6: 2D Array (Multidimensional)
        System.out.println("6. 2D Array (Matrix):");
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print2DArray(matrix);
        System.out.println();

        // Example 7: Array of Objects
        System.out.println("7. Array of Objects:");
        Student[] students = {
            new Student("Nithin", 101),
            new Student("Aman", 102),
            new Student("Priya", 103)
        };
        printStudentArray(students);
    }

    // Utility method: Print integer array
    public static void printArray(int[] arr) {
        System.out.print("Array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Utility method: Print long array
    public static void printLongArray(long[] arr) {
        System.out.print("Array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Utility method: Print double array
    public static void printDoubleArray(double[] arr) {
        System.out.print("Array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Utility method: Print char array
    public static void printCharArray(char[] arr) {
        System.out.print("Array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Utility method: Print 2D array
    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Row " + i + ": [");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    // Utility method: Print student array
    public static void printStudentArray(Student[] arr) {
        for (Student s : arr) {
            System.out.println("Name: " + s.name + ", ID: " + s.id);
        }
    }

    // Simple Student class for demonstration
    static class Student {
        String name;
        int id;

        Student(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }
}

