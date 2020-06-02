import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front
 * 的均摊时间复杂度都是O(1)。
 * 
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 
 * 示例 1：
 * 
 * 输入: ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]] 输出: [null,null,null,2,1,2] 示例 2：
 * 
 * 输入: ["MaxQueue","pop_front","max_value"] [[],[],[]] 输出: [null,-1,-1]  
 * 
 * 限制：
 * 
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000 1 <= value <= 10^5
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

/**
 * 
 * 使用 \mathcal{O}(1)O(1)
 * 时间复杂度来获得队列或栈的最大值或者最小值，往往需要使用一个辅助的数据结构实现，具体选用何种数据结构需要在做题过程中总结规律。
 * 
 * 相关题目（实现 \mathcal{O}(1)O(1) 复杂度）：
 * 
 * 面试题 03.02. 栈的最小值（难度：⭐⭐）（使用辅助栈）
 * 
 * 146. LRU缓存机制 （难度：⭐⭐⭐⭐）（使用有序字典）
 * 
 * 716. 最大栈（难度：⭐⭐⭐）（使用辅助栈）
 * 
 * 作者：z1m
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/ru-he-jie-jue-o1-fu-za-du-de-api-she-ji-ti-by-z1m/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 * 
 */

class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);

    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;

        int temp = queue.poll();

        if (deque.peek().equals(temp))
            deque.poll();

        return temp;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such: MaxQueue obj =
 * new MaxQueue(); int param_1 = obj.max_value(); obj.push_back(value); int
 * param_3 = obj.pop_front();
 */