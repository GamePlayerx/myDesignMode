package com.xcc.java;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Stream流是一个来自数据源的元素队列并支持聚合操作
 * 元素是特定类型的对象，形成一个队列。Java中的Stream并不会存储元素，而是按需计算。
 * 数据源流的来源。可以是集合，数组， I/O channel，产生器generator等。
 * 聚合操作类似SQL语句一样的操作，比如filter, map, reduce, find, match, sorted等。
 * 和之前的Collection操作不同，Stream操作还有两个基础的特征：
 * 1、Pipelining：中间操作都会返回流对象本身。
 * 这样多个操作可以串联成一个管道，如同流式风格（fluent style）。
 * 这样做可以对操作进行优化，比如延迟执行（laziness）和短路（short-circuiting）。
 *
 * 2、内部迭代：以前对集合遍历都是通过Iterator或者For-Each的方式，
 * 显式的在集合外部进行迭代，这叫做外部迭代。
 * Stream提供了内部迭代的方式，通过访问者模式（Visitor）实现。
 */
public class StreamDemo {

    public static void main(String[] args) {

        // 生成流，在集合接口有两个方法来生成流
        // stream()  为集合船舰串行流。
        // parallelStream()  为集合创建并行流。
        List<String> strings = Arrays.asList("java", "", "c++", "go", "mysql", "", "redis");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(strings);
        System.out.println(filtered);

        // forEach
        // Stream提供了新的方法forEach来迭代流中的每个数据。以下代码片段使用forEach输出10个随机数：
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        // map
        // map方法用于映射每个元素到对应的结果，以下代码片段是使用map输出了元素对应的2倍数,并用distinct去重：
        List<Integer> numbers = Arrays.asList(5,7,1,3,1,8,5,2,9);
        List<Integer> numberList = numbers.stream().map( i -> i + i).distinct().collect(Collectors.toList());
        System.out.println(numberList);

        // filter
        // filter方法用于通过设置的条件过滤出元素。以下代码片段使用filter方法来过滤出大于10的：
        List<Integer> intList = Arrays.asList(6, 2, 1, 22, 45, 88, 90, 6);
        // 获取大于10的元素的数量
        long intCount = intList.stream().filter(integer -> integer > 10).count();
        List<Integer> listInt = intList.stream().filter(i -> i > 10).collect(Collectors.toList());
        System.out.println("intCount: " + intCount);
        System.out.println("listInt: " + listInt);

        // limit
        // limit方法用于获取指定数量的流。以下代码片段使用limit方法打印出5条数据：
        List<String> listString = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l");
        listString = listString.stream().limit(5).collect(Collectors.toList());
        System.out.println("listString: " + listString);

        // sorted
        // sorted方法用于对流进行排序。以下代码片段使用sorted方法对输出的10个数进行排序：
        List<Integer> integerList = Arrays.asList(26,31,6,90,43,2,76, 21, 44,5,65,9);
        integerList = integerList.stream().sorted().limit(10).collect(Collectors.toList());
        System.out.println("integerList: " + integerList);

        // 并行（parallel）程序
        // parallelStream是流并行处理程序的替代方法。以下实例我们使用parallelStream来输出非空字符串的数量：
        List<String> lists = Arrays.asList("abc","","def","ghi","","","jk","lmn");
        // 获取空字符串的数量
        long counts = lists.parallelStream().filter(s -> !s.isEmpty()).count();
        System.out.println("counts: " + counts);

        // Collectors
        // Collectors类实现了很多归约操作，例如将流转成集合和聚合元素。Co llectors可用于返回列表或字符串：
        List<String> filteredIng = lists.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表： " + filteredIng);
        String mergedString = lists.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        System.out.println("合并字符串： " + mergedString);

        // 统计
        // 另外，一些产生统计结果的收集器也非常有用。它们主要用于int，double，long等基本类型上，他们可以用来产生类似如下的统计结果。
        List<Integer> numberIng = Arrays.asList(4,-2,7,6,1,-9,8);
        IntSummaryStatistics stats = numberIng.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数： " + stats.getMax());
        System.out.println("列表中最小的数： " + stats.getMin());
        System.out.println("所有数之和： " + stats.getSum());
        System.out.println("平均数： " + stats.getAverage());

    }

}
