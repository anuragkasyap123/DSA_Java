public class RotateAnArray_K_times {
    /**
     * Rotates the given array to the right by k steps.
     * Time: O(n), extra space: O(1) excluding the returned array.
     */
    public static void process(int[] numbers, int k) {
        int n = numbers.length;
        if (numbers == null || n == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        
        k = k % n; // Handle cases where k is greater than the length of the array
        if(k < 0) {
            k += n; // Handle negative rotations
        }
        
        ReverseAnArray.process(numbers, 0, n - 1); // Reverse the entire array
        ReverseAnArray.process(numbers, 0, k - 1); // Reverse the first k elements
        ReverseAnArray.process(numbers, k, n - 1); // Reverse the remaining elements
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        process(numbers, 2); // Assuming you want to rotate the array 2 times

        for (int ele : numbers) {
            System.out.print(ele + " ");
        }
    }
}
