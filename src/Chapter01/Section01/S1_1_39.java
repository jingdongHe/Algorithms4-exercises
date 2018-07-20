package Chapter01.Section01;

import java.util.Arrays;
import java.util.Random;

public class S1_1_39 {
	
	private static Random rand = new Random();
	
	private static int radomNum() {
		return rand.nextInt(10^7)+10^6;
	}
	private static int[] initList(int N) {
		int[] list=new int[N];
		for(int i=0;i<N;i++)
			list[i]=radomNum();
		return list;
	}
	private static int countInN(int N) {
		int[] listA=initList(N);
		int[] listB=initList(N);
		Arrays.sort(listA);
		int count=0;
		for(int i=0;i<listB.length;i++) {
			if(S1_1_22.rank(listB[i], listA)!=-1)
				count++;
			if(S1_1_22.rank(listA[i], listB)!=-1)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int T=100;
		
		int sum=0;
		for(int i=0;i<T;i++)
			sum+=countInN(10^3);
		System.out.println(sum/T);
		
		sum=0;
		for(int i=0;i<T;i++)
			sum+=countInN(10^4);
		System.out.println(sum/T);
		
		sum=0;
		for(int i=0;i<T;i++)
			sum+=countInN(10^5);
		System.out.println(sum/T);
		
		sum=0;
		for(int i=0;i<T;i++)
			sum+=countInN(10^6);
		System.out.println(sum/T);
		
		
		
	}

}
