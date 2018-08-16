package Chapter02.Section04;

public class S4_2_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPQ<Integer> pq=new MaxPQ<>(4);
		
		// 第一个insert中就已包含了数组缩小的操作
		pq.insert(1);
		pq.insert(2);
		pq.insert(3);
		pq.insert(4);
		pq.insert(5);
		pq.insert(6);
		pq.insert(7);
		
		pq.show();
	}

}
