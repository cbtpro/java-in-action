package com.chenbitao.actioninjava.ip;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class CNIPCounter {

  /**
   * 需要检查这个链接是否可以访问，如果不能访问，请开代理再来执行程序
   */
  private final String CHNROUTES_URL = "https://raw.githubusercontent.com/misakaio/chnroutes2/master/chnroutes.txt";

  /**
   * 要存放在本地的路径和文件，请根据自己的实际情况来修改
   */
  private final String CHNROUTES_PATH = "E:\\";
  private final String CHNROUTES_FILENAME = "chnroutes.txt";

  private final String CHARSET = "UTF-8";

  private synchronized void download() throws MalformedURLException, IOException {
    FileUtils.copyURLToFile(new URL(CHNROUTES_URL), new File(CHNROUTES_PATH, CHNROUTES_FILENAME));
  }

  private List<String> read() throws IOException {
    File file = new File(CHNROUTES_PATH + CHNROUTES_FILENAME);
    List<String> lines = FileUtils.readLines(file, CHARSET);
    return lines;
  }

  private String getSubnetMaskCount(String content) {
    String pattern = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}/(\\d+)";
//		String pattern = "\\d+\\.\\d+\\.\\d+\\.\\d+/(\\d+)";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(content);
    if (m.find()) {
      return m.group(1);
    } else {
      return "0";
    }
  }

  public static void main(String[] args) throws MalformedURLException, IOException {
    CNIPCounter cnipcounter = new CNIPCounter();
    cnipcounter.download();
    List<String> lines = cnipcounter.read();
    Optional<Integer> ipCount = lines.stream().map(line -> {
      int subnetMask = Integer.valueOf(cnipcounter.getSubnetMaskCount(line));
      return subnetMask;
    }).reduce((acc, count) -> {
      if (count == 0) {
        return acc;
      }
      return (int) (acc + Math.pow(2, 32 - count));
    });
    System.out.println(ipCount.get());
  }

}
