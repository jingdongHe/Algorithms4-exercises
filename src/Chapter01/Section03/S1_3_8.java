package Chapter01.Section03;

class DoublingStackOfString{
	private String[] a;
	private int N;
	public DoublingStackOfString(int cap) {
		a=new String[cap];
	}
	private void resize(int max) {
		String[] temp=new String[max];
		for(int i=0;i<N;i++) {
			temp[i]=a[i];
		}
		a=temp;
	}
	public void push(String item) {
		if(N>=a.length)	resize(2*a.length);
		a[N++]=item;
	}
	public String pop() {
		String item=a[--N];
		a[N]=null;
		if(N>0&&N<=a.length/4)	resize(a.length/2);
		return item;
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+String.join(",", a)+"]\nstack size:"+a.length+";content size:"+N;
	}
}

public class S1_3_8 {

	public static void main(String[] args) {
		String[] inputs= {"it","was","-","the","best","-","of","times","-","-","-","it","was","-","the","-","-"};
		DoublingStackOfString stack=new DoublingStackOfString(2);
		for(String input:inputs) {
			if(input.equals("-")) {
				stack.pop();
			}else {
				stack.push(input);
			}
			System.out.println(stack);
		}
	}

}
