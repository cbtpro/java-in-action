/**
 * 
 */
package com.chenbitao.actioninjava.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cbtpro
 * {@link} https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

  private List<String> result;

  public List<String> generateParentheses(int n) {
    result = new ArrayList<>();
    generate(0, 0, n, "");
    return result;
  }

  private void generate(int left, int right, int n, String s) {
    if (left == n && right == n) {
      result.add(s);
      return;
    }
    if (left < n) {
      generate(left + 1, right, n, s + "(");
    }
    if (left > right && right < n) {
      generate(left, right + 1, n, s + ")");
    }
  }
  public static void main(String[] args) {
    GenerateParentheses gp = new GenerateParentheses();
    System.out.println(gp.generateParentheses(3));
  }
}
