package com.example.subdemo.alogrithm.leetcode;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2022/01/05 10:02
 */
public class Ag4 {

    public static void main(String[] args) {

//        int[] nums1 = new int[]{1, 3};
//        int[] nums2 = new int[]{2};
//        System.out.println(findMedianSortedArrays(nums1, nums2));
//        List<Integer> totalList = CollectionUtil.toList(3, 4, 51, 2, 3);
//        //数组排序
//        CollectionUtil.sort(totalList, Comparator.comparingInt(a -> a));
//        System.out.println(totalList);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length == 0) {
            return 0d;
        }
        //数组合并
        int[] totalArr = new int[length];
        System.arraycopy(nums1, 0, totalArr, 0, nums1.length);
        System.arraycopy(nums2, 0, totalArr, nums1.length, nums2.length);
        //快速排序
        sort(totalArr, 0, totalArr.length - 1);
        //数组长度计算
        int left, right;
        int mod = length % 2;

        if (mod == 0) {
            left = length / 2;
            right = length / 2 + 1;
        } else {
            left = length / 2 + 1;
            right = left;
        }
        //中位数计算
        return (totalArr[left - 1] + totalArr[right - 1]) / 2.0;
    }

    public static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }
            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;
        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }
}
