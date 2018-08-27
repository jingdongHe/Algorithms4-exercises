package Chapter03;

class BinarySearchSTWithCache<Key extends Comparable<Key>, Value> extends BinarySearchST {
	Key cacheKey;
	Value cacheVals;
	public BinarySearchSTWithCache(int capacity) {
		// TODO Auto-generated constructor stub
		super(capacity);
	}
	@Override
	public Object get(Comparable key) {
		// TODO Auto-generated method stub
		if (cacheKey!=null&&key.compareTo(cacheKey) == 0)
			return cacheVals;
		cacheKey = (Key) key;
		cacheVals = (Value) super.get(key);
		return cacheKey;
	}
}

public class S3_1_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };
		BinarySearchST<String, String> st = new BinarySearchSTWithCache<String, String>(10);

		for (String str : strings) {
			st.put(str, str);
		}
		System.out.println(st.get("N"));
		System.out.println(st.get("N"));
		System.out.println(st.get("N"));
	}

}
