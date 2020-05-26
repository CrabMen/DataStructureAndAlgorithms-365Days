import circle.CircleDeque;
import circle.CircleQueue;

public class Main {

	public static void main(String[] args) {

		testStack();
		testQueue();
		testDeque();
		testCircleQueue();
		testCircleDeque();

	}

	static void testStack() {
		Stack<Integer> stack = new Stack<>();
		stack.push(11);
		stack.push(22);
		stack.push(33);
		stack.push(44);
		System.out.println("\n************************testStack************************\n");

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	static void testQueue() {
		Queue<Integer> queue = new Queue<>();
		queue.enQueue(11);
		queue.enQueue(22);
		queue.enQueue(33);
		queue.enQueue(44);
		System.out.println("\n************************testQueue************************\n");

		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
	}

	static void testDeque() {

		Deque<Integer> queue = new Deque<>();
		queue.enQueueFront(11);
		queue.enQueueFront(22);
		queue.enQueueRear(33);
		queue.enQueueRear(44);
		System.out.println("\n************************testDeque************************\n");

		/* 尾 44 33 11 22 头 */
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueueRear());
		}
	}

	static void testCircleQueue() {
		CircleQueue<Integer> queue = new CircleQueue<Integer>();
		// 0 1 2 3 4 5 6 7 8 9
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		// null null null null null 5 6 7 8 9
		for (int i = 0; i < 5; i++) {
			queue.deQueue();
		}
		// 15 16 17 18 19 5 6 7 8 9
		for (int i = 15; i < 20; i++) {
			queue.enQueue(i);
		}

		System.out.println("\n************************testCircleQueue************************\n");

		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
		System.out.println(queue);
	}

	static void testCircleDeque() {
		CircleDeque<Integer> queue = new CircleDeque<>();
		// 头5 4 3 2 1 100 101 102 103 104 105 106 8 7 6 尾

		// 头 8 7 6 5 4 3 2 1 100 101 102 103 104 105 106 107 108 109 null null 10 9 尾
		for (int i = 0; i < 10; i++) {
			queue.enQueueFront(i + 1);
			queue.enQueueRear(i + 100);
		}

		// 头 null 7 6 5 4 3 2 1 100 101 102 103 104 105 106 null null null null null
		// null null 尾
		for (int i = 0; i < 3; i++) {
			queue.deQueueFront();
			queue.deQueueRear();
		}

		// 头 11 7 6 5 4 3 2 1 100 101 102 103 104 105 106 null null null null null null
		// 12 尾
		queue.enQueueFront(11);
		queue.enQueueFront(12);
		System.out.println("\n************************testCircleDeque************************\n");

		System.out.println(queue);
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueueFront());
		}
	}

}
