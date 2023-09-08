//https://leetcode.com/problems/reduce-array-size-to-the-half/description/

class Solution {
    public int minSetSize(int[] arr) {
        //time complexity is O(n)
        //space complexity is also O(n)
        
        int arrLength = arr.length;
        int result = 0;

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        //set up the frequency map
        for (int value : arr) {
            //if (map.containsKey(value)) {
            //    map.put(value, map.getOrDefault(value, 0) + 1);
            //}
            //else {
            //    map.put(value, 0);
            //}
            map.put(value, map.getOrDefault(value, 0) + 1);

        }
        
        // Sort the map entries by frequency in descending order
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> b.getValue() - a.getValue());

        int removed = 0;
        int index = 0;

        while (removed < arrLength / 2) {
            removed += entryList.get(index++).getValue();
            if (index == arrLength) {
                break;
            }
            result++;

        }

        return result;      
        
    }
}
