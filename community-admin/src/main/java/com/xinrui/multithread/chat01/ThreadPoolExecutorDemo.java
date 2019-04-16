package com.xinrui.multithread.chat01;

import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolExecutorDemo
 * @Description TODO
 * @Author kong
 * @Date 2019/2/21 14:24
 * @Version 1.0
 */
public class ThreadPoolExecutorDemo {

	public static void main(String[] args) {
		// 创建一个线程池对象，控制要创建几个线程对象。
		 // public static ExecutorService newFixedThreadPool(int nThreads)
		 ExecutorService executor = Executors.newFixedThreadPool(2);

		 // 可以执行Runnable对象或者Callable对象代表的线程
		executor.submit(new MyRunnable("A"));
		executor.submit(new MyRunnable("B"));
		 //结束线程池
		executor.shutdown();
//
//		ThreadPoolExecutor pool = new ThreadPoolExecutor(5,7, 0L, TimeUnit.MILLISECONDS,
//				new LinkedBlockingQueue<Runnable>());
//		ThreadFactory factory = new ThreadFactory() {
//			@Override
//			public Thread newThread(Runnable r) {
//				return null;
//			}
//		};
//		ThreadPoolTaskExecutor asyncExecutor = new ThreadPoolTaskExecutor();
//		Executors
//				ScheduledThreadPoolExecutor
	}

}
