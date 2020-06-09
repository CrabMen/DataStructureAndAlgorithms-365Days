
import java.util.Arrays;

import com.sort.Sort;
import com.tools.Asserts;
import com.tools.Integers;
import com.sort.cmp.BubbleSort1;
import com.sort.cmp.BubbleSort2;
import com.sort.cmp.BubbleSort3;
import com.sort.cmp.SelectionSort;

public class Main {
	public static void main(String[] args) {
		Integer[] array = { 7, 3, 5, 8, 6, 7, 4, 5, 10, 12, 13 };
		testSorts(array, new BubbleSort1<>(), new BubbleSort2<>(), new BubbleSort3<>(), new SelectionSort<>());
	}

	static void testSorts(Integer[] array, Sort... sorts) {
		for (Sort sort : sorts) {
			Integer[] newArray = Integers.copy(array);
			sort.sort(newArray);
			Asserts.test(Integers.isAscOrder(newArray));
		}
		Arrays.sort(sorts);

		System.out.println("------------------------------------------------------------------");

		for (Sort sort : sorts) {
			System.out.println(sort);
		}
	}

}