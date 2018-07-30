package Chapter02.Section01;

class InsertNoExch extends Insertion{
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		int N=a.length;
		for(int i=1;i<N;i++) {
			Comparable temp=a[i];
			int j=i-1;
			for(;j>=0&&Sort.less(temp,a[j]);j--)
				a[j+1]=a[j];
			a[j+1]=temp;
//			Sort.show(a);
		}
	}
}

public class S2_1_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int N=10;
//		Integer[] a=new Integer[N];
//		for(int i=0;i<N;i++)
//			a[i]=(int) (Math.random()*N);
//		
//		InsertNoExch insert=new InsertNoExch();
//		Sort.show(a);
//		System.out.println("==============");
//		insert.sort(a);
//		Sort.show(a);
		
		int N=10000,T=10;
		SortCompare compare=new SortCompare();
		System.out.println(compare.timeRandomInput(new InsertNoExch(), N, T));
		System.out.println(compare.timeRandomInput(new Insertion(), N, T));
		
		// 当N较小时，可能会出现InsertNoExch》Insertion 运行时的结果；当N取较大值时，则不会出现上述情况
		// N=3000左右为分界
	}

}
