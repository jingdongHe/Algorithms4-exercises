package Chapter02.Section04;

public class S2_4_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Ԥ�ƽ��в���ǰ��2�ζѲ���ȫ��ͬ�������Ĳ������ϸ���ɾ����Ĳ������³����ʻ᲻��ȫ��ͬ
		// ʵ�ʽ��Ϊ��ȫ��ͬ
		MaxPQ<Integer> pq=new MaxPQ<Integer>(10);
		
		pq.insert(5);
		pq.insert(4);
		pq.insert(9);
		pq.insert(8);
		pq.insert(7);
		
		pq.show();
		
		pq.insert(12);
		pq.delMax();
		pq.show();
		
		
		pq.insert(13);
		pq.insert(14);
		pq.delMax();
		pq.delMax();
		pq.show();
	}

}
