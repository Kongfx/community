package com.xinrui.multithread.chat02;

/**
 * @ClassName LoginServlet
 * @Description TODO
 * @Author kong
 * @Date 2019/2/25 15:30
 * @Version 1.0
 */
public class LoginServlet {

	private static String userName;
	private static String password;

	public static void doPost(String usernm,String pwd){
		try {
			userName = usernm;
			if(usernm.equals("a")){
				Thread.sleep(2000);
			}
			password = pwd;
			System.err.println(Thread.currentThread().getName()+";;;userName = "+usernm +";passWord = "+ password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}



	}

}
