//https://leetcode.com/problems/binary-search/description/

class Solution {
    public int search(int[] nums, int target) {
        //time complexity is O(log n), because binary search is used, where n is the size of the array. 
        //space complexity is O(1), indicating constant space usage
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;        
    }
}
