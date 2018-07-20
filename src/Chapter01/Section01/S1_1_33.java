package Chapter01.Section01;

class Martix{
	public static double dot(double[] x,double[] y) {
		double sum=0;
		for(int i=0;i<x.length;i++) {
			sum+=x[i]*y[i];
		}
		return sum;
	}
	
	public static double[][] mult(double[][] a,double[][] b) {
		double[][] table=new double[a.length][b[0].length];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b[0].length;j++) {
				for(int k=0;k<a[i].length;k++)
					table[i][j]+=a[i][k]*b[k][j];
			}
		}
		return table;
	}
	public static double[][] transpose(double[][] a) {
		double[][] table=new double[a[0].length][a.length];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++)
				table[j][i]=a[i][j];
		}
		return table;
	}
}

public class S1_1_33 {
	private static void print(double[][] table) {
		for(int i=0;i<table.length;i++) {
			for(int j=0;j<table[i].length;j++)
				System.out.print(table[i][j]+" ");
			System.out.println();
		}
		
	}
	private static void print(double[] list) {
		for(int i=0;i<list.length;i++)
			System.out.print(list[i]+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] martirxA= {
				{1,2,3},
				{4,5,6},
				{7,8,0}
		};
		double[][] martirxB= {
				{1,2,1},
				{1,1,2},
				{2,1,1}
		};
		double[] martixX= {1,2,3};
		double[] martixY= {4,5,6};
		
		System.out.println(Martix.dot(martixX,martixY));
		print(Martix.mult(martirxA,martirxB));
		print(Martix.transpose(martirxA));
	}

	

}
