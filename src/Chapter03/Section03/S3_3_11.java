package Chapter03.Section03;

public class S3_3_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackBST<String, String> bst=new RedBlackBST<>();
		String[] a= {"Y","L","P","M","X","H","C","R","A","E","S"};
		for(int i=0;i<a.length;i++)
			bst.put(a[i], null);
		bst.print();
	}

}
