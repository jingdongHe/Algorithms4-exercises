package Chapter02.Section01;

import java.util.UUID;

public class S2_1_38 {
	private static String getString() {
		return UUID.randomUUID().toString().replace("-", ""); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=10000;
		Comparable[] a=new Comparable[N];
		
		System.out.println("�ַ����д���double");
		for(int i=0;i<N;i++)
			a[i]=getString();
		a[(int) (Math.random()*N)]=0.01;
		S2_1_34.test(a);
		
		System.out.println("double�д����ַ���");
		for(int i=0;i<N;i++)
			a[i]=Math.random()*N;
		a[(int) (Math.random()*N)]="this is string test";
		S2_1_34.test(a);
		
		System.out.println("int�д���int[20]");
		// �˴�����int[20] ����ʵ��comparable��ʹ��(new int[20])[0] ����ǿʵ�֣������ָ��õķ���������
		for(int i=0;i<N;i++)
			a[i]=(int) (Math.random()*N);
		a[(int) (Math.random()*N)]=new Comparable() {

			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return (new int[20])[0];
			}
		};
		S2_1_34.test(a);
		
		// �˴������ͬ���͵����ݽ��жԱ�ʱ�����׳�ClassCastException,��˫��ת��Ϊ�ַ������бȽ�
		// ά��ԭ�н��ۣ�ϣ��������죻���������֮��ѡ������������
	}

}
