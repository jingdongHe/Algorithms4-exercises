package Chapter03.Section03;

import Chapter03.Section03.RedBlackBST.Node;

public class S3_3_42 {
	
	private static int calRed(Node x) {
		if(x==null)	return 0;
		return calRed(x.left)+calRed(x.right)+(x.color?1:0);
	}

	private static int avg(int N,int t) {
		RedBlackBST<Integer, String> bst;
		int count=0;
		for(int i=0;i<t;i++) {
			bst=new RedBlackBST<>();
			for(int j=0;j<N;j++) {
				bst.put((int) (Math.random()*N), null);
			}
			count+=calRed(bst.root);
		}
		return count/t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int avg,N;
		N=10000;
		avg=avg(N, 100);
		System.out.println("N=10000   "+avg+"<=>"+avg*1.0/N/2);
		N=100000;
		avg=avg(N, 100);
		System.out.println("N=100000  "+avg+"<=>"+avg*1.0/N/2);
		N=1000000;
		avg=avg(N, 100);
		System.out.println("N=1000000 "+avg+"<=>"+avg*1.0/N/2);
		
		// ∫Ï¡¥Ω”‘º’º8%
//		N=10000   1606<=>0.0803
//		N=100000  16044<=>0.08022
//		N=1000000 160469<=>0.0802345

	}

}
