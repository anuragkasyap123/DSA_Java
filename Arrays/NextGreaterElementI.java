import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] numbers, int[] reference) {
        if (numbers == null || reference == null) {
            throw new IllegalArgumentException("Input arrays must not be null");
        }

        Map<Integer, Integer> nextGreaterByValue = new HashMap<>();
        Deque<Integer> decreasingStack = new ArrayDeque<>();

        for (int value : reference) {
            while (!decreasingStack.isEmpty() && decreasingStack.peek() < value) {
                nextGreaterByValue.put(decreasingStack.pop(), value);
            }
            decreasingStack.push(value);
        }

        int[] result = new int[numbers.length];
        for (int index = 0; index < numbers.length; index++) {
            result[index] = nextGreaterByValue.getOrDefault(numbers[index], -1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2};
        int[] reference = {1, 3, 4, 2};

        System.out.println("Next greater elements: "
                + Arrays.toString(nextGreaterElement(numbers, reference)));
    }
}
