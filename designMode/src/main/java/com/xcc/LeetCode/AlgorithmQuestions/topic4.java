package com.xcc.LeetCode.AlgorithmQuestions;

/**
 * 已知两个有序数组，找到两个数组合并后的中位数
 * [1, 3], [2] -> 2
 *
 * @Author xcc
 * @Date 2023/8/2
 */
public class topic4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays1(nums1, nums2));
    }

    /**
     * 只是最简单粗暴的方式，将两个数组合并为一个数组，然后看数组的长度的奇数，还是偶数
     * 奇数返回 nums[nums.length / 2], 偶数返回 (nums[nums.length / 2 -1] + nums[nums.length / 2]) / 2
     * 不过在这个之前先要判断两个数组是不是空的
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }
        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }
        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    /**
     * 中位数可将数值集合划分为相等的上下两部分
     * 所以可以直接将数组切块，将两个数组切开，然后我们要保证左右两部分数量一样
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        // 保证 m <= n
        if (m > n) {
            return findMedianSortedArrays2(B,A);
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            // i 需要增大
            if (j != 0 && i != m && B[j-1] > A[i]){
                iMin = i + 1;
                // i 需要减小
            } else if (i != 0 && j != n && A[i-1] > B[j]) {
                iMax = i - 1;
                // 达到要求，并且将边界条件列出来单独考虑
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j-1];
                } else if (j == 0) {
                    maxLeft = A[i-1];
                } else {
                    maxLeft = Math.max(A[i-1], B[j-1]);
                }
                // 奇数的话不需要考虑右半部分
                if ( (m + n) % 2 == 1 ) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                //如果是偶数的话返回结果
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
