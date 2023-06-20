package com.xcc.LeetCode;

import java.util.Arrays;

/**
 * 线性时间的排序：计数排序
 * 之前的冒泡，鸡尾酒，快速，堆排序这些排序都有共性：
 * 就是需要元素之间的比较。
 * 但有一些特殊的排序是不基于元素比较，如计数排序，桶排序
 * 计数排序是利用数组下标来确定元素的正确位置的。
 */
public class CountSortDemo {

    /** 计数排序的简单实现和介绍
     * 假设数组中有20个随机整数，取值范围是0-10[9,3,5,9,1,2,7,8,1,3,6,5,3,4,0,10,9,7,2,6]
     * 考虑到这些整数只能早0，1，2，3，4，5，6，7，8，9，10这11个数中取值，取值范围有限。
     * 可以创建一个长度为11的数组。数组下标从0到10，元素初始值全是0.
     * 0    0   0   0   0   0   0   0   0   0   0
     * 0    1   2   3   4   5   6   7   8   9   10
     * [9,3,5,9,1,2,7,8,1,3,6,5,3,4,0,10,9,7,2,6]
     * 下面就开始遍历无序的随机数列，每一个整数按照其值对号入座，同时，对应数组下标的元素进行加1操作。
     * 例如第1个整数是9，那么数组下标为9的元素加1
     * 0    0   0   0   0   0   0   0   0   1   0
     * 0    1   2   3   4   5   6   7   8   9   10
     * 按顺序最后得到如下数组：
     * [1, 2, 2, 3, 1, 2, 2, 2, 1, 3, 1]
     * 该数组中的每一个下标位置的值代表数列中对应整数出现的次数。
     * 然后输出数组元素的下标中，元素的值是几，就输出几次。
     *
     * @param array         需要排序的数组
     */
    public static int[] countSort(int[] array) {
        // 1.得到数列的最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // 2.根据数列最大值确定统计数组的长度
        int[] countArray = new int[max + 1];

        // 3.遍历数列，填充统计数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }

        System.out.println("遍历过的统计数组"+ Arrays.toString(countArray));

        // 4.遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[] {9,3,5,9,1,2,7,8,1,3,6,5,3,4,0,10,9,7,2,6};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

}
