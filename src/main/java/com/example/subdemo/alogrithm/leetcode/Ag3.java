package com.example.subdemo.alogrithm.leetcode;

import java.util.Stack;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2022/01/05 09:59
 */
public class Ag3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        boolean empty = s.isEmpty();
        if (empty) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        String[] strArr = s.split("");
        int result = 0;

        for (int index = 0; index < strArr.length; index++) {
            int start = index;
            //填充起始元素
            stack.add(strArr[start]);
            start++;
            while (start < strArr.length) {
                //比较
                if (!stack.contains(strArr[start])) {
                    //决定是/否放入
                    stack.add(strArr[start]);
                    start++;
                } else {
                    break;
                }
            }
            result = Math.max(result, stack.size());
            stack.clear();
        }
        return result;
    }
}
