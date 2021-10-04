package com.chenbitao.actioninjava.algorithm;

/**
 * 求 26个字母任意3个字母的所有组合
 */
public class Print{
	private static int num = 3; //需要组合的字母个数
	private static char[] arr = {0,0,0};
	/**
	 * [dfsShow 深度遍历]
	 * @param deep  [第几层]
	 * @param index [该层遍历的字符的起始索引]
	 */
	private  static void dfsShow(int deep, int index){
		if(deep == num){ //达到目标层级 打印
			for(char c : arr){
				System.out.print(c);
			}
			System.out.println("");
			return;
		}
		for(int i = index; i < 26 - num + 1 + deep; i++){ //该层可以遍历的字符
			arr[deep] = (char)(65+i);
			dfsShow(deep+1, i + 1); //下一层的起始索引是这一层的当前字母索引的下一个
		}
	}
	public static void main(String[] args){
			dfsShow(0,0);
	}
}