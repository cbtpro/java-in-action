/**
 * 
 */
package com.chenbitao.actioninjava;

/**
 * @author cbtpro
 *
 */
public class TryCatchFinally {

	public static void main(String[] args) {
		try {
			System.out.println("hello");
			throw new Exception("bad");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finally");
		}
	}
}
