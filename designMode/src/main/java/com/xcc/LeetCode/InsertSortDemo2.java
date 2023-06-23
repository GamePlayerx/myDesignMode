package com.xcc.LeetCode;

import java.util.Arrays;

/**
 * 插入排序优化
 * 拆半插入和直接插入排序类似，折半插入排序每次交换的是相邻的且值为不同的元素，
 * 它并不会改变值相同的元素之间的顺序，因此它是稳定的。
 *
 * 取 0 ~ i-1 的中间点 ( m = (i-1) >> 1 )，array[i] 与 array[m] 进行比较，若 array[i] < array[m]，
 * 则说明待插入的元素 array[i] 应该处于数组的 0 ~ m 索引之间；
 * 反之，则说明它应该处于数组的 m ~ i-1 索引之间。
 * 重复上面的操作，每次缩小一半的查找范围，直至找到插入的位置。
 * 在指定位置插入第 i 个元素。
 */
public class InsertSortDemo2 {

    public static void insertSort(int[] array){
        int first = 0;//分别记录temp数组中最大值和最小值的位置
        int last = 0;
        int k = 0;
        int len = array.length;
        int[] temp = new int[len];
        temp[0] = array[0];
        for (int i = 1; i < len; i++){
            // 待插入元素比最小的元素小
            if (array[i] < temp[first]){
                first = (first - 1 + len) % len;
                temp[first] = array[i];
            }
            // 待插入元素比最大元素大
            else if (array[i] > temp[last]){
                last = (last + 1 + len) % len;
                temp[last] = array[i];
            }
            // 插入元素比最小大，比最大小
            else {
                k = (last + 1 + len) % len;
                //当插入值比当前值小时，需要移动当前值的位置
                while (temp[((k - 1) + len) % len] > array[i]) {
                    temp[(k + len) % len] =temp[(k - 1 + len) % len];
                    k = (k - 1 + len) % len;
                }
                //插入该值
                temp[(k + len) % len] = array[i];
                //因为最大值的位置改变，所以需要实时更新final的位置
                last = (last + 1 + len) % len;
            }
        }
        // 将排序记录复制到原来的顺序表里
        for (k = 0; k < len; k ++) {
            array[k] = temp[(first + k) % len];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {2,5,10,89,45,23,40,11,1};
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
