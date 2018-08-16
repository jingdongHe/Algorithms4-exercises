package Chapter02.Section04;

public class S2_4_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 预计进行操作前后2次堆不完全相同，插入后的操作是上浮，删除后的操作是下沉，故会不完全相同
		// 实际结果为完全相同
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
