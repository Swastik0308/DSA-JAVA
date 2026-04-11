class Solution {
    public boolean searchMatrix(int[][] matrix, int key) {
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Found at position (" + row + "," + col + ")");
                return true;
            }

            else if (key < matrix[row][col]) {
                // move left
                col--;
            } else {
                // move bottom
                row++;
            }

        }
        System.out.println("Not found");
        return false;
        
    }
}
