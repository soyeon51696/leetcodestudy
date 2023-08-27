//https://leetcode.com/problems/invert-binary-tree/description/

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
    public TreeNode invertTree(TreeNode root) {
        //time complexity: O(nlogn) bacause it is binary Tree archtecture 
        //-> 1. first root -> 2. firstroot.left, firstroot.right -> 3. firstroot.left.left/right, firstroot.right.left/right ... 
        //space complexity: O(1), because of just changing?..
        if (root == null) {
           return root; //or null?
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }   
}
