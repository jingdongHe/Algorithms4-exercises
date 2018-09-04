package Chapter03.Section03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Chapter03.Section02.BST;

public class S3_3_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=16;
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			list.add(i);
		}
		Collections.shuffle(list);;
		Integer[] a=new Integer[n];
		
		list.toArray(a);
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println("\n");
		RedBlackBST<Integer, String> brbst = new RedBlackBST<>();
		BST<Integer,String> bst=new BST<Integer,String>();
		for(int i=0;i<n;i++) {
			brbst.put(a[i], null);
			bst.put(a[i], null);
		}
		brbst.print();
		System.out.println("==========");
		bst.print();
		
//		12 0 2 6 14 7 15 3 11 8 9 5 4 13 10 1 
//
//		12(null),
//		6(12-l(R)),14(12-r(R)),
//		4(6-l(B)),10(6-r(B)),13(14-l(B)),15(14-r(B)),
//		2(4-l(R)),5(4-r(R)),8(10-l(R)),11(10-r(R)),
//		1(2-l(B)),3(2-r(B)),7(8-l(B)),9(8-r(B)),
//		0(1-l(R)),
//		==========
//		12(null),
//		0(12-l),14(12-r),
//		2(0-r),13(14-l),15(14-r),
//		1(2-l),6(2-r),
//		3(6-l),7(6-r),
//		5(3-r),11(7-r),
//		4(5-l),8(11-l),
//		9(8-r),
//		10(9-r),
	}

}
