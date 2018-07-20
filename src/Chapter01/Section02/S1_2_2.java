package Chapter01.Section02;

class Line{
	private final double start;
	private final double end;
	
	public Line(double start,double end) {
		this.start=start;
		this.end=end;
	}
	
	public double getStart() {
		return this.start;
	}
	public double getEnd() {
		return this.end;
	}
	public boolean isInterval(Line a) {
		double startA=a.getStart();
		double endA=a.getEnd();
		return (startA>this.start&&startA<this.end&&endA>this.end)||
				(startA<this.start&&endA>this.start&&endA<this.end);
	}
	@Override
	public String toString() {
		return String.format("(%6.3f,%6.3f)", this.start,this.end);
	}
	
}

public class S1_2_2 {
	//书中题目要求从命令行输入，此处偷懒，直接参考上一题随机生成
	private static void interval1D(int N) {
		Line[] lines=new Line[N];
		for(int i=0;i<N;i++) {
			lines[i]=new Line(Math.random(), Math.random());
		}
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(lines[i].isInterval(lines[j]))
					System.out.printf("%s==>%s\n",lines[i],lines[j]);
			}
		}
	}

	public static void main(String[] args) {
		int N=Integer.parseInt(args[0]);
		interval1D(N);
	}

}
