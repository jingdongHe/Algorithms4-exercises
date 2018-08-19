package Chapter02.Section05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class S2_5_13 {

	private static double[] balance(int M,double[] time) {
		double[] total=new double[M];
		Arrays.sort(time);
		Queue<Double> queue=new PriorityQueue<Double>();
		for(int i=0;i<M;i++)
			queue.add(0.0);
		for(int i=time.length-1;i>=0;i--) {
			queue.add(queue.poll()+time[i]);
		}
		for(int i=0;i<M;i++)
			total[i]=queue.poll();
		return total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] time= {6,8,4,3,2,1,3,4,6,5,4,8,4,7};
		double[] balanceTime=balance(3, time);
		for(int i=0;i<balanceTime.length;i++)
			System.out.println(balanceTime[i]);
	}

}
