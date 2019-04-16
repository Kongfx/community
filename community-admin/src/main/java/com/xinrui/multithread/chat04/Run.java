package com.xinrui.multithread.chat04;

/**
 * @ClassName Run
 * @Description TODO
 * @Author kong
 * @Date 2019/2/25 16:04
 * @Version 1.0
 */
public class Run {
	public static void main(String[] args) {
		Thread t = new Thread(new R());
//		//R 的构造函数 线程：main
//		//R 的run方法 线程：Thread-0
//		t.start();
		//R 的构造函数 线程：main
		//R 的run方法 线程：main
		t.run();
	}
}
class R implements Runnable{
	public R(){
		System.out.println("R 的构造函数 线程：" + Thread.currentThread().getName());
	}
	@Override
	public void run() {
		System.out.println("R 的run方法 线程：" + Thread.currentThread().getName());
	}
}