package Chapter02.Section05;

import java.util.Arrays;

class Item implements Comparable<Item>{
	Comparable value;
	int index;
	public Item(Comparable value, int index) {
		super();
		this.value = value;
		this.index = index;
	}
	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		if(this.value.compareTo(o.value)>0) return 1;
		if(this.value.compareTo(o.value)<0) return -1;
		if(this.index>o.index) return -1;
		if(this.index<o.index) return 1;
		return 0;
	}
}

public class S2_5_24 {
	
	private static void sort(Comparable[] a) {
		Item[] items=new Item[a.length];
		for(int i=0;i<a.length;i++)
			items[i]=new Item(a[i], i);
		Arrays.sort(items);
		for(int i=0;i<a.length;i++)
			a[i]=items[i].value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a= {9,8,4,5,6,1,6,8,4};
		sort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}

}
