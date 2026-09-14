public class ProductOfArrayExceptSelf2 {
    /**
     * Returns an array where result[i] is the product of all elements except numbers[i].
     * Time: O(n), extra space: O(1) excluding the returned array.
     */
    public static int[] productExceptSelf(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        
        int[] leftProducts = new int[numbers.length];
        int[] rightProducts = new int[numbers.length];
        int[] result = new int[numbers.length];
        result[0] = 1;
        leftProducts[0] = 1;
        rightProducts[numbers.length - 1] = 1;

        // Store the product of every element to the left of each index.
        for (int index = 1; index < numbers.length; index++) {
            leftProducts[index] = leftProducts[index - 1] * numbers[index - 1];
        }

        // Store the product of every element to the right of each index.
        for (int index = numbers.length - 2; index >= 0; index--) {
            rightProducts[index] = rightProducts[index + 1] * numbers[index + 1];
        }

        // Calculate the final result by multiplying left and right products.
        for (int index = 0; index < numbers.length; index++) {
            result[index] = leftProducts[index] * rightProducts[index];                 
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int[] products = productExceptSelf(numbers);

        for (int product : products) {
            System.out.print(product + " ");
        }
    }
}
