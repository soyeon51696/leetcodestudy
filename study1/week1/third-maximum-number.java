class Solution {
    public int thirdMax(int[] nums) {
        //time complexity O(n)
        //space complexiti O(1)

        if (nums.length == 0 || nums == null) {
            return 0; //or -1?
        }
        
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int i : nums) { //nums = 321
            // skip duplicated number 
            if (i == firstMax || i == secondMax || i == thirdMax) {
                continue;
            }
            //find firstMax
            if (firstMax < i) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = i;
            }
            //find secondMax
            else if (i < firstMax && i > secondMax) {
                thirdMax = secondMax;
                secondMax = i;
            }
            //find thirdMax
            else if (i < secondMax && i > thirdMax) {
                thirdMax = i;
            }
        }
        return thirdMax == Long.MIN_VALUE ? (int) firstMax : (int) thirdMax;
    }
}
