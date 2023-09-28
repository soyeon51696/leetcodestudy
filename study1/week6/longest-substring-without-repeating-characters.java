// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //time complexity is O(n), where n is the lenfth of the String. 
        //space complexity is O(n), where n is the size of the HashSet.

        int index = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while (index < s.length()) {
            char c = s.charAt(index);
            if (set.contains(c)) {
                maxLength = Math.max(maxLength, set.size());
                set.remove(s.charAt(index - set.size()));;
            } 
            else {
                set.add(c);
                index++;
            }
        }
        
        return Math.max(maxLength, set.size());
    }
}
