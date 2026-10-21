/*
Approach: Variable-Size Sliding Window + Frequency Counting

1. Create a frequency array to store the required character frequencies of t.
2. Expand the window by moving the right pointer and update the character frequencies.
3. Maintain a variable 'required' to track the number of character occurrences
   still needed to form a valid window.
4. When required == 0, the current window contains all characters of t.
5. Update the minimum window length and starting index if the current window
   is smaller than the previously recorded minimum.
6. Shrink the window by moving the left pointer and restoring the frequency
   of the outgoing character.
7. If a required character becomes missing, increase 'required' and expand
   the window again.
8. Return the smallest valid substring, or an empty string if no valid window exists.

Time Complexity: O(|s| + |t|)
Space Complexity: O(1), using a fixed-size ASCII frequency array.
*/



class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] freq = new int[128];

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int required = t.length();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (freq[c] > 0) {
                required--;
            }
            freq[c]--;

            while (required == 0) {
                int windowLen = right - left + 1;

                if (windowLen < minLen) {
                    minLen = windowLen;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;

                if (freq[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}

