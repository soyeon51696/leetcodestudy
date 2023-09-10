//https://leetcode.com/problems/reduce-array-size-to-the-half/description/

class Solution {
    public int minSetSize(int[] arr) {
        //time complexity is O(nlogn)
        //space complexity is also O(n)

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
        int halfArray = arr.length / 2;
        int result = 0;
        int index = 0;

        while (removed < halfArray) {
            removed += entryList.get(index++).getValue();
            // if (index == arrLength) {
            //     break;
            // } -> don't need it
            result++;

        }

        return result;      

        /* code review
        //After counting the numbers, the key actually becomes irrelevant, as we only need the count, 
        //so you can make this a simple List with one Integer type in it, so :
        List<Integer> entryList = new ArrayList<>(map.values());
        Collections.sort(entryList);
        //ㄴ> but as the sort() sort it as ascending order, you need to iterate backwards.

        int removed = 0;
        int halfArray = arr.length / 2; //Rather making arrLength a variable, making halfArray would seem to make more sense as it's being used multiple times.
        int result = entryList.size() - 1;
        while (removed < halfArray) {
            removed += entryList.get(result--);
        }
        return entryList.size() - result - 1;
        /*
        
    }
}
