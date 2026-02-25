import java.util.*;

public class HashMapIntro {
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert-O(1)
        hm.put("Tea", 10);
        hm.put("Rice", 50);
        hm.put("Coffee", 20);
        hm.put("Burger", 50);

        System.out.println(hm);

        // Get O(1)
        System.out.println(hm.get("Tea")); // if key doesnt exist it returns null

        // Contains Key - O(1)
        System.out.println(hm.containsKey("tea"));
        System.out.println(hm.containsKey("Samosa"));// false

        // Remove - O(1)
        // hm.remove("Rice");
        // System.out.println(hm);

        // Size
        System.out.println(hm.size());

        // IsEmpty
        // hm.clear(); // It will clear the hashmap
        // System.out.println(hm.isEmpty());
        // System.out.println(hm);

        // Iterate
        Set<String> keys = hm.keySet();
        // System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key= " + k + " ,value = " + hm.get(k));
        }
    }
}
