package Chapter02.Section01;

public class S2_1_34 {

	public static void test(Comparable[] a) {
		Sort shell = new Shell();
		Sort insert = new Insertion();
		Sort selection = new Selection();
		
		System.out.println("================================");
//		Sort.show(a);
		Comparable[] a1 = a.clone(), a2 = a.clone(), a3 = a.clone();
		long startTime;

		startTime = System.currentTimeMillis();
		System.out.println("ϣ������");
		shell.sort(a1);
//		Sort.show(a1);
		System.out.println("time:" + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		System.out.println("----------");

		System.out.println("��������");
		insert.sort(a2);
//		Sort.show(a2);
		System.out.println("time:" + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		System.out.println("----------");

		System.out.println("ѡ������");
		selection.sort(a3);
//		Sort.show(a3);
		System.out.println("time:" + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		System.out.println("----------");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 10000;
		Integer[] a = new Integer[N];
		// ˳��
		System.out.println("˳��");
		for (int i = 0; i < N; i++)
			a[i] = i;
		test(a);
		// ����
		System.out.println("����");
		for (int i = 0; i < N; i++)
			a[i] = N - i;
		test(a);
		// ȫ����ͬ
		System.out.println("ȫ����ͬ");
		for (int i = 0; i < N; i++)
			a[i] = 888;
		test(a);
		// ����ֻ��2�����
		System.out.println("����ֻ��2�����");
		for (int i = 0; i < N; i++)
			a[i] = Math.random()<0.5?0:1;
		test(a);
		// ����Ϊ1
		System.out.println("����Ϊ1");
		test(new Integer[] {1});
		// ����Ϊ0
		System.out.println("����Ϊ0");
		test(new Integer[] {});
	}

}
