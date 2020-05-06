package com.chenbitao.actioninjava;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		Random random = new Random();
		int num = random.nextInt(2);
		if (num == 0) {
			System.out.println("Hello");
		} else {
			System.out.println("World");
		}
	}
}

