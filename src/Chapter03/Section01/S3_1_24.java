package Chapter03.Section01;

class InsertSearchSt<Key extends Comparable<Key>, Value> extends BinarySearchST {
	public InsertSearchSt(int capacity) {
		// TODO Auto-generated constructor stub
		super(capacity);
	}

	@Override
	public int rank(Comparable key) {
		// TODO Auto-generated method stub
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			if(keys[hi].compareTo(key)<0) return hi;
			if(keys[lo].compareTo(key)>0) return lo;
			if(keys[hi].compareTo(keys[lo])==0)
				return lo;
			double insertRatio = Math.abs((int) key - (int) keys[lo])*1.0 / ((int) keys[hi] - (int) keys[lo]);
//			System.out.println(lo+","+hi+"=>"+insertRatio);
			int mid = (int) (lo + (hi - lo) * insertRatio);
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}
}

public class S3_1_24 {
	private static void capability(BinarySearchST st) {
		int put = 10000, check = put * 1000;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < put; i++) {
			st.put((int) (Math.random() * 1000), 0);
		}
		for (int i = 0; i < check; i++) {
			st.get((int) (Math.random() * 1000));
		}
		System.out.println(st.getClass() + "==>" + (System.currentTimeMillis() - startTime));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		capability(new BinarySearchST(10));
		capability(new InsertSearchSt(10));
		
		
		// 在均匀分布时，binarySearchSt的性能较好
		// 在键分布较开时，插值法查找效果更好
//		class Chapter03.BinarySearchST==>1631
//		class Chapter03.InsertSearchSt==>1690
//		class Chapter03.BinarySearchST==>1686
//		class Chapter03.InsertSearchSt==>2067
//		class Chapter03.BinarySearchST==>1722
//		class Chapter03.InsertSearchSt==>2341
//		class Chapter03.BinarySearchST==>1749
//		class Chapter03.InsertSearchSt==>1520

	}

}
