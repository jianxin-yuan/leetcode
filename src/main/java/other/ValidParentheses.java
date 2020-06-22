package other;

import java.util.Stack;

/**
 * @author yuan
 * @date 2020/3/28 11:17 上午
 *
 * 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                switch (c) {
                    case '}':
                        if (stack.peek() == '{') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                        break;
                    case ']':
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                        break;
                    case ')':
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                        break;
                    default:
                        stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }
}
