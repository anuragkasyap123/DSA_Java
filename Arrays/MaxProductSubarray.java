public class MaxProductSubarray {
    public static int maxProduct(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int currentMaximum = numbers[0];
        int currentMinimum = numbers[0];
        int maximumProduct = numbers[0];

        for (int index = 1; index < numbers.length; index++) {
            int number = numbers[index];
            int tempMax = Math.max(number, Math.max(currentMaximum * number, currentMinimum * number));
            int tempMin = Math.min(number, Math.min(currentMaximum * number, currentMinimum * number));

            currentMaximum = tempMax;
            currentMinimum = tempMin;
            maximumProduct = Math.max(maximumProduct, currentMaximum);
        }

        return maximumProduct;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, -2, 4, 8, -1, 5};
        System.out.println("Maximum subarray product: " + maxProduct(numbers));
    }
}
