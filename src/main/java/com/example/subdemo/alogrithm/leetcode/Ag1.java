package com.example.subdemo.alogrithm.leetcode;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2022/01/05 09:59
 */
public class Ag1 {

    public static int[] twoSum(int[] nums, int target) {

        int[] indexArr = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {

//            if (nums[i] > target) {
//                continue;
//            }

            int diff = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (diff == nums[j]) {
                    indexArr[index++] = i;
                    indexArr[index++] = j;
                    break;
                }
            }
        }

        if (index > 0) {
            int[] rstArr = new int[index];
            System.arraycopy(indexArr, 0, rstArr, 0, index);
            return rstArr;
        }
        return null;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;
//        int[] nums = new int[]{3, 2, 4};
//        int target = 6;
        int[] nums = new int[]{-1, -2, -3, -4, -5};
        int target = -8;
        int[] arr = twoSum(nums, target);
        System.out.println(arr);
    }
}
