package Chapter03.Section02;

import Chapter03.Section02.BST.Node;

class BSTWithCounter<Key extends Comparable<Key>, Value> extends BST {
	int counter;

	public int count(Key key) {
		Value x = get(key);
		// 使用-1/1来说明未命中/命中
		return counter * (x == null ? -1 : 1);
	}

	@Override
	public Value get(Comparable key) {
		// TODO Auto-generated method stub
		counter = 0;
		return get(root, key);
	}

	protected Value get(Node x, Comparable key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		counter++;
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return (Value) x.val;
	}
}

public class S3_2_39 {
	
	private static void statistics(int N,int time) {
		BSTWithCounter<Integer, Integer> bst = new BSTWithCounter<Integer, Integer>();
		for (int i = 0; i < N; i++)
			bst.put((int) (Math.random() * N), i);
		int success = 0, miss = 0;
		int successCount = 0, missCount = 0;
		int[] countResult=new int[time];
		for (int i = 0; i < time; i++) {
			countResult[i] = bst.count((int) (Math.random() * N));
			if (countResult[i] > 0) {
				success++;
				successCount += countResult[i];
			} else {
				miss++;
				missCount += countResult[i];
			}
		}
		double successAvg=successCount*1.0/success;
		double missAvg=missCount*-1.0/miss;
		double successMD=0,missMD=0;
		double successVariance=0,missVariance=0;
		for(int i=0;i<time;i++) {
			if(countResult[i]>0) {
				successMD+=Math.abs(countResult[i]-successAvg);
				successVariance+=(countResult[i]-successAvg)*(countResult[i]-successAvg);
			}else {
				missMD+=Math.abs(countResult[i]*-1.0-missAvg);
				missVariance+=(countResult[i]*-1.0-missAvg)*(countResult[i]*-1.0-missAvg);
			}
		}
		System.out.println(String.format("Arithmetic success:%5.2f miss:%5.2f", successMD/success,missMD/miss));
		System.out.println(String.format("variance   success:%5.2f miss:%5.2f", successVariance/success,missVariance/miss));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("N:10000;time:100");
		statistics(10000, 100);
		System.out.println("N:100000;time:100");
		statistics(100000, 100);
		System.out.println("N:1000000;time:100");
		statistics(1000000, 100);
		
//		N:10000;time:100
//		Arithmetic success: 2.87 miss: 2.85
//		variance   success:13.09 miss:11.17
//		N:100000;time:100
//		Arithmetic success: 3.37 miss: 3.24
//		variance   success:16.31 miss:15.87
//		N:1000000;time:100
//		Arithmetic success: 3.94 miss: 2.67
//		variance   success:21.75 miss:13.87

	}

}
