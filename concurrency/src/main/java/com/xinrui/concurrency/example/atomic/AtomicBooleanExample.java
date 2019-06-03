package com.xinrui.concurrency.example.atomic;

import com.xinrui.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName ConcurrencyTest
 * @Description TODO
 * @Author kong
 * @Date 2019/5/23 10:56
 * @Version 1.0
 */
@Slf4j
@ThreadSafe
public class AtomicBooleanExample {

	//	请求总数
	public static int clientTotal = 5000;

	//	同时执行并发执行的线程数
	public static int threadTotal = 200;

	public static AtomicBoolean isHapppened = new AtomicBoolean(false);

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadTotal);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i=0;i<clientTotal;i++){
			executorService.execute(()->{
				try {
					semaphore.acquire();
					test();
					semaphore.release();
				} catch (Exception e) {
					log.info("exception e={}",e);
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executorService.shutdown();
		log.info("isHapppened={}",isHapppened);
	}

	private static void test() {
		if(isHapppened.compareAndSet(false,true)){
			log.info("isHappened={}",isHapppened);
		}
	}
}
