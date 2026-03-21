/*
Problem: Pascal's Triangle (LeetCode 118)

Core Idea:
- Pascal Triangle is based on combination formula:
      nCr = n! / (r! * (n-r)!)
- Instead of factorial (slow + overflow), we use:
      nCr = nC(r-1) * (n - r + 1) / r


--------------------------------------------------
Variant 1: Generate Entire Pascal Triangle
--------------------------------------------------
(Given numRows → return full triangle)

Approach:
- For each row, compute values using nCr iterative formula
- Avoid factorial → prevents overflow and reduces time

Time Complexity: O(n^2)
Space Complexity: O(1) (excluding output)

(This is what your current code does)


--------------------------------------------------
Variant 2: Print Entire Row (IMPORTANT)
--------------------------------------------------
(Given row number n → return nth row)

Approach:
- Directly compute row using nCr
- Start with 1
- Use:
      next = prev * (n - i) / i

Time Complexity: O(n)
Space Complexity: O(1)

Code:
public List<Integer> getRow(int n){
    List<Integer> row = new ArrayList<>();
    long ans = 1;
    row.add(1);

    for(int i = 1; i < n; i++){
        ans = ans * (n - i);
        ans = ans / i;
        row.add((int)ans);
    }
    return row;
}


--------------------------------------------------
Variant 3: Find Element at (row, col)  🔥 MOST ASKED
--------------------------------------------------
(Given row r and column c → find value)

Formula:
      value = (r-1)C(c-1)

Why (r-1, c-1)?
- Because Pascal triangle is 1-indexed visually
- But nCr is 0-index based

Approach:
- Compute nCr directly using loop (NO factorial)

Time Complexity: O(c)
Space Complexity: O(1)

Code:
public int getElement(int r, int c){
    int n = r - 1;
    int rIndex = c - 1;

    long ans = 1;
    for(int i = 1; i <= rIndex; i++){
        ans = ans * (n - i + 1);
        ans = ans / i;
    }
    return (int)ans;
}
*/


class Solution {
    public List<Integer> helper(int row){
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int col = 1; col < row; col++){
            ans = ans * (row - col);
            ans = ans / (col);
            ansRow.add((int)ans);
        }
        return ansRow;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            ans.add(helper(i));
        }
        return ans;
    }
}
