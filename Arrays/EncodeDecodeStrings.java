import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    /**
     * Encodes a list of strings using each string's length as a prefix.
     * Time: O(n), where n is the total number of characters.
     */
    public static String encode(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException("List must not be null");
        }

        StringBuilder encoded = new StringBuilder();
        for (String value : strings) {
            if (value == null) {
                throw new IllegalArgumentException("Strings must not be null");
            }

            encoded.append(value.length()).append('#').append(value);
        }
        return encoded.toString();
    }

    /**
     * Decodes a string created by encode.
     * Time: O(n), where n is the encoded string length.
     */
    public static List<String> decode(String encoded) {
        if (encoded == null) {
            throw new IllegalArgumentException("Encoded value must not be null");
        }

        List<String> strings = new ArrayList<>();
        int index = 0;
        while (index < encoded.length()) {
            int separator = encoded.indexOf('#', index);
            if (separator == -1) {
                throw new IllegalArgumentException("Invalid encoded value");
            }

            int length;
            try {
                length = Integer.parseInt(encoded.substring(index, separator));
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("Invalid encoded value", exception);
            }

            int valueStart = separator + 1;
            int valueEnd = valueStart + length;
            if (length < 0 || valueEnd > encoded.length()) {
                throw new IllegalArgumentException("Invalid encoded value");
            }

            strings.add(encoded.substring(valueStart, valueEnd));
            index = valueEnd;
        }
        return strings;
    }

    public static void main(String[] args) {
        List<String> original = List.of("hello", "", "a#b", "42");
        String encoded = encode(original);
        List<String> decoded = decode(encoded);

        if (!original.equals(decoded)) {
            throw new AssertionError("Decoded strings do not match the original list");
        }

        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decoded);
    }
}