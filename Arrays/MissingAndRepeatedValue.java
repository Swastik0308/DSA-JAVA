class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int N = n * n;

        int xor = 0;

        // Step 1: XOR all elements in grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                xor ^= grid[i][j];
            }
        }

        // Step 2: XOR numbers from 1 to N
        for (int i = 1; i <= N; i++) {
            xor ^= i;
        }

        // Now xor = repeating ^ missing

        // Step 3: Find rightmost set bit
        int rightmostSetBit = xor & -xor;

        int x = 0, y = 0;

        // Step 4: Divide grid elements into two groups
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((grid[i][j] & rightmostSetBit) != 0)
                    x ^= grid[i][j];
                else
                    y ^= grid[i][j];
            }
        }

        // Step 5: Divide numbers 1 to N into two groups
        for (int i = 1; i <= N; i++) {
            if ((i & rightmostSetBit) != 0)
                x ^= i;
            else
                y ^= i;
        }

        // Step 6: Determine which is repeating
        int repeating = 0, missing = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == x) count++;
            }
        }

        if (count == 2) {
            repeating = x;
            missing = y;
        } else {
            repeating = y;
            missing = x;
        }

        return new int[]{repeating, missing};
    }
}
