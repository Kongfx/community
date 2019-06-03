package com.xinrui.concurrency;

import com.xinrui.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName ConcurrencyTest
 * @Description TODO
 * @Author kong
 * @Date 2019/5/23 10:56
 * @Version 1.0
 */
@Slf4j
@NotThreadSafe
public class ConcurrencyTest {

//	请求总数
	public static int clientTotal = 5000;
//	同时执行并发执行的线程数
	public static int threadTotal = 200;

	public static void concurrencyTest() throws InterruptedException {
		int count = 0;
		ExecutorService executorService = Executors.newCachedThreadPool();
		//信号量
		final Semaphore semaphore = new Semaphore(threadTotal);
		/**
		* CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。每当一个线程完成了自己的任务后，计数器的值就会减1。
		* 当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
		* */
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i=0;i<clientTotal;i++){
			executorService.execute(()->{
				try {
					semaphore.acquire();
					add(count);
					semaphore.release();
				} catch (Exception e) {
					log.info("exception e={}",e);
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executorService.shutdown();
		log.info("count={}",count);
	}

	private static void add(int count) {
		count++;
	}
}
