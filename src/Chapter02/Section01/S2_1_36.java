package Chapter02.Section01;

public class S2_1_36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=10000;
		Integer[] a=new Integer[N];
		
		System.out.println("01�ֲ�");
		for(int i=0;i<N;i++)
			a[i]=Math.random()<0.5?0:1;
		S2_1_34.test(a);
		
		System.out.println("\n012�ֲ�");
		for(int i=0;i<N;i++) {
			double random=Math.random();
			if(random<0.5)
				a[i]=0;
			else if(random<0.75)
				a[i]=1;
			else
				a[i]=2;
		}
		S2_1_34.test(a);
		
		System.out.println("\n0��int������ֲ�");
		for(int i=0;i<N;i++)
			a[i]=(int) (Math.random()<0.5?0:Math.random()*N);
		S2_1_34.test(a);
		
		// ��������3�зֲ��������Ϊshell����Ч����ѣ����������֮��ѡ���������
	}

}
