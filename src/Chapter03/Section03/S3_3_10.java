package Chapter03.Section03;

public class S3_3_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackBST<String, String> bst=new RedBlackBST<>();
		String[] a= {"E","A","S","Y","Q","U","T","I","O","N"};
		for(int i=0;i<a.length;i++)
			bst.put(a[i], null);
		bst.print();
	}

}
