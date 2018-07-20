package Chapter01.Section01;

import java.util.Random;

public class S1_1_35 {
	private static int SIDES=6;
	private static double DEV=0.001;
	private static Random rand = new Random();
	public static double[] probability()
    {
        double[] dist = new double[2*SIDES+1];
        
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i+j] += 1.0;
        
        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] /= 36;
        
        return dist; 
    }
	private static double[] experiment(int n) {
		double[] dist = new double[2*SIDES+1];
        
        for (int i = 0; i < n; i++)
            dist[getDist()]++;
        
        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] /= n;
        
        return dist;
	}
	private static int getDist() {
//		return (int) (Math.ceil(Math.random())*6+Math.ceil(Math.random())*6);
		return rand.nextInt(6)+rand.nextInt(6)+2;
	}
	private static boolean same(double[] a,double[] b) {
		for(int i=0;i<a.length;i++) {
			if(Math.abs(a[i]-b[i])>=DEV)
				return false;
		}
		return true;
	}
	private static void print(double[] list) {
		for(int i=0;i<list.length;i++)
			System.out.printf("%3.5f ",list[i]);
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] real=probability();
		double[] exp=null;
		print(real);
		
		exp=experiment(100);
		print(exp);
		System.out.println(same(real,exp));
		
		exp=experiment(10000);
		print(exp);
		System.out.println(same(real,exp));
		
		exp=experiment(10000000);
		print(exp);
		System.out.println(same(real,exp));
	}

}
