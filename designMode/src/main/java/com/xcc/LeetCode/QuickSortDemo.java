package com.xcc.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序实现
 * 快速排序是冒泡排序的进阶版。
 * 快速排序之所以快，是因为它使用了分治法
 * 冒泡排序在每一轮只把1个元素放到数列的一端，而快速排序则在每一轮挑选一个基准元素，并让其他比它大的元素移动到数列一边，
 * 比它小的元素移动到数列的另一边，从而把数列拆解成两个部分。
 * 这种思路就叫作分治法。
 *
 * 这样做的好处在于：
 * 假设给出n个元素的数列，一般情况下，用冒泡排序需要比对n-1轮，每一轮把1个元素移动到数列的一端，时间复杂度是O(n*n).
 *
 * 用分治法的思路解决同样的问题，原数列在每一轮都被拆分成两部分，每一部分在下一轮又被拆分成两部分，直到不可在分为止。
 * 每一轮的比较和交换，需要把数组全部元素都遍历一遍，时间复杂度是O(n)。那么平均情况下需要logn轮，所以快速排序的平均
 * 时间复杂度是O(nlogn)。
 * 所以基准元素的选择，及其元素的交换，都是快速排序的核心问题。
 * （不过也只是平均时间复杂度是O(nlogn),假设一个数列是倒序的，现在要用快速排序将其变为正序[8,7,6,5,4,3,2,1]
 * 用快速排序的话，每一轮理论上应该是要分为两部分，但是实际上数列并没有被分成两部分，在这种极端情况下，快速排序
 * 需要进行n轮，时间复杂度退化成了O(n*n)。所以快速排序的平均时间复杂度是O(nlogn)，但最坏情况下是时间复杂度是O(n*n)）。
 */
public class QuickSortDemo {

