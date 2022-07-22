package com.example.subdemo.alogrithm.leetcode;


import java.math.BigDecimal;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2022/01/05 09:59
 */
public class Ag2 {

    public static void main(String[] args) {
        ListNode number1 = new ListNode(2, new ListNode(4, new ListNode(4)));
        ListNode number2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(number1, number2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int[] number1 = new int[100], number2 = new int[100];
        int number1Index = 0;
        int number2Index = 0;
        //链表循环组装数字
        while (l1 != null) {
            number1[number1Index++] = l1.val;
            l1 = l1.next;
        }

        //链表循环组装数字
        while (l2 != null) {
            number2[number2Index++] = l2.val;
            l2 = l2.next;
        }

        //反转
        StringBuilder n1 = new StringBuilder();
        for (int index = number1.length - 1; index >= 0; index--) {
            n1.append(number1[index]);
        }

        //反转
        StringBuilder n2 = new StringBuilder();
        for (int index = number1.length - 1; index >= 0; index--) {
            n2.append(number2[index]);
        }

        BigDecimal twoSum = new BigDecimal(n1.toString()).add(new BigDecimal(n2.toString()));
        String[] splitArr = twoSum.toString().split("");
        ListNode resultNode = null;
        //组装链表
        for (int index = 0; index < splitArr.length; index++) {

            if (index == 0) {
                resultNode = new ListNode(Integer.parseInt(splitArr[index]));
            } else {
                resultNode = new ListNode(Integer.parseInt(splitArr[index]), resultNode);
            }
        }
        return resultNode;
    }

    //Definition for singly-linked list.
    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}



