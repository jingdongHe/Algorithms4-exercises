package Chapter02.Section01;

import java.util.Arrays;

public class S2_1_16 {
	
	private static boolean check(Comparable[] a) {
		Comparable[] b=a.clone();
		Arrays.sort(b);
		for(int i=0;i<a.length;i++) {
			if(a[i]!=b[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 对象没有被修改，使用 == 判断，不适用equal
		
		System.out.println(check(new Integer[] {1,2,2,7,3}));
		System.out.println(check(new Integer[] {1,2,2,3,7}));
	}

}
