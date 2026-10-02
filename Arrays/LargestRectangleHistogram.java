import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleHistogram {
    public static long largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Deque<Integer> increasingIndices = new ArrayDeque<>();
        long maximumArea = 0;

        for (int index = 0; index <= heights.length; index++) {
            int currentHeight = index == heights.length ? 0 : heights[index];
            if (index < heights.length && currentHeight < 0) {
                throw new IllegalArgumentException("Bar heights must be non-negative");
            }

            while (!increasingIndices.isEmpty()
                    && heights[increasingIndices.peek()] > currentHeight) {
                int height = heights[increasingIndices.pop()];
                int leftBoundary = increasingIndices.isEmpty() ? -1 : increasingIndices.peek();
                long width = index - leftBoundary - 1L;
                maximumArea = Math.max(maximumArea, height * width);
            }

            if (index < heights.length) {
                increasingIndices.push(index);
            }
        }

        return maximumArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest rectangle area: " + largestRectangleArea(heights));
    }
}
