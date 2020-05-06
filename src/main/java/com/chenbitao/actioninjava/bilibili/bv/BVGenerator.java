package com.chenbitao.actioninjava.bilibili.bv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class BVGenerator {

//	private static String chars = "ptoZ0gFql1JejH26kSdEyPIiBR3XnTUa5m4vrYsLVwGzx8uKQ9bAWNOfchCDM7";
	private static String chars = "59BGE2X6Q0UZ4MYTR1FVL8PO7ICKHANSJWD3"; // 36

	public static String shuffle() {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] c = chars.toCharArray();
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < c.length; i++) {
			list.add(c[i]);
		}
		Collections.shuffle(list);
		StringBuffer sb = new StringBuffer("");
		list.stream().forEach(item -> sb.append(item.toString()));
		System.out.println(chars.length());
		return sb.toString();
	}

	@SuppressWarnings("unused")
	private static long getCurrentTime() {
		return System.currentTimeMillis();
	}

	public static void main(String[] args) {
//		System.out.println(shuffle());
		System.out.println(generateShortUuid());
	}

	public static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
//		System.out.println(uuid);
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars.charAt(x % 0x24));
		}
		return shortBuffer.toString();

	}
}