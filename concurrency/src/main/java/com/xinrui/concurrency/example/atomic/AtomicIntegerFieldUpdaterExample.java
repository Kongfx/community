package com.xinrui.concurrency.example.atomic;

import com.xinrui.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @ClassName AtomicIntegerFieldUpdaterExample
 * @Description TODO
 * @Author kong
 * @Date 2019/5/23 15:30
 * @Version 1.0
 */
@Slf4j
@ThreadSafe
public class AtomicIntegerFieldUpdaterExample {

	private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterExample> updater =
			AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterExample.class,"count");

	private static AtomicIntegerFieldUpdaterExample example = new AtomicIntegerFieldUpdaterExample();

	/*
	* 更新字段必须使用 volatile 修饰  且不能是 static
	*
	* */
	@Getter
	public volatile int count = 100;

	public static void main(String[] args) {
		if(updater.compareAndSet(example,100,120)){
			log.info("update success 1 count={}",example.getCount());
		}

		if(updater.compareAndSet(example,100,120)){
			log.info("update success 2 count={}",example.getCount());
		}else {
			log.info("update faile 2 count={}",example.getCount());
		}
	}
}
