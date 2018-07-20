package Chapter01.Section01;

public class S1_1_15 {
	private static int[] histogram(int[] a,int M) {
		int[] count=new int[M];
		for(int i=0;i<a.length;i++) {
			if(a[i]<M)
				count[a[i]]++;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,7,7,7,10};
		int M=9;
		int[] list=histogram(a,M);
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]);
		}
	}

}
