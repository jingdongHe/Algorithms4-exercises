package Chapter01.Section03;

class RingBuffer<T>{
	T[] a;
	int head,tail,N;
	public RingBuffer(int length) {
		// TODO Auto-generated constructor stub
		a=(T[]) new Object[length];
		head=0;tail=0;N=0;
	}
	public void enqueue(T item) throws Exception {
		if(isFull())
			throw new Exception("full");
		a[tail]=item;
		N++;
		tail=(tail+1)%a.length;
	}
	public T dequeue() throws Exception {
		if(isEmpty())
			throw new Exception("empty");
		N--;
		T temp=a[head];
		head=(head+1)%a.length;
		return temp;
	}
	public boolean isEmpty() {
		return N==0;
	}
	public boolean isFull() {
		return N==a.length;
	}
	public void print() {
		for(int i=0;i<N;i++) {
			System.out.print(a[(head+i)%a.length]);
		}
		System.out.println();
	}
}

public class S1_3_39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RingBuffer buffer=new RingBuffer(3);
		try {
			buffer.enqueue(1);
			buffer.print();
			buffer.enqueue(2);
			buffer.print();
			buffer.enqueue(3);
			buffer.print();
			
			buffer.dequeue();
			buffer.print();
			buffer.enqueue(9);
			buffer.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

}
