package Chapter02.Section01;

import java.util.UUID;

public class S2_1_38 {
	private static String getString() {
		return UUID.randomUUID().toString().replace("-", ""); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=10000;
		Comparable[] a=new Comparable[N];
		
		System.out.println("字符串中存在double");
		for(int i=0;i<N;i++)
			a[i]=getString();
		a[(int) (Math.random()*N)]=0.01;
		S2_1_34.test(a);
		
		System.out.println("double中存在字符串");
		for(int i=0;i<N;i++)
			a[i]=Math.random()*N;
		a[(int) (Math.random()*N)]="this is string test";
		S2_1_34.test(a);
		
		System.out.println("int中存在int[20]");
		// 此处数组int[20] 不能实现comparable，使用(new int[20])[0] 来勉强实现，后续又更好的方法再重做
		for(int i=0;i<N;i++)
			a[i]=(int) (Math.random()*N);
		a[(int) (Math.random()*N)]=new Comparable() {

			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return (new int[20])[0];
			}
		};
		S2_1_34.test(a);
		
		// 此处多个不同类型的数据进行对比时，若抛出ClassCastException,则将双方转换为字符串进行比较
		// 维持原有结论：希尔排序最快；插入排序次之；选择排序最慢；
	}

}
