package com.chenbitao.actioninjava.bilibili.av;

import java.io.IOException;

public class AVGeneratorTest extends Thread {

	@Override
	public void run() {
		AVGenerator avg = new AVGenerator();
		try {
			for (int i = 0; i < 2000000; i++) {
				avg.generator();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AVGeneratorTest test = new AVGeneratorTest();
		AVGeneratorTest test1 = new AVGeneratorTest();
		AVGeneratorTest test2 = new AVGeneratorTest();
		AVGeneratorTest test3 = new AVGeneratorTest();
		test.start();
		test1.start();
		test2.start();
		test3.start();
	}
}
