package Chapter02.Section01;

import java.util.Random;

public class S2_1_35 {
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
	public static double geometric(double p,int r) //几何分布
    {
        double PX=0;   //PX是第一次成功的概率，初始化为0
        double q=1-p;  //q是失败的概率，由于p，q互斥，则q=1-p
        double k=(double)(r-1);
        PX= p*(Math.pow(q, k));//根据 P(X=r)=pq^{r-1}公式计算概率，其中k我double类型参数
        return PX;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int N = 10000;

		System.out.println("高斯分布");
		Double[] gaussian = new Double[N];
		for (int i = 0; i < N; i++)
			gaussian[i] = r.nextGaussian();
		S2_1_34.test(gaussian);
		
		System.out.println("泊松分布");
		Double[] poisson=new Double[N];
		for (int i = 0; i < N; i++)
			poisson[i] = pRand(10);
		S2_1_34.test(poisson);
		
		System.out.println("几何分布");
		Double[] geometric=new Double[N];
		for (int i = 0; i < N; i++)
			geometric[i] = geometric(0.1,10);
		S2_1_34.test(geometric);
		
		// 希尔排序，对大多数分布的效果都很好
		// 选择排序效果最差
		// 插入排序在几何分布中效果很好，在高斯分布中效果最差，比选择排序还差
	}

}
