/*
Approach: Fixed-Size Sliding Window + Frequency Counting

1. Create two frequency arrays of size 26 to store character frequencies
   for s1 and the initial window of s2.
2. If s1 is longer than s2, return false because a permutation cannot fit.
3. Compare the frequency arrays to check whether the initial window
   is a permutation of s1.
4. Slide the window one position at a time:

   * Decrement the frequency of the outgoing character.
   * Increment the frequency of the incoming character.
   * Compare the updated window frequencies with s1's frequencies.
5. If the frequencies match, return true. Otherwise, return false
   after checking all possible windows.

Time Complexity: O(26 * m) = O(m), where m is s2.length().
Space Complexity: O(1), using two fixed-size frequency arrays.
*/



import java.util.Arrays;

class Solution {

    public boolean isFreq(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freqWindow = new int[26];

        // Count frequencies of s1 and the initial window in s2
        for (int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freqWindow[s2.charAt(i) - 'a']++;
        }

        // Check the initial window
        if (isFreq(freq1, freqWindow)) {
            return true;
        }

        // Slide the window one position at a time
        for (int i = n; i < m; i++) {

            // Remove the outgoing character
            freqWindow[s2.charAt(i - n) - 'a']--;

            // Add the incoming character
            freqWindow[s2.charAt(i) - 'a']++;

            // Compare character frequencies
            if (isFreq(freq1, freqWindow)) {
                return true;
            }
        }

        return false;
    }
}

