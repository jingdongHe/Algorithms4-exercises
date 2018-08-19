package Chapter02.Section05;

import java.util.Arrays;
import java.util.Comparator;

public class S2_5_17 {
	
	private static boolean check() {
		int N=100;
		int[] a=new int[N];
		Integer[] index=new Integer[N];
		for(int i=0;i<N;i++) {
			a[i]=(int) (Math.random()*N/2);
			index[i]=i;
		}
		Arrays.sort(index,new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				if(a[(int) o1]>a[(int) o2]) return 1;
				if(a[(int) o1]<a[(int) o2]) return -1;
				return 0;
			}
		});
		for(int i=0;i<index.length;i++)
			System.out.print(index[i]+" ");
		System.out.println();
		for(int i=0;i<index.length;i++)
			System.out.print(a[index[i]]+" ");
		System.out.println();
		for(int i=1;i<index.length;i++) {
			if(a[index[i-1]]==a[index[i]]&&index[i-1].compareTo(index[i])>0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(check());
	}

}
