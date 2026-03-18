/*
 * Problem: Find the shortest unique prefix for every word in a list.
 *
 * Approach: Trie (Prefix Tree)
 *
 * Each node in the trie stores:
 * 1. children[26] -> references to next characters (a–z)
 * 2. eow -> marks end of a word
 * 3. freq -> number of words passing through that node
 *
 * Insertion Logic:
 * - While inserting a word, we traverse character by character.
 * - If a node already exists, we increment its freq.
 * - If it does not exist, we create a new node with freq = 1.
 *
 * Prefix Logic:
 * - The first node where freq == 1 means only one word uses that prefix.
 * - That prefix is the shortest unique prefix for that word.
 *
 * Example:
 * Input: ["zebra", "dog", "duck", "dove"]
 *
 * Trie Prefix Results:
 * zebra -> z
 * dog   -> dog
 * duck  -> du
 * dove  -> dov
 *
 * Time Complexity:
 * Insertion: O(N * L)
 * Prefix Search: O(N * L)
 * where
 * N = number of words
 * L = length of longest word
 *
 * This problem is commonly asked in interviews and appears in
 * coding platforms under names like "Shortest Unique Prefix".
 */

public class ShortestPrefix {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void findPrefix(Node root, String ans) { // O(L) Longest word in my trie
        if (root == null)
            return;
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                findPrefix(root.children[i], ans + (char) (i + 'a'));

            }
        }

    }

    public static void main(String[] args) {
        String arr[] = { "zebra", "dog", "duck", "dove" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        root.freq = -1;

        findPrefix(root, "");

    }
}
