package com.xinrui.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @ClassName ConvertString_6_N
 * @Description TODO
 * @Author kong
 * @Date 2019/5/28 22:34
 * @Version 1.0
 */
@Slf4j
public class ConvertString_6_N {

	/*将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

	比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

	L   C   I   R
	E T O E S I I G
	E   D   H   N
	之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

	请你实现这个将字符串进行指定行数变换的函数：

	string convert(string s, int numRows);
	示例 1:

	输入: s = "LEETCODEISHIRING", numRows = 3
	输出: "LCIRETOESIIGEDHN"
	示例 2:

	输入: s = "LEETCODEISHIRING", numRows = 4
	输出: "LDREOEIIECIHNTSG"
	解释:

	L     D     R
	E   O E   I I
	E C   I H   N
	T     S     G*/


	public static String convert(String s, int numRows) {
		char[][] con = new char[][]{};
		int i = 0,j = 0,index,len = s.length();
		boolean f = true;
		for(index = 0; index <= len ; index++){
			if(i > numRows){
				i -= 1;
				j += 1;
			}
			if(i<=0){
				j = 0;
				i += 1;
			}
			con[i][j] = s.charAt(index);
		}
		log.info("con={}",con);
		StringBuffer sb = new StringBuffer(con.toString());
		return sb.toString();
	}

	public static void main(String[] args) {
//		convert("LEETCODEISHIRING",3);
		String s = "LEETCODEISHIRING";
		char[][] chars = {};
		chars[0][1] = 'a';
		Arrays.toString(chars);
	}



}
