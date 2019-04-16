package com.xinrui.multithread.chat02;

/**
 * @ClassName LoginUser
 * @Description TODO
 * @Author kong
 * @Date 2019/2/25 15:20
 * @Version 1.0
 */
public class LoginUser implements Runnable {
	private String userName;
	private String passWord;

	public LoginUser(String userName,String passWord){
		this.userName = userName;
		this.passWord = passWord;
	}
	public LoginUser(){
	}


	@Override
	public void run() {
		LoginServlet.doPost(userName,passWord);
	}
	/*
	* 	main end
		Thread-1;;;userName = b;passWord = ccc
		Thread-2;;;userName = d;passWord = ccc
		Thread-3;;;userName = c;passWord = ccc
		Thread-0;;;userName = a;passWord = aaa
	* */
	public static void main(String[] args) {
		Thread t1 = new Thread(new LoginUser("a","aaa"));
		Thread t2 = new Thread(new LoginUser("b","bbb"));
		Thread t3 = new Thread(new LoginUser("d","ddd"));
		Thread t4 = new Thread(new LoginUser("c","ccc"));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		System.out.println("main end");
	}

}
