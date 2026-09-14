import java.util.HashMap;
import java.util.Map;

public class DictionaryIteration {
    public static void main(String[] args) {
        Map<String, Integer> dictionary = new HashMap<>();
        dictionary.put("Apple", 10);
        dictionary.put("Banana", 20);
        dictionary.put("Mango", 30);

        // Best way to iterate through both keys and values.
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Iterate through only keys.
        for (String key : dictionary.keySet()) {
            System.out.println("Key: " + key);
        }

        // Iterate through only values.
        for (Integer value : dictionary.values()) {
            System.out.println("Value: " + value);
        }
    }
}
