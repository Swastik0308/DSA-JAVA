/*
 * Word Break using Trie + Recursion
 *
 * Problem:
 * Given a string `key` and a dictionary of valid words, determine whether
 * the string can be segmented into a sequence of one or more dictionary words.
 *
 * Approach:
 * 1. A Trie (Prefix Tree) is used to store all dictionary words efficiently.
 * 2. Each Trie node contains:
 *      - children[26] → references to next characters (a–z)
 *      - eow → marks the end of a valid word.
 *
 * 3. Insert Operation:
 *      Each word from the dictionary is inserted character by character
 *      into the Trie. If a node does not exist for a character, a new node
 *      is created.
 *
 * 4. Search Operation:
 *      Checks whether a given word exists in the Trie by traversing
 *      character by character. Returns true only if the final node marks
 *      end-of-word.
 *
 * 5. Word Break Logic:
 *      The string is divided into prefixes using recursion.
 *      For every possible split:
 *
 *          prefix = key.substring(0, i)
 *          suffix = key.substring(i)
 *
 *      If:
 *          prefix exists in Trie
 *          AND suffix can also be segmented recursively
 *
 *      then the string can be segmented successfully.
 *
 * 6. Base Case:
 *      If the remaining string becomes empty, return true.
 *
 * Time Complexity:
 *      Worst case ≈ O(2^n) due to recursion with overlapping subproblems.
 *
 * Space Complexity:
 *      O(n) recursion stack + Trie storage.
 *
 * Example:
 *      Dictionary = { "i", "like", "sam", "samsung", "mobile", "ice" }
 *      key = "ilikesamsung"
 *
 *      Possible segmentation:
 *      "i" + "like" + "samsung"
 *
 *      Output → true
 *
 * Concept Used:
 *      Trie (Prefix Tree) + Recursion (similar idea to Dynamic Programming Word Break problem).
 */

public class WordBreak {
    static class Node {
        Node children[] = new Node[26]; // bcz of 26 characters
        boolean eow = false; // End of Word

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }

    }

    public static Node root = new Node(); // In tries root is always empty

    public static void insert(String word) { // O(L) lenght of the longest word
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {// we have used i=1 bcz in substring ending index is exclusive
        if (key.length() == 0)
            return true;
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String arr[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
