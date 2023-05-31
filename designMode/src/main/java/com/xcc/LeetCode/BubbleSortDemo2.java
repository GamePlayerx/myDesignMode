package com.xcc.LeetCode;

import java.util.Arrays;

/**
 * 冒泡排序的优化
 * 之前写的初始的冒泡排序是双循环解决的，可能有人会发现一些问题。举个例子：
 * {5，8，6，3，9，2，1，7}这个数列排序，当排序到第6、第7轮时，数列状态如下。
 * 第6轮排序：
 * 1，2，3，5，6，7，8，9
 *
 * 第7轮排序：
 * 1，2，3，5，6，7，8，9
 *
 * 很明显，在第6轮的时候，整个数列已经是有序的了。
 * 可是冒泡排序还是要继续执行第7轮排序。
 * 所有才要优化一些，如果能判断出数列已经有序了，并做出标记，那么剩下的几轮排序就不必要执行了，
 * 可以提前结束工作。
 */
public class BubbleSortDemo2 {

    /**
     * 冒泡排序的优化
     * 还是利用双循环来实现冒泡排序，
     * 外部循环控制所有的回合，
     * 内部循环实现每一轮的冒泡处理，先进行元素比较，在进行元素交换。
     * 不过在内循环中加个布尔变量isSorted作为标记。
     * 如果本轮排序，有元素交换，说明数列无序；
     * 如果没有元素交换，说明数列有序，然后直接跳出大循环。
     * @param array
     */
    public static void sort1(int array[]) {
        // 容器用来进行元素交换的中转用的
        int temp = 0;
        // 外循环控制所有的回合
        for (int i = 0; i < array.length - 1; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            // 内循环实现每一轮的冒泡处理，先进行元素比较，在进行元素交换
            for (int j = 0; j < array.length - i - 1; j++) {
                // 元素对比，如果前一个元素大于后一个元素，进行元素交换
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    // 有元素进行交换，标记变为false
                    isSorted = false;
                }
            }
            // 通过标记来判断是否有序，如果已经是有序的了，剩下的几轮就不用执行了
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序不光是添加布尔变量来优化还有别的。举个例子：
     * 现在有这样的数列{3，4，2，1，5，6，7，8}这个数列的特点是
     * 前半段部分的元素是无序的（3，4，2，1），后半段部分的元素（5，6，7，8）
     * 却是按升序排列，并且后半段部分元素中的最小值也大于前半段部分元素的最大值。
     * 这样一来，第1轮结束后：
     * 3，2，1，4，5，6，7，8
     * 第2轮结束后：
     * 2，1，3，4，5，6，7，8
     * 这时候其实有个问题，右边的许多元素已经有序了，可是每一轮还是要去比较。
     * 这个问题的关键点在于对数列有序区的界定。
     * 按照现有的逻辑，有序区的长度和排序的轮数是相等的。例如第1轮之后有序区的长度是1，
     * 第2轮之后有序区的长度是2.。。。。。。
     * 但实际上，数列真正的有序区可能会大于这个长度，如上述例子中在第2轮排序时，后面的5个元素已经
     * 属于有序区了。因此后面的多次元素比较是没有意义的。
     * 那么，为了避免这种情况，我们可以在每一轮后，记录下来最后一次元素交换的位置，该位置即为无序数列的边界，
     * 在往后就是有序区了。
     * @param array
     */
    public static void sort2(int array[]) {
        // 容器用来进行元素交换的中转用的
        int temp = 0;
        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;
        // 外循环控制所有的回合
        for (int i = 0; i < array.length - 1; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            // 内循环实现每一轮的冒泡处理，先进行元素比较，在进行元素交换。
            // 不过现在循环次数是无序数列的边界。
            for (int j = 0; j < sortBorder; j++) {
                // 元素对比，如果前一个元素大于后一个元素，进行元素交换
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    // 有元素进行交换，标记变为false
                    isSorted = false;
                    // 有元素进行交换，记录下最后交换的位置
                    lastExchangeIndex = j;
                }
            }
            // 内循环结束，要更新一下无序数列的边界
            sortBorder = lastExchangeIndex;
            // 通过标记来判断是否有序，如果已经是有序的了，剩下的几轮就不用执行了
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{5,8,6,3,9,2,1,7};
        sort1(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = new int[]{3,4,2,1,5,6,7,8};
        sort2(array2);
        System.out.println(Arrays.toString(array2));
    }

}
