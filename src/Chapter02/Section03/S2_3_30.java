package Chapter02.Section03;

import java.util.Random;

import Chapter02.Section01.S2_1_34;
import Chapter02.Section01.Shell;
import Chapter02.Section01.Sort;

public class S2_3_30 {
	private static double pRand(double Lamda) { // 泊松分布
		double x = 0, b = 1, c = Math.exp(-Lamda), u;
		do {
			u = Math.random();
			b *= u;
			if (b >= c)
				x++;
		} while (b >= c);
		return x;
	}
	private static double geometric(double p,int r) //几何分布
    {
        double PX=0;   //PX是第一次成功的概率，初始化为0
        double q=1-p;  //q是失败的概率，由于p，q互斥，则q=1-p
        double k=(double)(r-1);
        PX= p*(Math.pow(q, k));//根据 P(X=r)=pq^{r-1}公式计算概率，其中k我double类型参数
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
		
		System.out.println("高斯分布");
		Double[] gaussian = new Double[N];
		for (int i = 0; i < N; i++)
			gaussian[i] = r.nextGaussian();
		test(gaussian);
		
		System.out.println("泊松分布");
		Double[] poisson=new Double[N];
		for (int i = 0; i < N; i++)
			poisson[i] = pRand(10);
		test(poisson);
		
		System.out.println("几何分布");
		Double[] geometric=new Double[N];
		for (int i = 0; i < N; i++)
			geometric[i] = geometric(0.1,10);
		test(geometric);
		
		Integer[] a=new Integer[N];
		System.out.println("01分布");
		for(int i=0;i<N;i++)
			a[i]=Math.random()<0.5?0:1;
		test(a);
		
		System.out.println("012分布");
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
		
		System.out.println("0与int随机数分布");
		for(int i=0;i<N;i++)
			a[i]=(int) (Math.random()<0.5?0:Math.random()*N);
		test(a);
		
		
		// 几何分布在数学分布中，效率较高；01分布在有限内容分布中效率较低
//		高斯分布
//		423
//		泊松分布
//		308
//		几何分布
//		262
//		01分布
//		238
//		012分布
//		153
//		0与int随机数分布
//		139
	}

}
