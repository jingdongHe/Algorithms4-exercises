package Chapter02.Section01;

import java.util.Random;

public class S2_1_35 {
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
	public static double geometric(double p,int r) //���ηֲ�
    {
        double PX=0;   //PX�ǵ�һ�γɹ��ĸ��ʣ���ʼ��Ϊ0
        double q=1-p;  //q��ʧ�ܵĸ��ʣ�����p��q���⣬��q=1-p
        double k=(double)(r-1);
        PX= p*(Math.pow(q, k));//���� P(X=r)=pq^{r-1}��ʽ������ʣ�����k��double���Ͳ���
        return PX;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int N = 10000;

		System.out.println("��˹�ֲ�");
		Double[] gaussian = new Double[N];
		for (int i = 0; i < N; i++)
			gaussian[i] = r.nextGaussian();
		S2_1_34.test(gaussian);
		
		System.out.println("���ɷֲ�");
		Double[] poisson=new Double[N];
		for (int i = 0; i < N; i++)
			poisson[i] = pRand(10);
		S2_1_34.test(poisson);
		
		System.out.println("���ηֲ�");
		Double[] geometric=new Double[N];
		for (int i = 0; i < N; i++)
			geometric[i] = geometric(0.1,10);
		S2_1_34.test(geometric);
		
		// ϣ�����򣬶Դ�����ֲ���Ч�����ܺ�
		// ѡ������Ч�����
		// ���������ڼ��ηֲ���Ч���ܺã��ڸ�˹�ֲ���Ч������ѡ�����򻹲�
	}

}
