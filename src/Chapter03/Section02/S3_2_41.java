package Chapter03.Section02;

class BSTList {
	String[] keys;
	int[] left,right;
	int N;

	public BSTList(int N) {
		this.keys = new String[N];
		this.left = new int[N];
		this.right = new int[N];
		for(int i=0;i<N;i++) {
			this.left[i]=this.right[i]=-1;
		}
	}
	public BSTList() {
		this(15);
	}
	public void put(String key) {
		put(0,key);
	}
	private void put(int k,String key) {
		if(keys[k]==null) {
			keys[k]=key;
			return;
		}
		int cmp = key.compareTo(keys[k]);
		if (cmp < 0) {
			if(left[k]==-1) {
				left[k]=++N;
			}
			put(left[k], key);
		}
		else if (cmp > 0) {
			if(right[k]==-1) {
				right[k]=++N;
			}
			put(right[k], key);
		}
	}
	public int get(int k,String key) {
		if(k<0||k>N) return -1;
		int cmp = key.compareTo(keys[k]);
		if (cmp < 0)
			return get(left[k], key);
		else if (cmp > 0)
			return get(right[k], key);
		else
			return k;
	}
	public void print() {
		for(int i=0;i<N+1;i++)
			System.out.println(String.format("%s(%d,%d)", keys[i],left[i],right[i]));
		System.out.println();
	}

}

public class S3_2_41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		BSTList bst = new BSTList();
		for (int i = 0; i < a.length; i++)
			bst.put(a[i]);
		bst.print();
		System.out.println(bst.get(0, "S"));
		
		long start;
		int N=1000000;
		
		start=System.currentTimeMillis();
		BSTList bst1 = new BSTList(N);
		for(int i=0;i<N;i++)
			bst1.put((int)(Math.random()*N)+"");
		System.out.println("list bst "+(System.currentTimeMillis()-start));
		
		start=System.currentTimeMillis();
		BST<String,String> bst2=new BST<String,String>();
		for(int i=0;i<N;i++)
			bst2.put((int)(Math.random()*N)+"",null);
		System.out.println("nomal bst "+(System.currentTimeMillis()-start));
		
		// 基本性能类似，但数组表示稍慢一些，约5%的性能差距
//		list bst 2465
//		nomal bst 2386
	}

}
