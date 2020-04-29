 
 
 # 深度优先搜索（BFS）
 
 ``深度优先搜索（BFS）``在大多数情况下，我们在能使用 BFS 时也可以使用 DFS。但是有一个重要的区别：``遍历顺序``。
 
 与 BFS 不同，更早访问的结点可能不是更靠近根结点的结点。因此，你在 DFS 中找到的第一条路径可能不是最短路径。






### 模板 - 递归


```java
/*
 * Return true if there is a path from cur to target.
 */
boolean DFS(Node cur, Node target, Set<Node> visited) {
    return true if cur is target;
    for (next : each neighbor of cur) {
        if (next is not in visited) {
            add next to visted;
            return true if DFS(next, target, visited) == true;
        }
    }
    return false;
}
```
当我们递归地实现 DFS 时，似乎不需要使用任何栈。但实际上，我们使用的是由系统提供的隐式栈，也称为调用栈（Call Stack）。

如果你想找到最短路径呢？再添加一个参数来指示你已经找到的最短路径。





###  模板 II
递归解决方案的优点是它更容易实现。 但是，存在一个很大的缺点：如果递归的深度太高，你将遭受堆栈溢出。 在这种情况下，您可能会希望使用 BFS，或使用显式栈实现 DFS。

这里我们提供了一个使用显式栈的模板：

```java
/*
 * Return true if there is a path from cur to target.
 */
boolean DFS(int root, int target) {
    Set<Node> visited;
    Stack<Node> s;
    add root to s;
    while (s is not empty) {
        Node cur = the top element in s;
        return true if cur is target;
        for (Node next : the neighbors of cur) {
            if (next is not in visited) {
                add next to s;
                add next to visited;
            }
        }
        remove cur from s;
    }
    return false;
}
```
该逻辑与递归解决方案完全相同。 但我们使用 while 循环和栈来模拟递归期间的系统调用栈。 手动运行几个示例肯定会帮助你更好地理解它。