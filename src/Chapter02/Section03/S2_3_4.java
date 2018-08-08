package Chapter02.Section03;
class QuickWithoutShuffle extends Quick{
	public void sort(Comparable[] a) {
		sort(a,0,a.length-1);
	}
	@Override
	void sort(Comparable[] a,int lo,int hi) {
		for(Comparable i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
}
public class S2_3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �зֲ�ƽ��ʱ���Ч����һ�δ���С��Ԫ���з֣��ڶ��δӵڶ�С��Ԫ���з�
		// �����������ݣ�Ч����͵�Ϊ�����б�
		
		Quick quick=new QuickWithoutShuffle();
		System.out.println("=======˳��==========");
		Integer[] a1=new Integer[10];
		for(int i=0;i<a1.length;i++) a1[i]=i;
		quick.sort(a1);
		System.out.println("=======����==========");
		Integer[] a2=new Integer[10];
		for(int i=0;i<a2.length;i++) a2[i]=a2.length-i;
		quick.sort(a2);
	}

}
