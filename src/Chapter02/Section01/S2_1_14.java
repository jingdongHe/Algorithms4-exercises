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
		// 1、对末位2个数进行比较，大的向后移，如 x,x,x,2,1 ==> x,x,x,1,2
		// 2、将最后一位（较大）移至最前 ==> 2,x,x,x,1 (此时，需要将已排好序的内容统一往前移动)
		// 3、对N个数进行末尾轮换，进行N-1次之后，最后一位即为N个数中最小的一个
		// 4、最小的一个移至首位，进行N-1个数的末位轮换排序
		Integer[] a= {5,4,7,4,9};
		Sort.show(a);
		Dequeue dequeue=new Dequeue();
		dequeue.sort(a);
		Sort.show(a);
	}

}
