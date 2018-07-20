package Chapter01.Section02;

class VisualCounter{
	int N,max;
	int number;
	public VisualCounter(int N,int max) {
		this.N=N;this.max=max;
		this.number=0;
	}
	public void add() {
		if(N<=0) System.out.println("Limit of operations");
		else if(number>=max) System.out.println("Limit of max");
		else {
			N--;number++;
			System.out.println(this);
		}
	}
	public void sub() {
		if(N<=0) System.out.println("Limit of operations");
		else if(number<=-max) System.out.println("Limit of max");
		else {
			N--;number--;
			System.out.println(this);
		}
	}
	@Override
	public String toString() {
		return String.format("N:%d;now:%d", this.N,this.number);
	}
}

public class S1_2_10 {

	public static void main(String[] args) {
		VisualCounter counter=new VisualCounter(20, 3);
		
		counter.add();
		counter.add();
		counter.add();
		counter.add();
		
		counter.sub();
		counter.sub();
		counter.sub();
		counter.sub();
		counter.sub();
		counter.sub();
		counter.sub();
	}

}
