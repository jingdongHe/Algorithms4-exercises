package Chapter02.Section01;

public class S2_1_37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=10000;
		Integer[] a=new Integer[N];
		
		System.out.println("95%有序");
		for(int i=0;i<N*0.95;i++)
			a[i]=i;
		for(int i=(int) (N*0.95);i<N;i++) {
			a[i]=(int) (Math.random()*N);
		}
		S2_1_34.test(a);
		
		System.out.println("\n与正确位置不超10");
		for(int i=0;i<N;i++)
			a[i]=i;
		for(int i=0;i<50;i++) {
			int index=(int) (Math.random()*N);
			int step=(int) (Math.random()*10);
			if(index-step>0) {
				Comparable temp=a[index];a[index]=a[step];a[step]=(Integer) temp;
			}
		}
		S2_1_34.test(a);
		
		System.out.println("\n5%乱序随机分布在有序数组中");
		for(int i=0;i<N;i++) {
			if(Math.random()<0.05) {
				a[i]=(int) (Math.random()*N);
			}else
				a[i]=i;
		}
		S2_1_34.test(a);
		
		// 维持结论：希尔排序最快；插入排序次之；选择排序最慢；
		// 以上结论符合大部分情况，但对于“所有元素与正确位置不超过10”的前提，会出现少数插入排序比希尔排序更快的场景
	}

}
