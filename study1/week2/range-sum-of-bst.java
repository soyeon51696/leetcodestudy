//https://leetcode.com/problems/range-sum-of-bst/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
        //time complexity is O(n), because visits n nodes to check
        //space complexity is O(1), bacause there is no new structure

        int sum = 0;

        //root = [10,5,15,3,7,null,18] low=15, high=18 => 10+15+18 
        if (root == null) {
            return 0;
        }
        if (root.val < low) { 
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        // low < root.val < high and wieder recursion 
        sum += root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
        
        return sum;
    }
}
