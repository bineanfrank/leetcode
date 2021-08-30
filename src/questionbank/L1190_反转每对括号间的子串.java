package questionbank;

import java.util.ArrayDeque;
import java.util.Deque;

public class L1190_反转每对括号间的子串 {

    public static void main(String[] args) {

    }

//    public String reverseParentheses(String s) {
//        if (s == null || s.trim().length() <= 0) return s;
//        Deque<Character> stack = new ArrayDeque<>();
//        Deque<String> strings = new ArrayDeque<>();
//        String tmp = "";
//        int i = 0;
//        while (i < s.length()) {
//            char c = s.charAt(i);
//            while (c != '(' && c != ')') {
//                tmp += c;
//                i++;
//                c = s.charAt(i);
//            }
//            strings.push(tmp);
//            tmp = "";
//            if (c == '(') {
//                stack.push(s.charAt(i));
//            } else {
//
//            }
//            i++;
//        }
//    }
}
