package com.chenbitao.actioninjava;

import java.util.Scanner;

public class MyCalendar {

    public static void main(String[] args) {

        // System.out.println(getTotalDays(2017,3));
        printCalendar();

    }

    public static void printCalendar() {
//        System.out.println("请输入4位年份");
//        Scanner input = new Scanner(System.in);
//        int year = input.nextInt();
//        System.out.println("请输入月份");
//        int month = input.nextInt();
        int year = 2022;
        int month = 4;

        System.out.println("\t\t\t" + year + "," + month);
        System.out.println("----------------------------------------------------------");
        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");

        // 1号前边先打印几个 \t,打印几个呢 应该是getTotalDays(年,月)
        int spaces = getTotalDays(year, month) % 7;
        for (int i = 0; i < spaces; i++) {
            System.out.print("\t");
        }

        int days = getDaysOfMonth(year, month);
        for (int i = 1; i <= days; i++) {
            System.out.print(i + "\t");
            if ((i + spaces) % 7 == 0) {
                System.out.println();
            }
        }
    }

    // 定义一个方法,返回1905年1.1 到指定年份指定月份的上一个月月底,一共有多少天? 2017 4
    // 1905.1.1 - 2017.3.31 总天数
    // 1905.1.1 - 2016.12.31 + 会求!
    // 2017.1.1 - 2017.3.31 会求!
    private static int getTotalDays(int year, int month) {
        return getDaysFrom1905(year) + getDaysThisYear(year, month);
    }

    // 定义一个方法,返回指定年份1月1日 到 指定月份的前一个月月底的天数, 2017.4 2017.1.1-2017.3.31
    public static int getDaysThisYear(int year, int month) {// 2017.4
        // 一共 , 累加 循环 for
        int sum = 0;
        for (int i = 1; i < month; i++) {
            sum += getDaysOfMonth(year, i);
        }
        return sum;
    }

    // 定义一个方法; 返回指定年份,指定月份的天数1842 1 3 5 7 8 10 12
    // 4 6 9 11 --- 30 2 -- 平年 28 闰年29年
    private static int getDaysOfMonth(int year, int month) {
        /*
         * if(month == 1 ||month == 3 ||month == 5 ||month == 7 ||month == 8 ||month ==
         * 10 ||month == 12){ return 31; }else if(month == 4||month == 6 ||month == 9
         * ||month == 11){ return 30; }else if(month == 2){ //需要对当前年份进行判断
         * if(isRun(year)){ return 29; }else{ return 28; } }else{ return 0; }
         */
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isRun(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }

    // 从1905年 到指定年份的上一年的年底一共多少天;2017 1905.1.1 - 2016.12.31
    // 求和 -- 累加 -- 循环 1905-365 1906-365 1907-365 1908-366
    private static int getDaysFrom1905(int year) {// 1909
        int sum = 0;
        for (int i = 1905; i < year; i++) {
            // 如果闰年 += 366 1905 1906 1907 1908
            if (isRun(i)) {
                // 是
                sum += 366;
            } else {
                sum += 365;
            }
        }
        return sum;
    }

    // 定义一个方法,判断某个年份是否是闰年,如果是返回true,否则返回false;
    private static boolean isRun(int year) {
        // 2016 是 2017 不是 2000 是 2100 不是
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }
}