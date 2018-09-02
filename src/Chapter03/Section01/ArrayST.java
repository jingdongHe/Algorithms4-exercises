package Chapter03.Section01;

import java.util.Iterator;

public class ArrayST<Key extends Comparable<Key>, Value> implements ST {

	Key[] key;
	Value[] value;
	int N;

	public ArrayST() {
		super();
		this.key = (Key[]) new Comparable[10];
		this.value = (Value[]) new Object[10];
		N = 0;
	}

	public ArrayST(Key[] key, Value[] value) {
		super();
		this.key = key;
		this.value = value;
		N = 0;
	}

	private void resize() {
		if (N >= this.key.length) {
			Key[] tempKey = (Key[]) new Comparable[this.key.length * 2];
			Value[] tempValue = (Value[]) new Object[this.key.length * 2];
			for (int i = 0; i < N; i++) {
				tempKey[i] = this.key[i];
				tempValue[i] = this.value[i];
			}
			key = tempKey;
			value = tempValue;
		}
		if (N < this.key.length / 4) {
			Key[] tempKey = (Key[]) new Comparable[this.key.length / 2];
			Value[] tempValue = (Value[]) new Object[this.key.length / 2];
			for (int i = 0; i < N; i++) {
				tempKey[i] = this.key[i];
				tempValue[i] = this.value[i];
			}
			key = tempKey;
			value = tempValue;
		}
	}

	private int find(Comparable key) {
		int index = -1;
		for (int i = 0; i < N; i++) {
			if (this.key[i].equals(key))
				index = i;
		}
		return index;
	}

	@Override
	public void put(Comparable key, Object val) {
		// TODO Auto-generated method stub
		int index = find(key);
		
		if (index == -1) {
			index=N;
			N++;
		}
		this.key[index] = (Key) key;
		this.value[index] = (Value) val;
		resize();
	}

	@Override
	public Object get(Comparable key) {
		// TODO Auto-generated method stub
		int index = find(key);
		return index == -1 ? null : this.value[index];
	}
	public Object smartGet(Comparable key) {
		// TODO Auto-generated method stub
		int index = find(key);
		Value val=null;
		if(index!=-1) {
			val=this.value[index];
			for(int i=index;i>0;i--) {
				this.key[i]=this.key[i-1];
				this.value[i]=this.value[i-1];
			}
			this.key[0]=(Key) key;
			this.value[0]=val;
			return val;
		}
		return null;
	}

	@Override
	public void delete(Comparable key) {
		// TODO Auto-generated method stub
		int index = find(key);
		if (index != -1) {
			for(int i=index+1;i<this.key.length;i++) {
				this.value[i-1]=this.value[i];
				this.key[i-1]=this.key[i];
			}
			N--;
		}
		resize();
	}

	@Override
	public boolean contains(Comparable key) {
		// TODO Auto-generated method stub
		int index = find(key);
		return index == -1 ? false : true;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return N==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return N;
	}

	@Override
	public Iterable keys() {
		// TODO Auto-generated method stub
		return new Iterable() {

			@Override
			public Iterator iterator() {
				// TODO Auto-generated method stub
				return new Iterator() {
					int i=0;
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return i<N;
					}

					@Override
					public Object next() {
						// TODO Auto-generated method stub
						return key[i++];
					}
				};
			}
		};
	}
	public void print() {
		for(int i=0;i<N;i++) {
			System.out.print(String.format("%s(%s)=>", key[i],value[i]));
		}
		System.out.println();
	}
}
