package Chapter03;

public class S3_1_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchST<Integer, Integer> st = new BinarySearchST(10);
		for (int i = 0; i < 10; i++)
			st.put(i, i);
		st.print();
		System.out.println("��С������"+st.min());
		System.out.println("���������"+st.max());
		System.out.println("ɾ��5��Ԫ��");
		st.delete(5);
		st.print();
		System.out.println("����ȡ����"+st.select(st.floor(5)));
		System.out.println("����ȡ����"+st.select(st.ceiling(5)));
		st.deleteMin();
		st.deleteMax();
		System.out.println("ɾ�������С������");
		st.print();
	}

}
