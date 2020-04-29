 
 
 # 广度优先搜索（BFS）
 
 ``广度优先搜索（BFS）``的一个常见应用是找出从根结点到目标结点的``最短路径``,当然也可以完成``遍历``
 
 ### 那么为什么 BFS 算法中可以应用队列中呢?
 
 我们首先将根结点排入队列。然后在每一轮中，我们逐个处理已经在队列中的结点，并将所有邻居添加到队列中。值得注意的是，新添加的节点不会立即遍历，而是在下一轮中处理。结点的处理顺序与它们添加到队列的顺序是完全相同的顺序，即先进先出**（FIFO）**。
 这就是我们在 BFS 中使用队列的原因。与树的层序遍历类似，越是接近根结点的结点将越早地遍历。所以BFS可以用来找到根节点到目标节点的最短巨距离




### 模板 I

```java
/**
 * Return the length of the shortest path between root and target node.
 */
int BFS(Node root, Node target) {
    Queue<Node> queue;  // store all nodes which are waiting to be processed
    int step = 0;       // number of steps neeeded from root to current node
    // initialize
    add root to queue;
    // BFS
    while (queue is not empty) {
        step = step + 1;
        // iterate the nodes which are already in the queue
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            Node cur = the first node in queue;
            return step if cur is target;
            for (Node next : the neighbors of cur) {
                add next to queue;
            }
            remove the first node from queue;
        }
    }
    return -1;          // there is no path from root to target
}
```

* 如代码所示，在每一轮中，队列中的结点是等待处理的结点。
* 在每个更外一层的 while 循环之后，我们距离根结点更远一步。变量 step 指示从根结点到我们正在访问的当前结点的距离。


### 模板 II

有时，确保我们永远不会访问一个结点两次很重要。否则，我们可能陷入无限循环。如果是这样，我们可以在上面的代码中添加一个哈希集来解决这个问题。这是修改后的伪代码：

```java
/**
 * Return the length of the shortest path between root and target node.
 */
int BFS(Node root, Node target) {
    Queue<Node> queue;  // store all nodes which are waiting to be processed
    Set<Node> used;     // store all the used nodes
    int step = 0;       // number of steps neeeded from root to current node
    // initialize
    add root to queue;
    add root to used;
    // BFS
    while (queue is not empty) {
        step = step + 1;
        // iterate the nodes which are already in the queue
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            Node cur = the first node in queue;
            return step if cur is target;
            for (Node next : the neighbors of cur) {
                if (next is not in used) {
                    add next to queue;
                    add next to used;
                }
            }
            remove the first node from queue;
        }
    }
    return -1;          // there is no path from root to target
}

```

有两种情况你不需要使用哈希集：
* 你完全确定没有循环，例如，在树遍历中；
* 你确实希望多次将结点添加到队列中。








 /**
  * 
 */

/**
 * Return the length of the shortest path between root and target node.
 */
// int BFS(Node root, Node target) {
//     Queue<Node> queue;  // store all nodes which are waiting to be processed
//     Set<Node> used;     // store all the used nodes
//     int step = 0;       // number of steps neeeded from root to current node
//     // initialize
//     add root to queue;
//     add root to used;
//     // BFS
//     while (queue is not empty) {
//         step = step + 1;
//         // iterate the nodes which are already in the queue
//         int size = queue.size();
//         for (int i = 0; i < size; ++i) {
//             Node cur = the first node in queue;
//             return step if cur is target;
//             for (Node next : the neighbors of cur) {
//                 if (next is not in used) {
//                     add next to queue;
//                     add next to used;
//                 }
//             }
//             remove the first node from queue;
//         }
//     }
//     return -1;          // there is no path from root to target
// }
