package Chapter03.Section03;

public class S3_3_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackBST<String, String> bst = new RedBlackBST<>();
		for (char a = 'A'; a <= 'Z'; a++) {
			bst.put(a + "", null);
		}
		bst.print();
		// ���ĸ߶ȵ��������������ٽϵ�
		// �ڽ��������У��᲻�Ͻ�������ת����ά������ƽ��
	}

}
