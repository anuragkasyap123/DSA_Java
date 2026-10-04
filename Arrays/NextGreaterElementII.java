import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }

        int[] result = new int[numbers.length];
        Arrays.fill(result, -1);

        Deque<Integer> decreasingIndices = new ArrayDeque<>();
        // The following loop iterates through the array twice to simulate a circular array from fornt.
        // for (int index = 0; index < 2 * numbers.length; index++) {
        //     int currentIndex = index % numbers.length;

        //     while (!decreasingIndices.isEmpty()
        //             && numbers[decreasingIndices.peek()] < numbers[currentIndex]) {
        //         result[decreasingIndices.pop()] = numbers[currentIndex];
        //     }

        //     if (index < numbers.length) {
        //         decreasingIndices.push(currentIndex);
        //     }
        // }

        for (int index = 2 * numbers.length - 1; index >= 0; index--) {
            int currentIndex = index % numbers.length;

            while (!decreasingIndices.isEmpty()
                    && numbers[decreasingIndices.peek()] <= numbers[currentIndex]) {
                decreasingIndices.pop();
            }

            if (index < numbers.length) {
                result[currentIndex] = decreasingIndices.isEmpty()
                        ? -1
                        : numbers[decreasingIndices.peek()];
            }

            decreasingIndices.push(currentIndex);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 1};
        System.out.println("Next greater elements: " + Arrays.toString(nextGreaterElements(numbers)));
    }
}
