package com.xinrui.multithread.chat01;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author kong
 * @Date 2019/2/21 13:47
 * @Version 1.0
 */
public class MyThread extends Thread {
	private int count = 5;

	public MyThread(String name){
		super();
		this.setName(name);
	}

	@Override
	public void run() {
		while (count  > 0){
			count --;
			System.err.println(Thread.currentThread().getName()+"计算count="+count);
		}
	}

	public static void main(String[] args) {
		/*
		* 非共享数据 count 不会发生并发问题
		* */
		MyThread a = new MyThread("A");
		MyThread b = new MyThread("B");
		MyThread c = new MyThread("C");
		MyThread d = new MyThread("D");
		a.start();
		b.start();
		c.start();
		d.start();
	}
}
