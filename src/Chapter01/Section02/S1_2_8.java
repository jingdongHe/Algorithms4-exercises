package Chapter01.Section02;

public class S1_2_8 {
	private static void print(int[] list) {
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 数组引用交换，非常高效
		int[] a= {1,3,5,7};
		int[] b= {2,4,6,8};
		
		int[] t=a;a=b;b=t;
		
		print(a);
		print(b);

	}

}
