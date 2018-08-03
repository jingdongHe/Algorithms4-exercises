package Chapter02.Section02;

class InplaceMergeSortCountAnotherList extends InplaceMergeSort{
	@Override
	public void merge(Comparable[] a, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		for(int k=lo;k<=hi;k++) {
			if(i>mid) {
				a[k]=aux[j++];
				System.out.println("�ұ�ʣ��"+(hi-j+1));
			}
			else if(j>hi) {
				a[k]=aux[i++];
				System.out.println("���ʣ��"+(mid-i+1));
			}
			else if(Merging.less(aux[j], aux[i]))	a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}
}

public class S2_2_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 1000000;
		Integer[] s=new Integer[N];
		for(int i=0;i<N;i++)
			s[i]=(int) (Math.random()*N);
		
		long startTime;
		InplaceMergeSort sort1 = new InplaceMergeSortCountAnotherList();
		startTime=System.currentTimeMillis();
		sort1.sort(s.clone());
		System.out.println(System.currentTimeMillis()-startTime);
		
//		��ʵ�飬�������ʣ���������0,2֮�䣬δ�г���10�����
//		���ڹ鲢�������ɵ���ƽ���������Ҵ�С��Ϊ����
	}

}
