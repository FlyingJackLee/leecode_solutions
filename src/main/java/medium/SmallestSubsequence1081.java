package medium;

import java.util.*;
import java.util.stream.Collectors;

public class SmallestSubsequence1081 {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();

        HashSet<Character> seen = new HashSet<>();

        // 记录某个字符出现的最后位置
        HashMap<Character, Integer> last_occurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            last_occurrence.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!seen.contains(c)) {
                // 如果当前值比stack顶部值小-保证最小
                // 并且顶部值在后面还有（通过最后出现位置判断） - 保证每一个都出现过
                // 也就是说当前值可以被替代，后面重新进行入栈
                while (!stack.empty() && c < stack.peek() && last_occurrence.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }

                seen.add(c);
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) sb.append(c.charValue());6
                
        return sb.toString();
    }
}
