package Chapter01.Section03;
class FixedCapacityStackOfStrings{
	// FixedCapacityStackOfStrings ÔÚ±í1.3.2ÖÐ
	private String[] a;
	private int N;
	public FixedCapacityStackOfStrings(int cap) {
		a=new String[cap];
	}
	public void push(String item) {
		a[N++]=item;
	}
	public String pop() {
		return a[--N];
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	public boolean isFull() {
		return N>=a.length;
	}
}

public class S1_3_1 {

	public static void main(String[] args) {
		FixedCapacityStackOfStrings s;
		s=new FixedCapacityStackOfStrings(2);
		s.push("hello");
		System.out.println("size:"+s.size()+";empty:"+s.isEmpty()+";full:"+s.isFull());
		s.push("world!");
		System.out.println("size:"+s.size()+";empty:"+s.isEmpty()+";full:"+s.isFull());
		while(s.isEmpty()==false) {
			System.out.println(s.pop());
		}

	}

}
