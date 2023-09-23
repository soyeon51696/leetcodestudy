//https://leetcode.com/problems/fair-candy-swap/description/

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        //time complexity is O(n+m),where n is the size of aliceSizes and m is the size of bobSizes
        //space complexity is O(1)
        
        int aSum = sum(aliceSizes);
        int bSum = sum(bobSizes);
        int diff = (aSum - bSum) / 2;

        int[] result = new int[2];

        HashSet<Integer> bobSizesSet = new HashSet<Integer>();
        for (int bNum : bobSizes) {
            bobSizesSet.add(bNum);
        }
        
        for (int aNum : aliceSizes) {
            if (bobSizesSet.contains(aNum - diff)) {
                result[0] = aNum;
                result[1] = aNum - diff;
                break;
            }
        }
        return result;
    }

    private int sum(int[] boxes) {
        int sum = 0;
        for (int num : boxes) {
            sum += num;
        }
        return sum;
    }
}
