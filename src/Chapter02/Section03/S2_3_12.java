package Chapter02.Section03;

public class S2_3_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"B","A","B","A","B","A","B","A","C","A","D","A","B","R","A"};
//		����BΪ��һ��ֵ��������ʱ����Ϣ�����
		Quick quick=new QuickWithoutShuffle();
		quick.sort(s);
	}

}
