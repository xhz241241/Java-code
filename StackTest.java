package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {
    public boolean isValid(String s) {
        // 0. 判断特殊情况
        if (s.isEmpty()) {
            return true;
        }
        // 1. 创建一个空栈
        Stack<Character> stack = new Stack<>();
        // 2. 遍历字符串, 遇到右括号就入栈
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
                continue;
            }
            //得先判断栈中是否为空, 如果为空说明没有右括号 直接返回false
            if (stack.isEmpty()) {
                return false;
            }
            // 3. 遇到左括号就拿栈顶的元素与之比较
            char top = stack.pop();
            if (c == ')' && top == '(') {
                continue;
            }
            if (c == '}' && top == '{') {
                continue;
            }
            if (c == ']' && top == '[') {
                continue;
            }
            //如果没有匹配的if语句说明括号不匹配
            return false;
        }
        // 4. 如果字符到达最后一个并且栈中没有元素了 就返回true否则返回false
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean backspaceCompare(String S, String T) {
        // 0. 先创建两个栈
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        // 1. 遍历ST栈, 如果遇到字符就入栈, 遇到#就出栈, 直到遍历完毕
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c != '#') {
                sStack.push(c);
            } else {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            }
        }
        for (int j = 0; j < S.length(); j++) {
            char h = T.charAt(j);
            if (h != '#') {
                tStack.push(h);
            } else {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            }
        }
        // 2. 遍历完后比较两个栈的元素是否相等, 如果相等返回true 不等返回false
        if (sStack.size() != tStack.size()) {
            return false;
        }
        while (!sStack.isEmpty() && !tStack.isEmpty()) {
            if (sStack.pop() != tStack.pop()) {
                return false;
            }
        }
        return true;
    }

    class MinStack {

        private Stack<Integer> A = new Stack<>();
        private Stack<Integer> B = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            A.push(x);
            if (B.isEmpty()) {
                B.push(x);
                return;
            }
            int min = B.peek();
            if (x < min) {
                min = x;
            }
            B.push(min);
        }

        public void pop() {
            if (A.isEmpty()) {
                return;
            }
            A.pop();
            B.pop();
        }

        public int top() {
            if (A.isEmpty()) {
                return -1;
            }
            return A.peek();
        }

        public int getMin() {
            if (B.isEmpty()) {
                return -1;
            }
            return B.peek();
        }
    }
}

class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while(q.peek() < t-3000){
            q.poll();
        }
        return q.size();
    }
}