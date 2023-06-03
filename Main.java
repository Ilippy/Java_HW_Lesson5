import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(isCorrectParentheses("()")); // true
        System.out.println(isCorrectParentheses("(")); // false
        System.out.println(isCorrectParentheses("())")); // false
        System.out.println(isCorrectParentheses("((()))")); // true
        System.out.println(isCorrectParentheses("()[]{}<>")); // true
        System.out.println(isCorrectParentheses("([)]")); // false
        System.out.println(isCorrectParentheses("][]")); // false
        System.out.println("[]{<()[]<>>}"); // true
    }

    /**
     * Дана последовательность скобочек. Проверить, что она является корректной.
     */
    static boolean isCorrectParentheses(String parentheses) {
        // Нужно завести маппинг скобочек либо ( -> ), либо ) -> ( и так для каждой пары
        // Нужно использовать Deque.
        // Открывающуюся скобку вносим в Deque (insertFirst)
        // Если встретилась закрывающаяся скобка, то (Deque#pollFirst) и сравниваем ее с встретившейся

        Map<Character, Character> hashmap = new HashMap<>();
        hashmap.put(')', '(');
        hashmap.put(']', '[');
        hashmap.put('}', '{');
        hashmap.put('>', '<');

        Deque<Character> stack = new LinkedList<>();
        for (char c : parentheses.toCharArray()) {
            if (hashmap.containsValue(c)) {
                stack.addFirst(c);
//                System.out.println(stack + " -> " + parentheses);
            } else if (hashmap.containsKey(c)) {
                if (stack.isEmpty() || stack.pollFirst() != hashmap.get(c)) {
//                    System.out.println(stack " -> " + parentheses +" return false");
                    return false;

                }
            }
        }
        return stack.isEmpty();
    }
}