    /** 双边循环法，使用递归来解决
     * 举个例子：
     * 下面是个原始数列如下，要求对其从小到大进行排序。
     * 4，7，6，5，3，2，8，1
     * 实现，选定基准元素pivot，并且设置两个指针left和right，指向数列的最左和最右两个元素。
     * pivot=4；
     * 4        7       6      5       3       2       8       1
     * left                                                 right
     * 接下来进行第一次循环，从right指针开始，让指针指向的元素和基准元素做比较。
     * 如果大于或等于pivot，则指针向左移动；
     * 如果小于pivot，则right指针停止移动，切换到left指针。
     * 1<4所以right直接停止移动，换到left指针，进行下一步行动。
     * 轮到left指针行动，让指针所指向的元素和基准元素做比较。
     * 如果小于或等于pivot，则指针向右移动；如果大于pivot，则left停止移动。
     * 由于left开始指向的是基准元素，判断肯定相等，所以left右移1位。
     * pivot=4
     * 4        7       6      5       3       2       8       1
     *         left                                         right
     * 由于7>4,left指针在元素7的位置停下。这个时候让left和right指针所指向的元素进行交换。
     * pivot=4
     * 4        1       6      5       3       2       8       7
     *         left                                         right
     * 接下来，进入第2次循环，重新切换到right指针，向左移动。right指针先移动到8，
     * 8>4，继续左移。由于2<4,停止在2的位置。
     * pivot=4  （第2次循环，right指针停在2的位置，left指针停在6的位置）
     * 4        1       6      5       3       2       8       7
     *                 left                  right
     *
     * pivot=4  （元素2和元素6交换）
     * 4        1       2      5       3       6       8       7
     *                left                  right
     *
     * pivot=4  （第3次循环，right指针停在3的位置，left指针停在5的位置）
     * 4        1       2      5       3       6       8       7
     *                       left    right
     *
     * pivot=4  （元素3和元素5交换）
     * 4        1       2      3       5       6       8       7
     *                       left    right
     *
     * pivot=4  （第4次循环，right指针停在3的位置，和left指针重合）
     * 4        1       2      3       5       6       8       7
     *                       left/
     *                       right
     *
     * pivot=4  （最后把pivot元素也就是4与重合的元素3交换，这一轮宣告结束）
     * 3        1       2      4       5       6       8       7
     *                       left/
     *                       right
     * 分治法(双边循环法)
     * @param arr               待交换的数组
     * @param startIndex        起始下标
     * @param endIndex          结束下标
     */
    private static int partition1(int[] arr, int startIndex, int endIndex) {
        // 取第1个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            // 控制right指针比较并左移
            while (left<right && arr[right] > pivot) {
                right--;
            }
            // 控制left指针比较并右移
            while(left<right && arr[left] <= pivot) {
                left++;
            }
            // 交换left和right指针指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        // pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    public static void quickSort1(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大于或等于endIndex时
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition1(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归排序
        quickSort1(arr, startIndex, endIndex - 1);
        quickSort1(arr, pivotIndex + 1, endIndex);
    }

    /** 单边循环法
     * 一个数列，要将其从小到大进行排序。
     * 4        7       3      5       6       2       8       1
     * 首先选定基准元素pivot。同时，设置一个mark指针指向数列起始位置，这mark指针代表小于基准元素的区域边界。
     * pivot=4
     * 4        7       3      5       6       2       8       1
     * mark
     * 接下来，从基准元素的下一个位置开始遍历数组。
     * 如果遍历到的元素大于基准元素，就继续往后遍历。
     * 如果遍历到的元素小于基准元素，则需要做两件事：
     * 第一，把mark指针右移1为，因为小于pivot的区域边界增大了1；
     * 第二，让最新遍历到的元素和mark指针所在位置的元素交换位置，因为最新遍历的元素归属于小于pivot的区域。
     *
     * 首先遍历到元素7，7>4，所以继续遍历.
     * pivot=4
     * 4        7       3      5       6       2       8       1
     * mark
     * 接下来遍历到的元素是3，3<4，所以mark指针右移1位。
     * pivot=4
     * 4        7       3      5       6       2       8       1
     *         mark
     * 随后，让元素3和mark指针所在位置的元素交换，因为元素3归属于小于pivot的区域。
     * pivot=4
     * 4        3       7      5       6       2       8       1
     *         mark
     * 按这个思路，继续遍历：
     * pivot=4      （5>4,继续遍历）
     * 4        3       7      5       6       2       8       1
     *         mark
     * pivot=4      （6>4,继续遍历）
     * 4        3       7      5       6       2       8       1
     *         mark
     * pivot=4      （2<4,mark指针有移）
     * 4        3       7      5       6       2       8       1
     *                 mark
     * pivot=4      （元素2和mark指针所在位置的元素交换，因为元素2归属于小于pivot的区域）
     * 4        3       2      5       6       7       8       1
     *                 mark
     * pivot=4      （8>4,继续遍历）
     * 4        3       2      5       6       7       8       1
     *                 mark
     * pivot=4      （1<4,mark指针右移）
     * 4        3       2      5       6       7       8       1
     *                        mark
     * pivot=4      （元素1和mark指针所在位置的元素交换，因为元素1归属于小于pivot的区域）
     * 4        3       2      1       6       7       8       5
     *                        mark
     * pivot=4      （最后把pivot元素交换到mark指针所在位置，这一轮结束）
     * 1        3       2      4       6       7       8       5
     *                        mark
     *
     * @param arr           待交换的数组
     * @param startIndex    起始下标
     * @param endIndex      结束下标
     */
    private static int partition2(int[] arr, int startIndex, int endIndex) {
        // 取第1个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark ++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void quickSort2(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件: startIndex大于或等于endIndex时
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition2(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归排序
        quickSort2(arr, startIndex, pivotIndex - 1);
        quickSort2(arr, pivotIndex + 1, endIndex);
    }

    /** 分治
     *
     * @param arr           待交换的数组
     * @param startIndex    起始下标
     * @param endIndex      结束下标
     */
    private static int partition3(int[] arr, int startIndex, int endIndex) {
        // 取第1个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex+1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;

        return mark;
    }

    public static void quickSort3(int[] arr, int startIndex, int endIndex) {
        // 用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
        // 整个数列的起止下标，以哈希的形式入栈
        Map rootParam = new HashMap();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        // 循环结束条件：栈为空时
        while (!quickSortStack.isEmpty()) {
            // 栈顶元素出栈，得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            // 得到基准元素位置
            int pivotIndex = partition3(arr, param.get("startIndex"), param.get("endIndex"));
            // 根据基准元素分成两部分，把每一部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<String, Integer>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<String, Integer>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {4,7,6,5,3,2,8,1};
        quickSort1(arr1,0, arr1.length-1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[] {4,7,3,5,6,2,8,1};
        quickSort2(arr2, 0, arr2.length-1);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[] {4,7,6,3,5,2,8,1};
        quickSort3(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr3));
    }

}
