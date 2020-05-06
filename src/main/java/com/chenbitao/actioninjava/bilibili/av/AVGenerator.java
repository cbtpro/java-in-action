package com.chenbitao.actioninjava.bilibili.av;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class AVGenerator {

	private String filePath = "E:\\av.txt";

	public String generator() throws IOException {
		return writeLocalAv(filePath);
	}

	private synchronized static String writeLocalAv(String filePath) throws IOException {
		Integer newAv = null;
		File file = new File(filePath);
		File parentFile = file.getParentFile();
		if (!parentFile.exists()) {
			parentFile.mkdir();
		}
		if (!file.exists()) {
			file.createNewFile();
		}
		Integer oldAv = Integer.parseInt(readLastLine(file, "UTF-8").trim(), 16);
		newAv = oldAv + 1;
		String bv = Integer.toHexString(newAv);
		if (newAv != null) {
			FileWriter fw = new FileWriter(filePath, true);
			fw.write(bv + "\n");
			fw.flush();
			fw.close();
//			System.out.println(bv);
		}
		return bv;
	}

	public synchronized static String readLastLine(File file, String charset) throws IOException {
		if (!file.exists() || file.isDirectory() || !file.canRead()) {
			return null;
		}
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "r");
			long len = raf.length();
			if (len == 0L) {
				return "";
			} else {
				long pos = len - 1;
				while (pos > 0) {
					pos--;
					raf.seek(pos);
					if (raf.readByte() == '\n') {
						break;
					}
				}
				if (pos == 0) {
					raf.seek(0);
				}
				byte[] bytes = new byte[(int) (len - pos)];
				raf.read(bytes);
				if (charset == null) {
					return new String(bytes);
				} else {
					return new String(bytes, charset);
				}
			}
		} catch (FileNotFoundException e) {
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (Exception e2) {
				}
			}
		}
		return "0";
	}
}
