//https://leetcode.com/problems/n-th-tribonacci-number/description/

class Solution {
    public int tribonacci(int n) {
        //time complexity is O(n), since n indexes are visited
        //space complexity is O(n) (O(n+1) = O(n)), because an array of length n + 1 is created
        
        int[] result = new int[n + 1];

        if (n <= 2) {
            return n == 0 ? 0 : 1;
        }

        result[0] = 0;
        result[1] = 1;
        result[2] = 1;

        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 3] + result[i - 2] + result[i - 1];
        }
        
        return result[n];
    
    }
}
