//https://leetcode.com/problems/longest-palindrome/description/

class Solution {
    public int longestPalindrome(String s) {
        //Palindrome -> reads the same backwards as forwards
        //how to check? -> if reverse string is same as original string
      
        //thennnn

        //what rule? -> (even number of alphabets) or (even number of alphabets + only one odd number of alphabets) -> 2n or 2n+1
        //Then check how many each letter is -> use count value
        //If there is an even number of words in the string, remove them from the hashset, and then count + 1 each, then return count*2 when all are deleted (no alpabet in hashSet anymore)
        //After repeating, there are odd numbers left at the end? -> return count*2 + 1
        //Put s into the hashset, and count+1 if it already exists, then delete it, so i can figure out when there are odd numbers

        //so time complexity is O(n)
        //space complexity is also O(n)

        int count = 0;
        HashSet<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charSet.contains(c)) { //there is no c in charSet
                charSet.add(c);
            }
            else { //there is already c in charSet
                count++;
                charSet.remove(c); //to check odd character
            }
        }
        if (charSet.size() == 0) {
            return count * 2;
        }
        else {
            return (count * 2) + 1;
        }        
    }
}
