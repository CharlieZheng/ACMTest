package m6d24.p1;
/**
 * 被忽略的一种情况导致的错误：
 *     当数组为{5, 6, 8, 7}这种情况时，其中5为枢轴，则在该代码中
 *     语句判断中if(array[key] != keyValue)成立，故不再对该数组进行
 *     排序，则得到还是原来的结果
 * @author hanrong
 *
 */
public class Quicksort {

	public static void main(String[] args) {
//		int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//		int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//		int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//		int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//		int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//		int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//		int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//		int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//		int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int[] array = new int[]{9, 10, 8, 7, 6, 5};
//		int[] array = new int[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10};
//		quicksort(array, 0, 0, 10);
//		printArray(array, 0, 10);
		quicksort(array, 0, 0, 5);
		printArray(array, 0, 5);
	}
	
	private static void quicksort(int[] array, int key, int low, int high) {
		if(low > array.length - 1 || high < 0) {
			return;
		}
		if(low < high && key <= high && key >= low) {
			// 判断排序是否完成的方法2，尚未认真想过是否能用key值不变来判断，先注释
//			int originalKey = key;
			int keyValue = array[key];
			int i = low, j = high;
			while(i < j) {
				// 错误的逻辑，警示自己
//				while(i < key && array[i] <= array[key]) {
				while(i < key && array[i] <= keyValue) {
					i++;
				}
				// 每次给下标为key的数组项赋值时，都在之前的while循环中
				// 确保了给key项赋值的值不会等于keyValue，故可根据key项值
				// 是否发生改变来判断排序是否已经完成
				if(i < key) {
					array[key] = array[i];
					key = i;
				}
				// 错误的逻辑，警示自己
//				while(key < j && array[j] >= array[key]) {
				while(key < j && array[j] >= keyValue) {
					j--;
				}
				if(key < j) {
					array[key] = array[j];
					key = j;
				}
			}
			// key项发生替换，排序尚未完成
			if(array[key] != keyValue) {
				array[key] = keyValue;
//			}
				System.out.println("******************* 开始 *******************");
				System.out.println("before key = [" + key + "]");
//				printArray(array, low, high);
				quicksort(array, low, low, key - 1); // 0, 1, 2, 3, 4排好一次序后，key为0
				System.out.println("after key = [" + key + "]");
				System.out.println("******************* 结束 *******************");
				quicksort(array, key + 1, key + 1, high);
			}
		}
	}
	
	private static void printArray(int[] array, int low, int high) {
		for(int i = low; i <= high; i++) {
			if(i == high) {
				System.out.println(array[i] + "]");
			} else if(i == low) {
				System.out.print("[" + array[i] + ", ");
			} else {
				System.out.print(array[i] + ", ");
			}
		}
	}
}