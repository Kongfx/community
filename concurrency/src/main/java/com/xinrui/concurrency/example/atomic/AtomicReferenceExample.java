package com.xinrui.concurrency.example.atomic;

import com.xinrui.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName AtomicReferenceExample
 * @Description TODO
 * @Author kong
 * @Date 2019/5/23 15:25
 * @Version 1.0
 */
@Slf4j
@ThreadSafe
public class AtomicReferenceExample {

	private static AtomicReference<Integer> count = new AtomicReference<Integer>(0);

	public static void main(String[] args) {
		count.compareAndSet(0,2); // 2
		count.compareAndSet(0,1); // no
		count.compareAndSet(1,3); // no
		count.compareAndSet(2,4); // 4
		count.compareAndSet(3,5); // no
		log.info("count={}",count);
	}

}
