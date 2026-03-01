package recursion_038;

import java.util.Stack;

// 惊了
public class Code_05_ReverseStackWithRecursive {
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int num = bottomOut(stack);
        reverse(stack);
        stack.push(num);
    }

    // 栈底元素移除掉，上面的元素盖下来
    // 返回移除掉的元素
    public static int bottomOut(Stack<Integer> stack) {
        int ans = stack.pop();
        if (stack.isEmpty()) {
            return ans;
        } else {
            int last = bottomOut(stack);
            stack.push(ans);
            return last;
        }
    }
}
