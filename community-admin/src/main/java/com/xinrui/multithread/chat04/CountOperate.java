package com.xinrui.multithread.chat04;

/**
 * @ClassName CountOperate
 * @Description TODO
 * @Author kong
 * @Date 2019/2/25 16:27
 * @Version 1.0
 */
public class CountOperate {

//	构造器  begin;;thread current name = main;this.getName = Thread-0;构造器  end
//	main end
//	run begin;  ;thread current name = AA ;this.getName = Thread-0 ;run end
	public static void main(String[] args) {
		Ru r = new Ru();
		Thread t1 = new Thread(r);
		t1.setName("AA");
		t1.start();
		System.out.println("main end");
	}
}

class Ru extends Thread{
	public Ru(){
		StringBuffer sb = new StringBuffer("构造器  begin;");
		sb.append(";thread current name = "+Thread.currentThread().getName())
				.append(";this.getName = " + this.getName())
				.append(";构造器  end");
		System.out.println(sb.toString());
	}

	@Override
	public void run() {
		super.run();
		StringBuffer sb = new StringBuffer("run begin; ");
		sb.append(" ;thread current name = "+Thread.currentThread().getName())
				.append(" ;this.getName = " + this.getName())
				.append(" ;run end");
		System.out.println(sb.toString());
	}
}