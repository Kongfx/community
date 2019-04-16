package com.xinrui.multithread.chat01;

/**
 * @ClassName StopThreadDemo
 * @Description TODO
 * @Author kong
 * @Date 2019/2/21 14:02
 * @Version 1.0
 */
public class StopThreadDemo extends Thread {

	@Override
	public void run() {
		super.run();
//		for (int i = 0; i < 100000; i++) {
//			System.out.println("i="+i);
//		}

		for (int i = 0; i < 500000; i++) {
			if (this.interrupted()) {
				System.out.println("已经是停止状态了!我要退出了!");
//				break;
				return;
			}
			System.out.println("i=" +i);
		}
//		控制台执行了线面的输出  说明 使用break 只能跳出循环 而并没有停止线程
//		使用return 时才能将线程停止
		System.out.println("看到这句话说明线程并未终止------");
	}

	public static void main(String[] args) {
		StopThreadDemo thread = new StopThreadDemo();
		thread.start();
		try {
			Thread.sleep(1000);
			thread.interrupt();//调用 interrupt 中断线程 并不能停止线程
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}

	}

}
