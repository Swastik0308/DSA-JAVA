/*
 * Trie (Prefix Tree) Implementation in Java
 *
 * A Trie is a tree-based data structure used for efficient storage
 * and retrieval of strings, especially useful for dictionary-like
 * operations such as prefix search, autocomplete, and spell checking.
 *
 * In this implementation:
 * - Each node represents a character.
 * - Each node contains an array of size 26 to represent lowercase
 *   English letters ('a' to 'z').
 * - `eow` (End Of Word) marks whether a complete word ends at that node.
 *
 * Operations Implemented:
 *
 * 1. insert(String word)
 *    Inserts a word into the Trie.
 *    - Traverse character by character.
 *    - Create nodes if they don't exist.
 *    - Mark the last node as End Of Word.
 *    Time Complexity: O(L) where L = length of the word.
 *
 * 2. search(String key)
 *    Checks whether a word exists in the Trie.
 *    - Traverse using characters of the key.
 *    - If any character path does not exist → return false.
 *    - If traversal finishes and eow is true → word exists.
 *    Time Complexity: O(L)
 *
 * Example Words Inserted:
 *   "the", "a", "there", "their", "any", "thee"
 *
 * Example Searches:
 *   search("thee") → true
 *   search("thor") → false
 *   search("an")   → false (prefix exists but not a complete word)
 *
 * Key Idea:
 * Trie allows fast prefix-based searching compared to storing
 * words in a list or array.
 */

public class Intro {
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

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any", "thee" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("thee"));
        System.out.println(search("thor"));
        System.out.println(search("an"));

    }
}
