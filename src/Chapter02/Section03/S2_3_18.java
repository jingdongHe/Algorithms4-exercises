package Chapter02.Section03;


class QuickSamplingThree extends Quick{
	int partition(Comparable[] a,int lo,int hi) {
		int i=lo,j=hi+1;
		Comparable v ;
		// 子数组存在3个元素以上
		if(hi-lo>1) {
			Comparable v1 = a[lo],v2=a[lo+1],v3=a[lo+2];
			// a[lo]不需要处理
			if((v2.compareTo(v1)<=0&&v2.compareTo(v3)>=0)||(v2.compareTo(v3)<=0&&v2.compareTo(v1)>=0))
				exch(a,lo,lo+1);
			else if((v3.compareTo(v1)<=0&&v3.compareTo(v2)>=0)||(v3.compareTo(v2)<=0&&v3.compareTo(v1)>=0))
				exch(a,lo,lo+2);
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

public class S2_3_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=1000;
		long startTime;
		for(int i=0;i<10;i++) {
			N*=2;
			Integer[] a=new Integer[N];
			for(int j=0;j<a.length;j++)
				a[j]=j;
			
			Quick quick1=new QuickSamplingThree();
			startTime=System.currentTimeMillis();
			quick1.sort(a.clone());
			System.out.println("N: "+N+" time: "+(System.currentTimeMillis()-startTime));
			
			Quick quick2=new Quick();
			startTime=System.currentTimeMillis();
			quick2.sort(a.clone());
			System.out.println("N: "+N+" time: "+(System.currentTimeMillis()-startTime));
			System.out.println("===============");
		}
		
//		效果一般，并不明显,数组越大，效果越明显
//		N: 2000 time: 13
//		N: 2000 time: 8
//		===============
//		N: 4000 time: 21
//		N: 4000 time: 23
//		===============
//		N: 8000 time: 23
//		N: 8000 time: 20
//		===============
//		N: 16000 time: 38
//		N: 16000 time: 55
//		===============
//		N: 32000 time: 61
//		N: 32000 time: 104
//		===============
//		N: 64000 time: 158
//		N: 64000 time: 222
//		===============
//		N: 128000 time: 232
//		N: 128000 time: 282
//		===============
//		N: 256000 time: 453
//		N: 256000 time: 438
//		===============
//		N: 512000 time: 706
//		N: 512000 time: 672
//		===============
//		N: 1024000 time: 1437
//		N: 1024000 time: 1485
		
	}

}
