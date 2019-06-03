package com.xinrui.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SynchronizedExample
 * @Description TODO
 * @Author kong
 * @Date 2019/5/23 17:24
 * @Version 1.0
 */
@Slf4j
public class SynchronizedExample {

	public void test1(int j){
		synchronized (this){
			for (int i = 0; i < 10; i++) {
				log.info("test1 - j = {},i = {}",j,i);
			}
		}
	}

	public synchronized void test2(int j) {
		for (int i = 0; i < 10; i++) {
			log.info("test2 - j = {},i = {}",j,i);
		}
	}

	public static void main(String[] args) {
		SynchronizedExample example1 = new SynchronizedExample();
		SynchronizedExample example2 = new SynchronizedExample();
		ExecutorService executorService = Executors.newCachedThreadPool();

		/*
		// test1 与 test2 执行结果一直 都是 0-9 0-9
		executorService.execute(()->{
			example1.test1(1);
		});

		executorService.execute(()->{
			example1.test1(1);
		});*/

		// 执行结果是 1-0 与 2-0 交叉执行  但 每组都是按照从0-9顺序执行
		// 同步代码块 与 同步方法 执行结果相同
		// 父类 的同步方法 子类继承父类 不能将sync关键字带到子类中去   需要在子类 添加sync关键字修饰方法
		executorService.execute(()->{
			example1.test1(1);
		});

		executorService.execute(()->{
			example2.test1(2);
		});

		executorService.shutdown();
	}

}
