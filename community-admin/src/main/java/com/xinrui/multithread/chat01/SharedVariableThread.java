package com.xinrui.multithread.chat01;

/**
 * @ClassName SharedVariableThread
 * @Description TODO
 * @Author kong
 * @Date 2019/2/21 13:54
 * @Version 1.0
 */
public class SharedVariableThread extends Thread{
	private int count=5;

	@Override
//	public void run() {
	public synchronized void run() {
		super.run();
		count --;
		System.err.println(Thread.currentThread().getName()+"计算count="+count);
	}

	public static void main(String[] args) {
		/*
		* 1.共享数据 会发生并发问题
		* 2.增加synchronized关键字
		* */
		SharedVariableThread thread = new SharedVariableThread();
		Thread a = new Thread(thread,"A");
		Thread b = new Thread(thread,"B");
		Thread c = new Thread(thread,"C");
		Thread d = new Thread(thread,"D");
		Thread e = new Thread(thread,"E");

		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}

}
