package com.example.subdemo.alogrithm.leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 回文的概念是ABA问题 正序和倒序一致2002 1221
 *
 * 示例 1：
 *
 * 输入：s = "babad" 输出："bab" 解释："aba" 同样是符合题意的答案。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-palindromic-substring 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2022/01/07 08:29
 */
public class Ag5 {


    public static void main(String[] args) {
        System.out.println(longestPalindrome("acacbbcddd"));
    }

    public static String longestPalindrome(String s) {

        char[] charArr = s.toCharArray();

        //寻找1次
        for (int index = 0; index < charArr.length; index++) {
            int startMoveIndex = index;
            int endMoveIndex = charArr.length - startMoveIndex;
            int rstStartIndex;
            int rstEndIndex;
        }

//        没有理解回文字符串的概念
//        int end;
//        int endValid = 0;
//        char[] charArr = s.toCharArray();
//        //回文的最大长度 默认是1
//        int max = 1;
//        for (int index = 0; index < charArr.length; index++) {
//            end = s.lastIndexOf(charArr[index]);
//            if (max < (end - index + 1)) {
//                endValid = end;
//                max = end - index + 1;
//            }
//        }
//        return s.substring(endValid + 1 - max, endValid + 1);
        return "";
    }
}
