package com.xcc.LeetCode;

import java.util.Arrays;

/**
 * 冒牌排序实现的demo
 */
public class BubbleSortDemo {

    /**
     * 冒牌排序的实现
     * 代码非常简单，使用双循环进行排序。外部循环控制所有的回合，
     * 内部循环实现每一轮的冒泡处理，先进行元素比较，在进行元素交换。
     * @param array     需要排序的数组
     */
    public static void sort(int array[]) {
        int temp = 0;
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,3,9,6,1,8,2,5,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
