package Chapter02.Section05;

import java.util.Arrays;
import java.util.Comparator;

// 根据下述博客理解
// http://shmilyaw-hotmail-com.iteye.com/blog/2275113
public class S2_5_19 {
	private static int getKendallTau(Comparable[] a, Comparable[] b) {
		int n = a.length;
		int[] ainv = new int[n];
		for (int i = 0; i < n; i++)
			ainv[(int) a[i]] = i;

		int[] binv = new int[n];
		for (int i = 0; i < n; i++)
			binv[i] = ainv[(int) b[i]];

		return getInversions(binv);
	}

	private static int getInversions(int[] binv) {
		int counter = 0;
		for (int i = 1; i < binv.length; i++) {
			for (int j = i; j > 0 && binv[j] < binv[j - 1]; j--) {
				int temp = binv[j];
				binv[j] = binv[j - 1];
				binv[j - 1] = temp;
				counter++;// 插入排序每交换一次，就存在一对逆序数
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = { 0, 3, 1, 6, 2, 5, 4 };
		Integer[] b = { 1, 0, 3, 6, 4, 2, 5 };

		System.out.println(getKendallTau(a, b));
	}

}
