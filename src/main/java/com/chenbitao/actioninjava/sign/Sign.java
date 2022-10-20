package com.chenbitao.actioninjava.sign;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Base64;

public class Sign {
	public static void main(String[] args) throws Exception {
		// 生成 RSA 密钥对
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		SecureRandom random = new SecureRandom();
		int byteLen = 1024;
		random.nextBytes(new byte[byteLen]);
		keyGen.initialize(byteLen, random);
		KeyPair keyPair = keyGen.genKeyPair();

		Signature signature = Signature.getInstance("MD5withRSA");
		signature.initSign(keyPair.getPrivate());
		// 待签名字符串
		String content = "45678a{\"acctNo\":\"123\",\"cardNo\":\"123\",\"msgCheckCode\":\"123\",\"userId\":\"12321321\"}";
		byte[] data = content.getBytes("UTF-8");
		// 数据签名
		signature.update(data);
		byte[] digest = signature.sign();
		Base64.Encoder encoder = Base64.getEncoder();
		System.out.println("签名后的字符串：" + encoder.encodeToString(digest));

		// 数据验签
		signature.initVerify(keyPair.getPublic());
		signature.update(data);
		System.out.println("验签结果:" + signature.verify(digest));
	}
}
