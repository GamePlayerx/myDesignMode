package com.xcc.LeetCode.AlgorithmQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，扎到没有重复字符的最长子串，返回它的长度
 * 例如：
 * Input：aaddbacecc
 * Ouput: dbace -> 5
 * @Author xcc
 * @Date 2023/7/28
 */
public class topic3 {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongSetSubString1("aaddbacecc"));
//        System.out.println(lengthOfLongSetSubString2("aaddbacecc"));
//        System.out.println(lengthOfLongMap("aaddbacecc"));
        System.out.println(lengthOfLongArray("aaddbacecc"));
    }

    /**
     * 只是一个非常简单的实现方式；
     * 一个字符串s， 不重复的情况就是 1 - s.length 之间
     * 直接用冒泡排序的思路，一轮一轮找出最长的子串
     * a  a  d  d  b  a  c  e  c  c
     * 0  1  2  3  4  5  6  7  8  9
     * i  j
     * i     j
     * i        j
     * .......
     * [i, j)
     * 找出[i, j)中长度最长的
     * @param s
     * @return
     */
    public static int lengthOfLongSetSubString1(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    /**
     * 用set来做重复字符的校验
     * 创建一个set集合用于放字符
     * 不存在就放进去，
     * 存在就退出
     * @param s
     * @param start
     * @param end
     * @return
     */
    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 上面是一轮一轮比较，其实有很多步骤是可以省略的[0,3) 当第4个字符和第3个字符是一样时候[0, 4)就没必要去确认了
     * a  a  d  d  b  a  c  e  c  c
     * 0  1  2  3  4  5  6  7  8  9
     *       i        j
     * 还是冒泡排序的思路，[i, j)
     * 但是这个区间，不是原理的全跑一遍
     * @param s
     * @return
     */
    public static int lengthOfLongSetSubString2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 思路还是[i,j)区间的方式，不过现在是用mao记录而不是set
     * 用map方式i可以直接跳， 不需要remove操作
     * 还有个不同之处是 j 每次循环都进行了自加 1 ，
     * 因为 i 的跳跃已经保证了 str[ i , j] 内没有重复的字符串，所以 j 直接可以加 1
     * ans 在每次循环中都进行更新，因为 ans 更新前 i 都进行了更新，
     * 已经保证了当前的子串符合条件，所以可以更新 ans
     * @param s
     * @return
     */
    public static int lengthOfLongMap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * 思路还是[i,j)的方式，不过现在用数组的来记录不是map
     * 字符的 ASCII 码值作为数组的下标，数组存储该字符所在字符串的位置。
     * 而且没有了 if 的判断，因为如果 index[ s.charAt ( j ) ] 不存在的话，它的值会是 0 ，对最终结果不会影响。
     * @param s
     * @return
     */
    public static int lengthOfLongArray(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

}
