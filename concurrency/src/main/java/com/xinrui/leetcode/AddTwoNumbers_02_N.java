package com.xinrui.leetcode;
/**
 * 	输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 	输出：7 -> 0 -> 8
 * 	原因：342 + 465 = 807
 * 	假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * */
public class AddTwoNumbers_02_N {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next =new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next =new ListNode(4);

		System.out.println(l1);
		System.out.println(l2);

		ListNode result = addTwoNumbers2(l1, l2);
		System.out.println(result);
	}


	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);

		while(l1 != null && l2 != null){
			int s = l1.val + l2.val;
			ListNode temp = new ListNode(0);
			ListNode next = new ListNode(0);
			next.val = s/10;
 			if(result.next == null){
				result.val = s%10;
			}else {
				temp.val = s%10;
				temp.next = next;
			}
			result.next = temp;
			temp = temp.next;

			l1 = l1.next == null ? null : l1.next;
			l2 = l2.next == null ? null : l2.next;
		}
		return result;
	}
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) p = p.next;
			if (q != null) q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
}