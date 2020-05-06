import java.util.Stack;

/**
 * 
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * push(x) —— 将元素 x 推入栈中。 pop() —— 删除栈顶的元素。 top() —— 获取栈顶元素。 getMin() ——
 * 检索栈中的最小元素。 示例:
 * 
 * MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
 * minStack.push(-3); minStack.getMin(); --> 返回 -3. minStack.pop();
 * minStack.top(); --> 返回 0. minStack.getMin(); --> 返回 -2.
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

class MinStack {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {

        /**
         * 注意:下方的equals 使用 == 进行判断的时候,代码提交报错 见图片001.png
         * 
         * 原因如下: Java中 Integer在常量池中的存储范围为[-128,127]，127在这范围内，因此是直接存储于常量池的，
         * 而超过127的值不在这范围内，所以会在堆内存中创建一个新的对象来保存这个值， 所以m，n分别指向了两个不同的对象地址，故而导致了不相等。
         * 
         * 关联知识点:
         * https://blog.csdn.net/lcsy000/article/details/82782864
         */
        if (mainStack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        /**
         * 因为该返会返回值为int类型,需要对栈空的情况做处理,抛异常或者返会0
         */
        if (mainStack.isEmpty()) {
            return 0;
        }
        return mainStack.peek();
    }

    public int getMin() {
        /**
         * 因为该返会返回值为int类型,需要对栈空的情况做处理,抛异常或者返会0
         */
        if (minStack.isEmpty()) {
            return 0;
        }
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */