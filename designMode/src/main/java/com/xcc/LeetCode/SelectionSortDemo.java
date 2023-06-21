package com.xcc.LeetCode;

import java.util.Arrays;

/**
 * 选择排序
 * 选择排序是一种简单直观的排序算法，原理是
 * 1.首先找出最小或者最大的元素，放到数列的起始位置
 * 2.再从剩余的数列中找出最小或者最大的元素，然后放到已排序数列的下一位
 * 3.重复第二步，直到所有元素排序完毕
 *
 * 例如：下面这个数列
 * [4,3,1,6,2,5,9]
 * 第一步找到1是最小的然后将1放起始位置
 * [1,3,4,6,2,5,9]
 * 然后剩下的再找最小的，最小的2放到已经排序的下一位
 * [1,2,4,6,3,5,9]
 * 。。。。。。
 * 最后得到排好的数列
 * [1,2,3,4,5,6,9]
 *
 * 这就是选择排序。
 * 很直观就是，一轮一轮选出最小或最大的排序
 * 这样就出现了一个问题，不管怎么样时间复杂度都是O(n*n)
 * 不过好处是不占用额外的空间，比较适合数据规模较小的场景使用
 */
public class SelectionSortDemo {

    /**
     * 选择排序的实现（从小到大顺序）
     * @param array     需要排序的数组
     */
    public static void selectionSort(int[] array) {
        // 需要循环的轮次n-1
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            // 每轮需要比较的次数n-i
            for (int j = i + 1; j < array.length; j ++) {
                // 记录目前找到最小值元素的下标
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的之进行交换
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,3,1,6,2,5,9};
        System.out.println(Arrays.toString(array));
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
