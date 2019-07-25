package com.xinrui.javacore;

import java.util.Objects;

/**
 * @ClassName HashMapDemo
 * @Description TODO
 * @Author kong
 * @Date 2019/2/18 13:52
 * @Version 1.0
 */
public class HashMapDemo {
	public static void main(String[] args) {

		String key = "key";
		String value = "Value";
		int hashCode = Objects.hashCode(key) ^ Objects.hashCode(value);
		System.out.println(hashCode);

		Integer a = 1271,b=1271;
		System.out.println(a == b);

		try{
			throw new NullPointerException();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			System.out.println("error");
		}

	}
}
