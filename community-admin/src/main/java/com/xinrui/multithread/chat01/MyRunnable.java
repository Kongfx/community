package com.xinrui.multithread.chat01;

/**
 * @ClassName MyRunnable
 * @Description TODO
 * @Author kong
 * @Date 2019/2/21 14:39
 * @Version 1.0
 */
public class MyRunnable implements Runnable {
	private String name;

	public MyRunnable(String name){
		this.name = name;
	}
	public MyRunnable(){
	}
	@Override
	public void run() {
		try {
			Thread.currentThread().setName(this.name);
			System.out.println(Thread.currentThread().getName()+" Start");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+" End.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
