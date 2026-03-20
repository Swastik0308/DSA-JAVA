/*
Problem:
Find the longest word in the given dictionary such that all of its prefixes 
are also present in the dictionary.

Related Question: https://leetcode.com/problems/longest-word-in-dictionary

Approach:
- Use a Trie to store all words.
- Perform DFS from the root.
- At each step, move only to child nodes where eow (end of word) is true.
  → This ensures every prefix is a valid word.
- Use backtracking (StringBuilder) to build words dynamically.
- Update the answer when a longer valid word is found.

Key Idea:
We only explore paths where every prefix exists in the dictionary.

Example:
Input: ["a", "ap", "app", "apple", "apply"]
Valid chain: a → ap → app → appl → apple 

Time Complexity:
- Insertion: O(N * L)
- DFS traversal: O(26 * L * number of valid nodes)

Note:
- If multiple answers have the same length, lexicographically smaller one can be chosen.
*/

public class LongestPrefix {
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

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);

                // backtrack
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String words[] = { "a", "banana", "app", "ap", "appl", "apply", "apple" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder());
        System.out.println(ans);
    }
}
