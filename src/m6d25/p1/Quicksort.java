package m6d25.p1;

public class Quicksort {

	public static void main(String[] args) {
		int[] array = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		quicksort(array, 0, 0, 10);
		printArray(array, 0, 10);
	}

	private static void quicksort(int[] array, int key, int low, int high) {
		if (low > array.length - 1 || high < 0) {
			return;
		}
		if (low < high && key <= high && key >= low) {
			int keyValue = array[key];
			int i = low, j = high;
			while (i < j) {
				// 错误的逻辑，警示自己
				// while(i < key && array[i] <= array[key]) {
				while (i < key && array[i] <= keyValue) {
					i++;
				}
				if (i < key) {
					array[key] = array[i];
					key = i;
				}
				// 错误的逻辑，警示自己
				// while(key < j && array[j] >= array[key]) {
				while (key < j && array[j] >= keyValue) {
					j--;
				}
				if (key < j) {
					array[key] = array[j];
					key = j;
				}
			}
			if (array[key] != keyValue) {
				array[key] = keyValue;
			}
			quicksort(array, low, low, key - 1); // 0, 1, 2, 3, 4排好一次序后，key为0
			quicksort(array, key + 1, key + 1, high);
		}
	}

	private static void printArray(int[] array, int low, int high) {
		for (int i = low; i <= high; i++) {
			if (i == high) {
				System.out.println(array[i] + "]");
			} else if (i == low) {
				System.out.print("[" + array[i] + ", ");
			} else {
				System.out.print(array[i] + ", ");
			}
		}
	}
}