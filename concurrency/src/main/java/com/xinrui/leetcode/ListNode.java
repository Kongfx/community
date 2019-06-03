package com.xinrui.leetcode;

public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}

	@Override
	public String toString() {
		String result = "";
		result += this.val;

		ListNode child = this.next;

		while (child != null){
			result += child.val;
			child = child.next;
		}
		return result;
	}
}
