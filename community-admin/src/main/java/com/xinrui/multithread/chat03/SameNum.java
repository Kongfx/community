package com.xinrui.multithread.chat03;

/**
 * @ClassName SameNum
 * @Description TODO
 * @Author kong
 * @Date 2019/2/25 15:41
 * @Version 1.0
 */
public class SameNum {
	public static void main(String[] args) {
		/*
		*
		* 	main end
			i == 5;Thread-0
			i == 5;Thread-1
			i == 4;Thread-2
			i == 3;Thread-3
			i == 2;Thread-4
		*
		* */
		MyRannable mr = new MyRannable();
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread(mr);
		Thread t3 = new Thread(mr);
		Thread t4 = new Thread(mr);
		Thread t5 = new Thread(mr);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		System.out.println("main end");

	}
}


class MyRannable implements Runnable{
	private int i = 5;
	@Override
	public void run() {
		System.out.println("i == "+(i--)+";"+Thread.currentThread().getName());
	}
}