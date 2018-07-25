package Chapter01.Section03;

class Buffer {
	LinkStack<Character> left;
	LinkStack<Character> right;
	public Buffer() {
		// TODO Auto-generated constructor stub
		left=new LinkStack<Character>();
		right=new LinkStack<Character>();
	}
	public void insert(char c) {
		left.push(c);
	}
	public char delete() {
		char c=left.pop().itme;
		return c;
	}
	public void left(int k) {
		while(k--!=0)
			right.push(left.pop());
	}
	public void right(int k) {
		while(k--!=0)
			left.push(right.pop());
	}
	public int size() {
		return left.N+right.N;
	}
	public void print() {
		System.out.println("============left");
		left.print();
		right.print();
		System.out.println("right============");
	}
}

public class S1_3_44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer buffer=new Buffer();
		String s="Hello world!";
		for(int i=0;i<s.length();i++) {			
			buffer.insert(s.charAt(i));
		}
		buffer.print();
		
		buffer.left(2);
		buffer.print();
		
		buffer.delete();
		buffer.print();
	}

}
