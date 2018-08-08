package Chapter02.Section03;
class QuickSamplingFive extends Quick{
	int getMid(Comparable[] a,int lo,int hi,int mid) {
		int i=lo,j=hi+1;
		Comparable v=a[lo];
		while(true) {
			while(less(a[++i],v)) if(i>=hi) break;
			while(less(v,a[--j]));
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		if(j==mid) return j;
		if(j>mid) return getMid(a, lo, j-1,mid);
		else return getMid(a, j+1, hi,mid);
	}
	int partition(Comparable[] a,int lo,int hi) {
		int i=lo,j=hi+1;
		Comparable v ;
		// 子数组存在5个元素以上
		if(hi-lo>3) {
			// lo ~ lo+4
			int mid=getMid(a,lo,lo+4,lo+2);
			exch(a, mid, lo);
		}
		v= a[lo];
		while(true) {
			while(less(a[++i],v)) if(i==hi) break;
			while(less(v,a[--j])) if(j==lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
}
public class S3_3_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N=1000;
		long startTime;
		for(int i=0;i<10;i++) {
			N*=2;
			Integer[] a=new Integer[N];
			for(int j=0;j<a.length;j++)
				a[j]=j;
			
			QuickSamplingFive quick3=new QuickSamplingFive();
			startTime=System.currentTimeMillis();
			quick3.sort(a.clone());
			System.out.println("N: "+N+" time: "+(System.currentTimeMillis()-startTime));
			
			Quick quick1=new QuickSamplingThree();
			startTime=System.currentTimeMillis();
			quick1.sort(a.clone());
			System.out.println("N: "+N+" time: "+(System.currentTimeMillis()-startTime));
			
			Quick quick2=new Quick();
			startTime=System.currentTimeMillis();
			quick2.sort(a.clone());
			System.out.println("N: "+N+" time: "+(System.currentTimeMillis()-startTime));
			System.out.println("===============");
			// 三取样切分效果相对较好，五取样切分尽管比较次数少于7次，但是效果很差
//			N: 2000 time: 18
//			N: 2000 time: 9
//			N: 2000 time: 7
//			===============
//			N: 4000 time: 67
//			N: 4000 time: 21
//			N: 4000 time: 9
//			===============
//			N: 8000 time: 193
//			N: 8000 time: 116
//			N: 8000 time: 66
//			===============
//			N: 16000 time: 80
//			N: 16000 time: 180
//			N: 16000 time: 19
//			===============
//			N: 32000 time: 61
//			N: 32000 time: 26
//			N: 32000 time: 28
//			===============
//			N: 64000 time: 105
//			N: 64000 time: 46
//			N: 64000 time: 54
//			===============
//			N: 128000 time: 107
//			N: 128000 time: 91
//			N: 128000 time: 92
//			===============
//			N: 256000 time: 210
//			N: 256000 time: 209
//			N: 256000 time: 218
//			===============
//			N: 512000 time: 475
//			N: 512000 time: 456
//			N: 512000 time: 443
//			===============
//			N: 1024000 time: 995
//			N: 1024000 time: 913
//			N: 1024000 time: 918
//			===============

		}
	}

}
