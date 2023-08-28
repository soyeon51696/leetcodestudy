//https://leetcode.com/problems/sort-the-people/

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        //time complexity is O(n) in for loop, and O(nlogn) in Arrays.sort()
        //so total time complexity is O(nlogn)
        //space complexity is O(n) because created a new HashMas of size n and a new String array of size n
        //(O(n + n = 2n = n))

        Map<Integer, String> table = new HashMap<>();
        int n = names.length;

        for (int i = 0; i < names.length; i++) {
            table.put(heights[i], names[i]);
        }

        Arrays.sort(heights); //ex. height = [165, 170, 180]

        int index = 0
        String[] result = new String[n];

        for (int i = heights.length - 1; i >= 0; i--) {
            result[index++] = table.get(heights[i]);
        }

        return result;


    }
}
