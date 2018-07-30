package Chapter02.Section01;

class Dequeue implements Sort{

	void LastToTop(Comparable[] a) {
		Comparable temp=a[a.length-1];
		for(int i=a.length-1;i>0;i--) {
			a[i]=a[i-1];
		}
		a[0]=temp;
	}
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		int finish=0;
		int size=a.length;
		while(finish<size) {
			for(int i=finish;i<size-1;i++) {
				if(Sort.less(a[size-1], a[size-2])) {
					Sort.exch(a, size-1, size-2);
				}
				LastToTop(a);
			}
			for(int i=0;i<finish+1;i++)
				LastToTop(a);
			finish++;
		}
	}
	
}

public class S2_1_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1����ĩλ2�������бȽϣ��������ƣ��� x,x,x,2,1 ==> x,x,x,1,2
		// 2�������һλ���ϴ�������ǰ ==> 2,x,x,x,1 (��ʱ����Ҫ�����ź��������ͳһ��ǰ�ƶ�)
		// 3����N��������ĩβ�ֻ�������N-1��֮�����һλ��ΪN��������С��һ��
		// 4����С��һ��������λ������N-1������ĩλ�ֻ�����
		Integer[] a= {5,4,7,4,9};
		Sort.show(a);
		Dequeue dequeue=new Dequeue();
		dequeue.sort(a);
		Sort.show(a);
	}

}
