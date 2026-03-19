/*
 * Unique Prefix / Suffix Trie - Count Distinct Nodes
 *
 * Related Question: https://www.geeksforgeeks.org/problems/count-of-distinct-substrings/1
 * PROBLEM:
 * Given a string, count the total number of distinct nodes in a Trie
 * built by inserting all suffixes of the string.
 * This essentially counts the number of unique prefixes across all suffixes,
 * which equals the number of distinct substrings + 1 (root not counted, but
 * countNodes counts every non-null node).
 *
 * LOGIC:
 * 1. Generate all suffixes of the input string:
 *       "ababa" → "ababa", "baba", "aba", "ba", "a"
 *
 * 2. Insert each suffix into a Trie.
 *    - Each node in the Trie represents one character.
 *    - Shared prefixes between suffixes reuse existing nodes (no duplicates).
 *    - Example: "ababa" and "aba" share the path a→b→a, so no new nodes
 *      are created for that shared part.
 *
 * 3. Count all non-null nodes in the Trie recursively.
 *    - This count = number of distinct substrings of the original string
 *      (since every suffix prefix = some substring).
 *
 * EXAMPLE:
 *    str = "ababa"
 *    Suffixes inserted: "ababa", "baba", "aba", "ba", "a"
 *    Trie shares overlapping paths → total distinct nodes = 10
 *
 * TIME COMPLEXITY:
 *    - Inserting all suffixes: O(N^2) — N suffixes, avg length O(N)
 *    - Counting nodes:         O(N^2) — at most O(N^2) nodes in the Trie
 *    - Overall: O(N^2)
 *
 * SPACE COMPLEXITY:
 *    - Trie storage: O(N^2) — at most O(N^2) distinct nodes
 *      (each of the N suffixes has length up to N)
 */

public class UniquePrefix {
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

    public static int countNodes(Node root) {
        if (root == null)
            return 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        String str = "ababa";

        // find all suffix and insert in trie
        for (int i = 0; i < str.length(); i++) {
            insert(str.substring(i));
        }
        System.out.println(countNodes(root));
    }
}
