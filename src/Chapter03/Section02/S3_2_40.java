package Chapter03.Section02;

public class S3_2_40 {

	private static double getHeight(int N,int time) {
		int height=0;int count=time;
		while(count-->0) {
			BST<Integer, Integer> bst = new BST<Integer, Integer>();
			for (int i = 0; i < N; i++)
				bst.put((int) (Math.random() * N), i);
			height+=bst.height();
		}
		return height*1.0/time;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("N:10000;time:100");
		System.out.println(getHeight(10000, 100)+"<==>"+2.99*Math.log(1000)/Math.log(2));
		System.out.println("N:100000;time:100");
		System.out.println(getHeight(100000, 100)+"<==>"+2.99*Math.log(10000)/Math.log(2));
		System.out.println("N:1000000;time:100");
		System.out.println(getHeight(1000000, 100)+"<==>"+2.99*Math.log(100000)/Math.log(2));
	}

}
