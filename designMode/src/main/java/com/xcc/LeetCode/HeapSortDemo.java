package com.xcc.LeetCode;

import java.util.Arrays;

/**
 * 堆排序的特性：
 * 1.最大堆的堆顶是整个堆中的最大元素。
 * 2.最小堆的堆顶是整个堆中的最小元素。
 *
 * 主要是利用了二叉堆的特性，顶节点不是最大就是最小，就算删除了，二叉堆会自动排序，将最大或最小放到顶节点
 * 堆排序就是利用整个特性实现的。
 * 这样一来空间复杂度是O(1)，因为没有开辟额外的集合空间。
 * 但是时间复杂度和快速排序一样有最坏的情况：O(nlogn),平均情况：O(logn)
 */
public class HeapSortDemo {

    /**
     * 下沉调整
     * @param array         待调整的堆
     * @param parentIndex   要下沉的父节点
     * @param length        堆的有效大小
     */
    public static void downjust(int[] array, int parentIndex, int length) {
        // temp 保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子大于左孩子的值，则定位待右孩子
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            // 如果父节点大于任何一个孩子的值，则直接跳出
            if (temp >= array[childIndex])
                break;
            // 无须真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 堆排序（升序）
     * @param array     待调整的堆
     */
    public static void heapSort(int[] array) {
        // 1.把无序数组构建成最大堆
        for (int i = (array.length - 2)/2; i >= 0; i--) {
            downjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        // 2.循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶
        for (int i = array.length - 1; i > 0; i--) {
            // 最后1个元素和第1个元素进行交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 下沉调整最大堆
            downjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,3,2,6,5,7,8,9,10,0};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
