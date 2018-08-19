package Chapter02.Section05;

import Chapter02.Section01.Insertion;

public class S2_5_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Insertion insertion=new Insertion();
		String[] a= {"E","A","S","Y","Q","U","E","S","T","I","O","N"};
		Integer[] index=insertion.indirectSort(a);
		for(int i=0;i<index.length;i++)
			System.out.print(index[i]+" ");
		System.out.println();
		for(int i=0;i<index.length;i++)
			System.out.print(a[index[i]]+" ");
	}

}
