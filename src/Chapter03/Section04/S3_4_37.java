package Chapter03.Section04;

import java.util.TreeMap;

class SeparateChainingHashSTInTree<Key, Value> extends SeparateChainingHashST{
	protected TreeMap<Key, Value>[] st;
	public SeparateChainingHashSTInTree(int m) {
		M = m;
		st = new TreeMap[M];
		for (int i = 0; i < M; i++)
			st[i] = new TreeMap<Key, Value>();
	}
}

public class S3_4_37 {
	
	private static void treeTime() {
		int N=10000;
		int M = N/100;
		SeparateChainingHashSTInTree<Integer, Integer> st = new SeparateChainingHashSTInTree<>(M);
		long start;
		start=System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			st.put((int) (Math.random()*N), i);
		System.out.println("build time "+(System.currentTimeMillis()-start));
		start=System.currentTimeMillis();
		st.get((int) (Math.random()*N));
		System.out.println("get one "+(System.currentTimeMillis()-start));
	}
	private static void normalTime() {
		int N=10000;
		int M = N/100;
		SeparateChainingHashST<Integer, Integer> st = new SeparateChainingHashST<>(M);
		long start;
		start=System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			st.put((int) (Math.random()*N), i);
		System.out.println("build time "+(System.currentTimeMillis()-start));
		start=System.currentTimeMillis();
		st.get((int) (Math.random()*N));
		System.out.println("get one "+(System.currentTimeMillis()-start));
	}

	public static void main(String[] args) {
		// TODO Auto-enerated method stub
		System.out.println("normal time");
		normalTime();
		System.out.println("using tree map");
		treeTime();
		
		// 效率几乎类似，tree map稍微慢一些，但在hash至较为集中时会更快（未进行实验验证）
//		normal time
//		build time 28
//		get one 0
//		using tree map
//		build time 30
//		get one 0

	}

}
