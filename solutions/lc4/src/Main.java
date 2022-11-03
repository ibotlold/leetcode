public class Main {
    public static void main(String[] args) {
//        new Solution().findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        new Solution().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthSum = (nums1.length + nums2.length);
        int halfSize = lengthSum / 2 + 1;
        int[] halfArray = new int[halfSize];
        int k1 = 0, k2 = 0;
        for (int i = 0; i < halfArray.length; i++) {
            if (k1 == nums1.length) {
                halfArray[i] = nums2[k2];
                k2++;
                continue;
            }
            if (k2 == nums2.length) {
                halfArray[i] = nums1[k1];
                k1++;
                continue;
            }
            if (nums1[k1] <= nums2[k2]) {
                halfArray[i] = nums1[k1];
                k1++;
            } else {
                halfArray[i] = nums2[k2];
                k2++;
            }
        }
        if (lengthSum % 2 == 0) return (double)(halfArray[halfArray.length - 1] + halfArray[halfArray.length - 2]) / 2;
        return halfArray[halfArray.length - 1];
    }
}