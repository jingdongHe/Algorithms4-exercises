package Chapter03.Section03;

public class S3_3_46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3000;
		RedBlackBST<Integer, String> bst;
		for(int i=1;i<=n;i++) {
			bst = new RedBlackBST<>();
			for(int j=0;j<i;j++)
				bst.put((int) (Math.random()*i),null);
			System.out.println(String.format("N:%4d,height:%2d,lgN-0.5:%4.2f", i,bst.height(),Math.log(i)/Math.log(2)-0.5));
		}
	}

}
