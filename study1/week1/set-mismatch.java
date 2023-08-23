class Solution {
    public int[] findErrorNums(int[] nums) {
        //time complexity: O(n)
        //space complexiti: O(n) -> because of hashSet..?
        int n = nums.length;
        int[] resultArr = new int[2];
        int expectSum = 0;
        int actualSum = 0;

        HashSet<Integer> numsSet = new HashSet<Integer>();

        for(int i = 0; i < n; i++) {
            if (numsSet.contains(nums[i])) { //already contains
                resultArr[0] = nums[i];
            }
            else { //not yet
                actualSum += nums[i];
            }
            numsSet.add(nums[i]);
        }

        expectSum = n * (n + 1) / 2;
        resultArr[1] = Math.abs(expectSum - actualSum);

        return resultArr;
    }
}
