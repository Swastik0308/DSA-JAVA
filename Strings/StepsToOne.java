/*
Approach:
---------
We simulate the operations directly on the binary string instead of converting
it to an integer (which could overflow for large inputs).

Core Idea:
----------
1) If the current binary digit (LSB) is '0', the number is even.
   Dividing by 2 simply removes that bit (1 step).

2) If the digit is '1', the number is odd.
   We must add 1 first (which may create a carry),
   then divide by 2 (2 steps total).

Why Carry Is Important:
-----------------------
When we add 1 to a binary number ending in '1', it does NOT just flip that bit.
It creates a carry that propagates to the left:

Example:
    0111
  +    1
  ------
    1000

Notice how the carry turns consecutive 1s into 0s
and affects higher-order bits.

Instead of physically modifying the string after each addition,
we simulate this carry effect using a variable `carry`.

At each index (traversing from right to left):
    bit = (current digit) + carry

Possible values:
    0 → even → 1 step (divide by 2)
    1 → odd → 2 steps (add 1 + divide), set carry = 1
    2 → even (binary 10) → 1 step (divide), carry remains 1

Without tracking carry, we would incorrectly compute the
state of higher bits after an addition. Carry ensures we
accurately simulate how binary addition changes the number.

Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public int numSteps(String s) {

        int steps = 0;
        int carry = 0;

        // Start from last bit and stop at index 1
        for (int i = s.length() - 1; i > 0; i--) {

            int bit = (s.charAt(i) - '0') + carry;

            if (bit == 0) {
                // even
                steps += 1;
            } 
            else if (bit == 1) {
                // odd
                steps += 2;
                carry = 1;
            } 
            else { // bit == 2
                // even (10)
                steps += 1;
                carry = 1;
            }
        }

        // If carry remains at MSB
        return steps + carry;
    }
}
