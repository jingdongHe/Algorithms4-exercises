package Chapter01.Section04;

class ThreeSum{
	public static int count(int[] a) {
		int N=a.length;
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				for(int k=j+1;k<N;k++) {
//					if(
//							a[i]>Integer.MAX_VALUE||a[i]<Integer.MIN_VALUE||
//							a[j]>Integer.MAX_VALUE||a[j]<Integer.MIN_VALUE||
//							a[k]>Integer.MAX_VALUE||a[k]<Integer.MIN_VALUE
//					) {
//						if((long)a[i]+a[j]+a[k]==0)
//							cnt++;
//					}
//					else if(a[i]+a[j]+a[k]==0)
//						cnt++;
					if(a[i]+a[j]+a[k]==0)
						cnt++;
				}
			}
		}
		return cnt;
	}
}

public class S1_4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ThreeSum.count(new int[] {10,-9,-1,20}));
		System.out.println(ThreeSum.count(new int[] {10,-10,0,20}));
		System.out.println(ThreeSum.count(new int[] {2147483647,2147483647,-2147483647*2,20}));
		System.out.println("此题无需处理。此题本意为3个数相加，在相加时，java会自动进行类型提升，由int提升至long，避免溢出");
		
	}

}
