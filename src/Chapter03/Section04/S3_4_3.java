package Chapter03.Section04;

class SeparateChainingHashSTLimitK<Key, Value> extends SeparateChainingHashST{
	int k;
	
	public SeparateChainingHashSTLimitK(int M,int k) {
		super(M);
		this.k = k;
	}

	@Override
	public void put(Object key, Object val) {
		// TODO Auto-generated method stub
		if(st[hash(key)].size()>=k)
			st[hash(key)].clear();
		st[hash(key)].put(key, st[hash(key)].size());
	}
}

public class S3_4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		int M = 5;
		SeparateChainingHashSTLimitK<String, Integer> st = new SeparateChainingHashSTLimitK<>(M,2);
		for (int i = 0; i < s.length; i++)
			st.put(s[i], i);

		st.print();
	}

}
