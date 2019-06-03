package com.xinrui.concurrency;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author kong
 * @Date 2019/2/19 17:19
 * @Version 1.0
 */
public class Demo {

	public static void main(String[] args) {
		String a = new String("aaa");
		String b = a.intern();
		System.out.println(a==b);
//		System.out.println(Thread.currentThread().getName());

	}


}
