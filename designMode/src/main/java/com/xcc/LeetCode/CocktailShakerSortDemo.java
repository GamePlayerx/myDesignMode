package com.xcc.LeetCode;

import java.util.Arrays;

/**
 * 冒泡排序是每一轮都是从左到右，或者从右到左比较元素进行单向的位置交换。
 * 这就出现新的问题。举个例子：
 * 一个无序数列{2，3，4，5，6，7，8，1}现在要对其进行从小到大的排序
 * 如果按冒泡排序，排序过程如下
 * 第1轮：
 * 2，3，4，5，6，7，1，8
 * 第2轮：
 * 2，3，4，5，6，1，7，8
 * 第3轮：
 * 2，3，4，5，1，6，7，8
 * 第4轮：
 * 2，3，4，1，5，6，7，8
 * 第5轮：
 * 2，3，1，4，5，6，7，8
 * 第6轮：
 * 2，1，3，4，5，6，7，8
 * 第7轮：
 * 1，2，3，4，5，6，7，8
 * 2，3，4，5，6，7，8已经有序了，却还要进行1轮。所以才有了冒泡排序的进阶算法，鸡尾酒排序。
 *
 * 鸡尾酒排序是：
 * 第1轮（和冒泡排序一样，8和1交换）
 * 2，3，4，5，6，7，1，8
 *
 * 第2轮
 * 此时开始不一样了，我们反过来从右往左比较进行交换。
 * 2,3,4,5,6,7,1,8
 * 2,3,4,5,6,1,7,8
 * 2,3,4,5,1,6,7,8
 * 2,3,4,1,5,6,7,8
 * 2,3,1,4,5,6,7,8
 * 2,1,3,4,5,6,7,8
 * 1,2,3,4,5,6,7,8
 * 第3轮（虽然实际上已经有序，但是流程并没有结束）
 * 在鸡尾酒排序的第3轮，需要重新从左向右比较进行交换。
 * 没有元素位置进行交换，证明已经有序，排序结束。
 *
 * 这结束鸡尾酒排序的思路。排序过程就像钟摆一样，第1轮从左到右，第2轮从右到左，第3轮再从左到右。。。。
 */
public class CocktailShakerSortDemo {

    /**
     * 鸡尾酒排序的原始实现。
     * 代码外层的大循环控制着所有排序回合，大循环内包含2个小循环，
     * 第1个小循环从左到右比较并交换元素，
     * 第2个小循环从右到左比较并交换元素。
     * @param array
     */
    public static void sort(int array[]) {
        // 容器用来进行元素交换的中转用的
        int tmp = 0;

        // 外循环控制所有的回合
        for (int i = 0; i < array.length/2; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            // 奇数轮，从左到右比较和交换
            for (int j = i; j < array.length - i - 1; j++) {
                // 元素对比，如果前一个元素大于后一个元素，进行元素交换
                if (array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] =tmp;
                    // 有元素交换，标记变为false
                    isSorted = false;
                }
            }
            // 通过标记来判断是否有序，如果已经是有序的了，剩下的几轮就不用执行了
            if (isSorted) {
                break;
            }

            // 在偶数轮之前，将isSorted重新标记为true
            isSorted = true;
            // 偶数轮，从右到左比较和交换
            for (int j = array.length - i - 1; j > i; j--) {
                // 元素对比，如果前一个元素大于后一个元素，进行元素交换
                if (array[j] < array[j-1]) {
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    // 有元素交换，标记变为false
                    isSorted = false;
                }
            }

            // 通过标记来判断是否有序，如果已经是有序的了，剩下的几轮就不用执行了
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,5,6,7,8,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
