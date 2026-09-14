public class MaxSumSubarray {
    public static int maxSubarraySum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int currentSum = numbers[0];
        int maximumSum = numbers[0];

        for (int index = 1; index < numbers.length; index++) {
            currentSum = Math.max(numbers[index], currentSum + numbers[index]);
            maximumSum = Math.max(maximumSum, currentSum);
        }

        return maximumSum;
    }

    public static void main(String[] args) {
        int[] numbers = {-2, 1, -3, 4, -1, 2, 1, -5, 7};
        System.out.println("Maximum subarray sum: " + maxSubarraySum(numbers));
    }
}
