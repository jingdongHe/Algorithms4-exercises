package Chapter01.Section02;

class Accumulator{
	private double m;
	private double s;
	private int N;
	
	public void addDataValue(double x) {
		// 书中的例子，方差使用的是样本方差，此处给出总体方差的实现
		N++;
		s=s+1.0*(x-m)*(x-m);
		m=m+(x-m)*1.0/N;
	}
	public double mean() {
		return m;
	}
	public double var() {
		return s/N;
	}
	public double stddev() {
		return Math.sqrt(this.var());
	}
	@Override
	public String toString() {
		return "Accumulator [m=" + m + ", s=" + s + ", N=" + N + "]==>var="+var()+",stddev="+stddev();
	}
	
}

public class S1_2_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Accumulator acc=new Accumulator();
		acc.addDataValue(1);
		acc.addDataValue(2);
		acc.addDataValue(9);
		acc.addDataValue(9);
		System.out.println(acc);
	}

}
