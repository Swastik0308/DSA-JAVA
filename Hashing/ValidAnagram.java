import java.util.HashMap;

public class ValidAnagram { // O(n)

    // An anagram is a word or phrase formed by rearranging the letters of another,
    // using all original letters exactly once. Common examples include
    // silent/listen, earth/heart, and debit card/bad credit.

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) { // char exist
                if (map.get(ch) == 1) {
                    map.remove(ch); // if freq is one we directly remove it from the map
                } else {
                    map.put(ch, map.get(ch) - 1); // if freq is more we reduce by one
                }

            } else {
                // if doesnt exist
                return false;
            }
        }

        return map.isEmpty(); // if map is empty then it is a valid anagram
    }

    public static void main(String[] args) {
        String s = "race";
        String t = "care";

        System.out.println(isAnagram(s, t));
    }
}
