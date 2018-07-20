package Chapter01.Section02;

class Point{
	private final double x;
	private final double y;
	
	public Point(double x,double y) {
		this.x=x;
		this.y=y;
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double distance(Point a) {
		return Math.sqrt(
				(a.getX()-this.x)*(a.getX()-this.x)+
				(a.getY()-this.y)*(a.getY()-this.y)
			);
	}
}

public class S1_2_1 {
	private static double[][] point2D(int N) {
		Point[] point=new Point[N];
		for(int i=0;i<N;i++) {
			point[i]=new Point(Math.random(), Math.random());
		}
		double[][] distance=new double[N][N];
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				double dis=point[i].distance(point[j]);
				distance[i][j]=dis;
				distance[j][i]=dis;
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		int N=Integer.parseInt(args[0]);
		double[][] distance=point2D(N);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.printf("%9.5f",distance[i][j]);
			}
			System.out.println();
		}
	}

}
