package com.example.subdemo.alogrithm;

/***
 * 有一个数组，我们对该数组进行加密，加密原则为 去除相邻相同元素后剩下的元素组成新的数组（注意：在去除一组相邻元素后，本来不相邻相同的元素可能回出现相邻相同的情况，
 * 例如：1 2 2 2 3 3 2，加密后的数组为 1）
 * 先定义两个相邻的起始游标，分为前游标和后游标，开始进行查找，如果找到相邻相同的元素，则将相邻相同元素进行同时置为 -1 ，然后前游标向前移动一个，后游标向后移动一个，
 * 再进行比较（去除这两个后，他们两个也算是相邻）。不满足相邻相同则正常移动游标，都向前移动一个
 * @author lvsheng
 * @version 1.0.0
 * @date 2022/06/01 18:01
 */
public class RemoveAdjacentSameElement {

    public static void main(String[] args) {
        int[] oldInt = {1, 3, 5, 3, 6, 2, 2, 2, 3, 3, 2, 1, 1, 1, 2, 1, 7};
        //1 3 5 3 6 2 2 1 2 1 7
        //1 3 5 3 6 1 2 1 7
        int[] newInt = borderSort(oldInt);
        System.out.print("#:");
        for (int i = 0; i < newInt.length; i++) {
            System.out.print(newInt[i] + " ");
        }
    }

    // 算法主体，去除相邻元素
    public static int[] borderSort(int[] sort) {

        // 定义两个游标,初始化为相邻游标
        int b = 0, a = 1;
        int len = sort.length;
        // 数组中 存在 -1 的个数
        int count = 0;
        while (a < len) {
            while (b >= 0 && a < len && sort[b] == sort[a]) {
                sort[b] = sort[a] = -1;
                while (b >= 0 && sort[b] == -1) {
                    b--;
                }
                while (a < len && sort[a] == -1) {
                    a++;
                }
                count = count + 2;
            }
            // 不满足则正常移动游标，都向前移动一个
            b = a++;
        }
        // 新数组，需要返回的数组
        int[] result = new int[len - count];
        // 新数组索引
        int newIndex = 0;
        for (int i = 0; i < len; i++) {
            if (sort[i] != -1) {
                result[newIndex] = sort[i];
                newIndex++;
            }
        }
        return result;
    }
}
