package Chapter03;

import java.io.ObjectOutputStream.PutField;

import Chapter02.Section02.InplaceMergeSort;

class BinarySearchSTInItem<Key extends Comparable<Key>, Value> extends BinarySearchST {

	class Item<Key, Value> implements Comparable<Item> {
		Key key;
		Value value;

		public Item(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Item o) {
			// TODO Auto-generated method stub
			if (((Comparable<Key>) this.key).compareTo((Key) o.key) > 0)
				return 1;
			else if (((Comparable<Key>) this.key).compareTo((Key) o.key) < 0)
				return -1;
			return 0;
		}

	}

	Item[] items;

	public BinarySearchSTInItem(int capacity) {
		items = new Item[capacity];
	}

	public BinarySearchSTInItem(Item[] items) {
		InplaceMergeSort sort = new InplaceMergeSort();
		sort.sort(items);
		this.items = items;
		this.N=items.length;
	}

	public BinarySearchSTInItem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object get(Comparable key) {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		int i = rank(key);
		if (i < N && key.compareTo(items[i].key) == 0)
			return items[i].value;
		else
			return null;
	}

	@Override
	public int rank(Comparable key) {
		// TODO Auto-generated method stub
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(items[mid].key);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

	@Override
	public void put(Comparable key, Object val) {
		// TODO Auto-generated method stub
		int i = rank(key);
		if (i < N && key.compareTo(items[i].key) == 0) {
			items[i].value = val;
			print();
			return;
		}
		for (int j = N; j > i; j--) {
			items[j] = items[j - 1];
		}
		items[i] = new Item(key, val);
		N++;
		resize();
		print();
	}

	protected void resize() {
		// TODO Auto-generated method stub
		if (N >= items.length) {
			Item[] expandItems = new Item[items.length * 2];
			for (int i = 0; i < N; i++) {
				expandItems[i] = items[i];
			}
			items = expandItems;
		} else if (N < items.length / 4) {
			Item[] expandItems = new Item[items.length / 2];
			for (int i = 0; i < N; i++) {
				expandItems[i] = items[i];
			}
			items = expandItems;
		}
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			System.out.print(String.format("%s(%s)=>", items[i].key, items[i].value));
		}
		System.out.println();
	}
}

public class S3_1_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };
		BinarySearchST<String, String> st = new BinarySearchSTInItem<String, String>(10);

		for (String str : strings) {
			st.put(str, "");
		}
		System.out.println("==================");
		BinarySearchSTInItem.Item[] items = new BinarySearchSTInItem.Item[strings.length];
		BinarySearchSTInItem mother = new BinarySearchSTInItem();
		for (int i = 0; i < strings.length; i++)
			items[i] = mother.new Item(strings[i], "");
		BinarySearchST<String, String> st2 = new BinarySearchSTInItem<String, String>(items);
		st2.print();
	}

}
