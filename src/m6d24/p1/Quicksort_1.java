package m6d24.p1;

public class Quicksort_1 {
	// 快速排序
	static void quick_sort(int s[], int l, int r) {
		if (l < r) {
			// Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
			int i = l, j = r, x = s[l];
			while (i < j) {
				while (i < j && s[j] >= x)
					// 从右向左找第一个小于x的数
					j--;
				if (i < j)
					s[i++] = s[j];

				while (i < j && s[i] < x)
					// 从左向右找第一个大于等于x的数
					i++;
				if (i < j)
					s[j--] = s[i];
			}
			s[i] = x;
			quick_sort(s, l, i - 1); // 递归调用
			quick_sort(s, i + 1, r);
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		quick_sort(array, 0, array.length-1);
		printArray(array);
	}
	
	private static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(i == array.length - 1) {
				System.out.println(array[i] + "]");
			} else if(i == 0) {
				System.out.print("[" + array[i] + ", ");
			} else {
				System.out.print(array[i] + ", ");
			}
		}
	}
}