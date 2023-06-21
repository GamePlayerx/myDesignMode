package com.xcc.LeetCode;

import java.util.Arrays;

public class SelectionSortDemo2 {

    /**
     * 选择排序（从大到小）
     * @param array     需要排序的数组
     */
    public static void selectionSort(int[] array) {
        // 需要循环的轮次n-1
        for (int i = 0; i < array.length - 1; i++) {
            int max = i;
            // 每轮需要比较的次数n-i
            for (int j = i + 1; j < array.length; j ++) {
                // 记录目前找到最大值元素的下标
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            // 将找到的最大值和i位置所在的之进行交换
            if (i != max) {
                int temp = array[i];
                array[i] = array[max];
                array[max] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {3,2,10,4,1,7,8,6};
        System.out.println(Arrays.toString(array));
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
