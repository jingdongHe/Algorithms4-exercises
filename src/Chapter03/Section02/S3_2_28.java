package Chapter03.Section02;

public class S3_2_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a= {"E","A","S","Y","Q","U","E","S","T","I","O","N"};
		
		BSTCache<String,String> bst=new BSTCache<String,String>();
		for(int i=0;i<a.length;i++)
			bst.put(a[i], null);
		bst.print();
		
		bst.get("A");
		System.out.println("cache "+bst.cache);
		System.out.println("use cache "+bst.get("A"));
	}

}
