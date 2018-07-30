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
		System.out.println("希尔排序");
		shell.sort(a1);
//		Sort.show(a1);
		System.out.println("time:" + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		System.out.println("----------");

		System.out.println("插入排序");
		insert.sort(a2);
//		Sort.show(a2);
		System.out.println("time:" + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		System.out.println("----------");

		System.out.println("选择排序");
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
		// 顺序
		System.out.println("顺序");
		for (int i = 0; i < N; i++)
			a[i] = i;
		test(a);
		// 逆序
		System.out.println("逆序");
		for (int i = 0; i < N; i++)
			a[i] = N - i;
		test(a);
		// 全部相同
		System.out.println("全部相同");
		for (int i = 0; i < N; i++)
			a[i] = 888;
		test(a);
		// 主键只有2种情况
		System.out.println("主键只有2种情况");
		for (int i = 0; i < N; i++)
			a[i] = Math.random()<0.5?0:1;
		test(a);
		// 长度为1
		System.out.println("长度为1");
		test(new Integer[] {1});
		// 长度为0
		System.out.println("长度为0");
		test(new Integer[] {});
	}

}
