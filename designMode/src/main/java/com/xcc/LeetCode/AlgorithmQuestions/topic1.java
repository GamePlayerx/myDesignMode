package com.xcc.LeetCode.AlgorithmQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组和一个目标和，从数组中找到两个数组相加等于目标和，输出这两个数字的下标
 * nums = [2, 4, 6, 1, 5]
 * target = 8
 * nums[0] + nums[2] = 8
 * return [0, 2]
 *
 * @Author xcc
 * @Date 2023/7/26
 */
public class topic1 {

    /**
     * 这是最简单的方法，利用冒泡排序的思想，一轮一轮比较
     * 举例：nums = [1, 2, 6, 4, 5], target = 8
     * nums[0] + nums[1] = 3
     * nums[0] + nums[2] = 7
     * nums[0] + nums[3] = 5
     * nums[0] + nums[4] = 6
     * nums[1] + nums[2] = 8
     * 输出：1, 2
     *
     * 时间复杂度：两层for循环，O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    /**
     * 这个方法利用了map的键值对来解决问题。
     * 还是之前的：nums = [1, 2, 6, 4, 5], target = 8
     *
     * 我们要的是nums中两个元素和为target的元素的下标
     * 用key和value的思路来考虑一个map，key和value是下面的：
     * key  value
     *  1    0
     *  2    1
     *  6    2
     *  4    3
     *  5    4
     *
     *  我们只要一轮循环
     *  nums[0] = 1, target - nums[0] = 7
     *  map.containsKsy(7) 要是存在结果是true，不是false
     *  true存在就是得到我们要的两个下标，[0, map.get(7)]
     *  false不存在，直接下一个。
     *
     *  时间复杂度：只有一轮循环，O(n)
     *  空间复杂度：这边多了个键值对map，O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)&&map.get(sub) != i) {
                return new int[]{i, map.get(sub)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 这边是将第二个方法，两个for循环合并在一起，复杂度没有变化，
     * 变化仅仅是不需要判断是不是当前元素了，因为当前元素还没有添加进map里。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)) {
                return new int[]{i, map.get(sub)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 6, 4, 5};
        int target = 8;
        int[] ans1 = twoSum1(nums, target);
        System.out.println(ans1[0]+", "+ans1[1]);

        int[] ans2 = twoSum2(nums, target);
        System.out.println(ans2[0]+", "+ans2[1]);

        int[] ans3 = twoSum3(nums, target);
        System.out.println(ans3[0]+", "+ans3[1]);
    }
}
