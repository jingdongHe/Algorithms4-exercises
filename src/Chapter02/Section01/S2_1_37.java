package Chapter02.Section01;

public class S2_1_37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=10000;
		Integer[] a=new Integer[N];
		
		System.out.println("95%����");
		for(int i=0;i<N*0.95;i++)
			a[i]=i;
		for(int i=(int) (N*0.95);i<N;i++) {
			a[i]=(int) (Math.random()*N);
		}
		S2_1_34.test(a);
		
		System.out.println("\n����ȷλ�ò���10");
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
		
		System.out.println("\n5%��������ֲ�������������");
		for(int i=0;i<N;i++) {
			if(Math.random()<0.05) {
				a[i]=(int) (Math.random()*N);
			}else
				a[i]=i;
		}
		S2_1_34.test(a);
		
		// ά�ֽ��ۣ�ϣ��������죻���������֮��ѡ������������
		// ���Ͻ��۷��ϴ󲿷�����������ڡ�����Ԫ������ȷλ�ò�����10����ǰ�ᣬ������������������ϣ���������ĳ���
	}

}
