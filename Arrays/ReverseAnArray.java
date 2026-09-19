public class ReverseAnArray {
    /**
     * Returns an array where result[i] is the product of all elements except numbers[i].
     * Time: O(n), extra space: O(1) excluding the returned array.
     */
    public static int[] process(int[] numbers, int l, int r) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        while (l < r) {
            int temp = numbers[l];
            numbers[l] = numbers[r];
            numbers[r] = temp;
            l++;
            r--;
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int[] res = process(numbers, 0, numbers.length - 1);

        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }
}
