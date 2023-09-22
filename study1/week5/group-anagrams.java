//https://leetcode.com/problems/group-anagrams/description/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //time complexity is O(n*m*logm), where n is the number of words in strs, m is the length of word
        //space complexity is O(n*m), Store n words, words of length m, in map
        
        Map<String, List<String>> stringMap = new HashMap<>();

        for (String str : strs) { //time : O(n), where n is the number of words in strs
            char[] chars = str.toCharArray();
            Arrays.sort(chars); //time : O(m*logm), where m is the length of word
            String sortedChars = new String(chars);

            if (!stringMap.containsKey(sortedChars)) {
                stringMap.put(sortedChars, new ArrayList<>());
            }
            stringMap.get(sortedChars).add(str);
        }        

        return new ArrayList<>(stringMap.values());
    }
}
