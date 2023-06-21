package com.xcc.LeetCode;

import java.util.Arrays;

/**
 * 插入排序：
 * 插入排序的原来非常的简单，打个比方：就像是斗地主，别人发给你一堆牌，你需要整理，你拿到第一张牌就是有序的数列，
 * 因为就一张数列肯定是有序的，然后根据大小你会将下一张牌自动排序，这样有序数列的范围就变大了，等你把牌整理好了，
 * 就得到了一个有序的数列，这个过程就是插入排序。
 * 他的工作原理是通过构建有序序列，对于未排序数列，再已排序序列中从后向前扫描。找到相应位置并插入。
 *
 */
public class InsertSortDemo {

    /**
     * 插入排序的简单实现
     * @param array     需要排序的数组
     */
    public static void insertSort(int[] array) {
        // 从下标位1的元素开始选择适合的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            // 记录要插入的数据
            int temp = array[i];
            // 从已经排序的序列最右边开始比较，找到比其小的数
            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            // 存再比其小的数，插入
            if (j != i) {
                array[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {3,10,23,45,23,76,27,2,54};
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
