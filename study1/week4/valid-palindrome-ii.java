//https://leetcode.com/problems/valid-palindrome-ii/submissions/

class Solution {
    //time complexity is O(n)
    //space complexity is O(n), because n call stacks?
  
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean unEqual = false;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return checkPalindrome(s, start + 1, end) || checkPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;        
    }

    private boolean checkPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;  
    }
}
