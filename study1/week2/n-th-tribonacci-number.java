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

        //for O(1) of space complexity -> don't need to make a new array, but create simply normal int value and save it there
        /*
        if (n <= 2) {
            return n == 0 ? 0 : 1;
        }
        
        int sum = 0;
        int first = 0;
        int second = 1;
        int third = 1;

        for (int i = 3; i <= n; i++) {
            sum = first + second + third;
            first = second;
            second = third;
            third = sum;
        }
        return sum;       
        */
    
    }
}
