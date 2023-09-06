//https://leetcode.com/problems/pascals-triangle/submissions/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        //When numRows is n, time complexity is O(n^n)
        //Because, the first for loop -> visits n times and the inner for-loop -> visits up to n times 
        //(because j repeats at most i times, if i is n then j also n)
        
        //When numRows is n, space complexity is O(n^2)
        //Because, n lists are stored in result list, so the length of the result list is n.
        //And then in also inner for-loop n lists are stored in semiResult list.
        //So O(n * n) = O(n^2)
      
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) { //until numRow
            List<Integer> semiResult = new ArrayList<>();

            semiResult.add(1);
            for (int j = 0; j <= i; j++) { //j <= i -> 1st -> 1 element, 2nd -> 2 elements, 3rd -> 3 elemets, ...
                // if (j == 0) {
                //     semiResult.add(1);
                // }
                // else if (j == i) {
                //     semiResult.add(1);
                // }
                semiResult.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            semiResult.add(1); //because j == 0 is for the first element and j == i is for the last element and reduce the number of comparisons
            result.add(semiResult);
        }
        return result;
    }
}
