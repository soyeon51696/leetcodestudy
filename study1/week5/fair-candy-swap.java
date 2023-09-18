//https://leetcode.com/problems/fair-candy-swap/description/

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        //time complexity is O(n*m),where n is the size of aliceSizes and m is the size of bobSizes
        //space complexity is O(1)
        int aSum = sum(aliceSizes);
        int bSum = sum(bobSizes);
        int mid = (aSum + bSum) / 2;
        int diff = bSum - mid;

        int[] result = new int[2];
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        
        for (int aNum : aliceSizes) {
            for (int bNum : bobSizes) {
                if (bNum - aNum == diff) {
                    result[0] = aNum;
                    result[1] = bNum;
                }
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
