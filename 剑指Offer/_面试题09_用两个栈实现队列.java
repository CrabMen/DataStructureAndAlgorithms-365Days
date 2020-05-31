/**
 * 维护两个栈，第一个栈存储元素，第二个栈用于辅助操作。
 * 
 * 根据栈的特性，第一个栈的底部元素是最后插入的元素，第一个栈的顶部元素是下一个被删除的元素。为了维护队列的特性，每次插入的元素应该在第一个栈的底部。因此每次插入元素时，若第一个栈内已经有元素，应将已有的全部元素依次弹出并压入第二个栈，然后将新元素压入第一个栈，最后将第二个栈内的全部元素依次弹出并压入第一个栈。经过上述操作，新插入的元素在第一个栈的底部，第一个栈内的其余元素的顺序和插入元素之前保持一致。
 * 
 * 删除元素时，若第一个栈非空，则直接从第一个栈内弹出一个元素并返回，若第一个栈为空，则返回 -1。
 * 
 * 另外维护队列的元素个数，用于判断队列是否为空。初始元素个数为 0。每次插入元素，元素个数加 1。每次删除元素，元素个数减 1。
 * 
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-3/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 */

class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2 = new Stack<>();
    int size;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = 0;

    }

    public void appendTail(int value) {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        stack1.push(value);
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        size++;
    }

    public int deleteHead() {
        if (size == 0)
            return -1;
        size--;
        return stack1.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such: CQueue obj = new
 * CQueue(); obj.appendTail(value); int param_2 = obj.deleteHead();
 */