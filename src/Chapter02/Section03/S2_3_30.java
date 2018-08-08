package Chapter02.Section03;

import java.util.Random;

import Chapter02.Section01.S2_1_34;
import Chapter02.Section01.Shell;
import Chapter02.Section01.Sort;

public class S2_3_30 {
	private static double pRand(double Lamda) { // ���ɷֲ�
		double x = 0, b = 1, c = Math.exp(-Lamda), u;
		do {
			u = Math.random();
			b *= u;
			if (b >= c)
				x++;
		} while (b >= c);
		return x;
	}
	private static double geometric(double p,int r) //���ηֲ�
    {
        double PX=0;   //PX�ǵ�һ�γɹ��ĸ��ʣ���ʼ��Ϊ0
        double q=1-p;  //q��ʧ�ܵĸ��ʣ�����p��q���⣬��q=1-p
        double k=(double)(r-1);
        PX= p*(Math.pow(q, k));//���� P(X=r)=pq^{r-1}��ʽ������ʣ�����k��double���Ͳ���
        return PX;
    }
	private static void test(Comparable[] a) {
		Quick quick = new Quick();
		long startTime = System.currentTimeMillis();
		quick.sort(a.clone());
		System.out.println(System.currentTimeMillis()-startTime);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int N = 100000;
		
		System.out.println("��˹�ֲ�");
		Double[] gaussian = new Double[N];
		for (int i = 0; i < N; i++)
			gaussian[i] = r.nextGaussian();
		test(gaussian);
		
		System.out.println("���ɷֲ�");
		Double[] poisson=new Double[N];
		for (int i = 0; i < N; i++)
			poisson[i] = pRand(10);
		test(poisson);
		
		System.out.println("���ηֲ�");
		Double[] geometric=new Double[N];
		for (int i = 0; i < N; i++)
			geometric[i] = geometric(0.1,10);
		test(geometric);
		
		Integer[] a=new Integer[N];
		System.out.println("01�ֲ�");
		for(int i=0;i<N;i++)
			a[i]=Math.random()<0.5?0:1;
		test(a);
		
		System.out.println("012�ֲ�");
		for(int i=0;i<N;i++) {
			double random=Math.random();
			if(random<0.5)
				a[i]=0;
			else if(random<0.75)
				a[i]=1;
			else
				a[i]=2;
		}
		test(a);
		
		System.out.println("0��int������ֲ�");
		for(int i=0;i<N;i++)
			a[i]=(int) (Math.random()<0.5?0:Math.random()*N);
		test(a);
		
		
		// ���ηֲ�����ѧ�ֲ��У�Ч�ʽϸߣ�01�ֲ����������ݷֲ���Ч�ʽϵ�
//		��˹�ֲ�
//		423
//		���ɷֲ�
//		308
//		���ηֲ�
//		262
//		01�ֲ�
//		238
//		012�ֲ�
//		153
//		0��int������ֲ�
//		139
	}

}
