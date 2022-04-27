package com.chenbitao.actioninjava;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        BitCalc bc = new BitCalc();
        int a = 1110;
        int b = 100;
        System.out.println(bc.and(a, b));
        System.out.println(bc.and(1111, 100));
        System.out.println(a & b);
        System.out.println();
        /**
         * 4 转换成二进制 100
         * 4 转换成二进制 100
         * 100
         * 100
         * 100 再转回10进制等于4
         * 1111 转成二进制 ‭010001010111‬
         * 100 转成二进制    ‭01100100‬
         * ‭010001010111
         * 000001100100
         * 000001000100 再转成二进制 68
         * 按位并(按位与)由什么用？
         * 上面两个例子看起来没什么用，下面的例子再看一看
         */

        int c = 65535; // 二进制1111 1111 1111 1111
        int d = 255; // 二进制1111 1111
        System.out.println(bc.and(c, d)); //
        System.out.println();
        /**
         * 1111111111111111
         * 0000000011111111
         * 0000000011111111 再转成二进制 255
         * 可以把前8位清空保留后8位，
         */

        // 八进制
        int e = 0177777; // 8进制表示的十进制的65535
        int f = 0377; // 8进制表示的十进制的255
        System.out.println(bc.and(e, f));
        System.out.println();

        // 十六进制
        int g = 0xFFFF; // 8进制表示的十进制的65535
        int h = 0xFF; // 8进制表示的十进制的255
        System.out.println(bc.and(g, h));
        System.out.println(0xFFFF & 0xFF);
    }
}