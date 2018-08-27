package Chapter03;

public class S3_1_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchST<Integer, Integer> st = new BinarySearchST(10);
		for (int i = 0; i < 10; i++)
			st.put(i, i);
		st.print();
		System.out.println("最小主键："+st.min());
		System.out.println("最大主键："+st.max());
		System.out.println("删除5号元素");
		st.delete(5);
		st.print();
		System.out.println("向下取整："+st.select(st.floor(5)));
		System.out.println("向上取整："+st.select(st.ceiling(5)));
		st.deleteMin();
		st.deleteMax();
		System.out.println("删除最大最小主键后");
		st.print();
	}

}
