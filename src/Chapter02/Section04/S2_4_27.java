package Chapter02.Section04;

public class S2_4_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPQ<Integer> pq=new MaxPQ<>(4);
		
		// ��һ��insert�о��Ѱ�����������С�Ĳ���
		pq.insert(1);
		pq.insert(2);
		pq.insert(3);
		pq.insert(4);
		pq.insert(5);
		pq.insert(6);
		pq.insert(7);
		
		pq.show();
		System.out.println(pq.min());
		System.out.println(pq.max());
	}

}
