public class NextGreaterElementIII {
    public static int nextGreaterElement(int number) {
        if (number < 0) {
            return -1;
        }

        char[] digits = Integer.toString(number).toCharArray();
        int pivot = digits.length - 2;

        while (pivot >= 0 && digits[pivot] >= digits[pivot + 1]) {
            pivot--;
        }
        if (pivot < 0) {
            return -1;
        }

        int successor = digits.length - 1;
        while (digits[successor] <= digits[pivot]) {
            successor--;
        }

        char temp = digits[pivot];
        digits[pivot] = digits[successor];
        digits[successor] = temp;

        reverse(digits, pivot + 1, digits.length - 1);

        long result = Long.parseLong(new String(digits));
        return result <= Integer.MAX_VALUE ? (int) result : -1;
    }

    private static void reverse(char[] digits, int left, int right) {
        while (left < right) {
            char temp = digits[left];
            digits[left] = digits[right];
            digits[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println("Next greater after 12: " + nextGreaterElement(12));
        System.out.println("Next greater after 21: " + nextGreaterElement(21));
        System.out.println("Next greater after 1999999999: " + nextGreaterElement(1999999999));
    }
}
