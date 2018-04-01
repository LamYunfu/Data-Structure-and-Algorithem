package com.ouc.algorithem.CodingGuideInterviewPartTwo;
/*
 * 难度：一星士
 * 链表结点的值的类型为int类型，给定一个链表中的结点node,但是不给整个链表的头结点
 * 如何在链表中删除结点node?
 */
public class PartTwo081 {
	/*
	 * 首先这个题目是根本无法实现的，哈哈哈，就是个肯
	 * 一种比较容易想到的做法是让要删除结点的信息完全等于它下一个结点的信息，
	 * 包括值，next指针等等
	 * 但是如果下一个结点是null呢？根本没有办法让上一个结点的next指向null啊
	 * 而且这样子实际删除的是本该要删除结点的下一个结点，这在实际应用中会引起一系列的问题
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
