package com.xcc.LeetCode;

import java.util.Arrays;

/**
 * 希尔排序
 * 希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法。
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 * 1.插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
 * 2.但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位；
 *
 * 希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
 * 待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序。
 *
 * 主要步骤：
 * 选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
 * 按增量序列个数 k，对序列进行 k 趟排序；
 * 每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，
 * 分别对各子表进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，
 * 表长度即为整个序列的长度。
 *
 */
public class ShellSortDemo {

    public static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {2,1,33,65,89,54,99,22};
        System.out.println(Arrays.toString(array));
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
