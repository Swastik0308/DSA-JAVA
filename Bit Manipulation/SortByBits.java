import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        
        // Convert int[] to Integer[] because custom comparator doesn't work on primitive int
        Integer[] temp = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        
        Arrays.sort(temp, (a, b) -> {
            
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            // First sort by number of 1s
            if(countA != countB) {
                return countA - countB;
            }
            
            // If same number of 1s → sort by value
            return a - b;
        });
        
        // Convert back to int[]
        for(int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
        
        return arr;
    }
}
