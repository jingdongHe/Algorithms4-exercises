package Chapter03.Section02;

public class S3_2_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 内部路径长度就是从根结点到所有结点的长度之和
		// 此题只完成递归实现，添加变量的实现与3.2.6一样
		String[] a= {"E","A","S","Y","Q","U","E","S","T","I","O","N"};
		
		BST<String,String> bst=new BST<String,String>();
		for(int i=0;i<a.length;i++)
			bst.put(a[i], null);
		bst.print();
		System.out.println("avg compares "+bst.avgCompares());
	}

}
