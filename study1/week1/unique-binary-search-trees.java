//https://leetcode.com/problems/unique-binary-search-trees
class Solution {
    public int numTrees(int n) {
        //time complexity: O(n^2); in first for loop 2~n visit, and also in second loop 1~n visit
        //space complexity: O(n); new array of length n + 1 -> n
        int[] root = new int[n + 1];

        root[0] = 1;
        root[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                root[i] += root[j - 1] * root[i - j];
                //if n == 2
                    //i=2, j=1,2
                //root[2] += root[0] * root[2-1=1] = 1*1 = 1
                //root[2] += root[1] * root[2-2=0] = 1*1 = 1
                //root[2] = 2

                //if n == 3 
                    //i=2,3 j=1,2,3
                    //root[2] += root[0] * root[2-1=1] = 1*1 = 1
                    //root[2] += root[1] * root[2-2=0] = 1*1 = 1
                    
                    //root[3] += root[0] * root[3-1=2] = 1*2 = 2
                    //root[3] += root[1] * root[3-2=1] = 1*1 = 1
                    //root[3] += root[2] * root[3-3=0] = 2*1 = 2
                    //root[3] = 2+1+2 = 5
            }
        }
        
        return root[n];
    
    }
}
