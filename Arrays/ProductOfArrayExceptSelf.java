public class ProductOfArrayExceptSelf {
    /**
     * Returns an array where result[i] is the product of all elements except numbers[i].
     * Time: O(n), extra space: O(1) excluding the returned array.
     */
    public static int[] productExceptSelf(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int[] result = new int[numbers.length];
        result[0] = 1;

        // Store the product of every element to the left of each index.
        for (int index = 1; index < numbers.length; index++) {
            result[index] = result[index - 1] * numbers[index - 1];
        }

        // Multiply by the product of every element to the right of each index.
        int rightProduct = 1;
        for (int index = numbers.length - 2; index >= 0; index--) {
            result[index] *= rightProduct * numbers[index + 1];
            rightProduct *= numbers[index + 1];
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
