package Chapter02.Section01;

public class SortCompare {
	public double timeRandomInput(Sort sort,int N,int T) {
		long startTime=System.currentTimeMillis();
		int count=T;
		while(T-->0) {
			Integer[] a=new Integer[N];
			for(int i=0;i<N;i++)
				a[i]=(int) (Math.random()*N);
			sort.sort(a);
		}
		long endTime=System.currentTimeMillis();
		double excTime=(double)(endTime-startTime)/count;
		return excTime;
	}
	public double time2Input(Sort sort,int N,int T) {
		long startTime=System.currentTimeMillis();
		int count=T;
		while(T-->0) {
			Integer[] a=new Integer[N];
			for(int i=0;i<N;i++)
				a[i]=Math.random()<0.5?0:1;
			sort.sort(a);
		}
		long endTime=System.currentTimeMillis();
		double excTime=(double)(endTime-startTime)/count;
		return excTime;
	}
	public double timeShellInList(ShellInList shell,int N,int T,int[] list) {
		long startTime=System.currentTimeMillis();
		int count=T;
		while(T-->0) {
			Integer[] a=new Integer[N];
			for(int i=0;i<N;i++)
				a[i]=(int) (Math.random()*N);
			shell.sort(a,list);
		}
		long endTime=System.currentTimeMillis();
		double excTime=(double)(endTime-startTime)/count;
		return excTime;
	}
}
