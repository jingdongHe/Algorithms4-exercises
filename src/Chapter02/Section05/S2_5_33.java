package Chapter02.Section05;

import java.util.Arrays;
import java.util.Date;

import Chapter02.Section01.Shell;
import Chapter02.Section01.Transaction;
import Chapter02.Section02.InplaceMergeSort;
import Chapter02.Section03.Quick;
import Chapter02.Section04.MaxPQ;

public class S2_5_33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction[] transaction;
		long startTime;
		
		for(int N=1000;N<=1000000;N*=10) {
			transaction=new Transaction[N];
			for(int i=0;i<N;i++) {
				transaction[i]=new Transaction("hejd", new Date(), (float) (Math.random()*N));
			}
			System.out.println("N: "+N);
			System.out.print("ϣ������ ");
			Shell shell=new Shell();
			startTime=System.currentTimeMillis();
			shell.sort(transaction.clone());
			System.out.println("time:" + (System.currentTimeMillis() - startTime));
			
			System.out.print("�鲢���� ");
			InplaceMergeSort merge=new InplaceMergeSort();
			startTime=System.currentTimeMillis();
			merge.sort(transaction.clone());
			System.out.println("time:" + (System.currentTimeMillis() - startTime));
			
			System.out.print("�������� ");
			startTime=System.currentTimeMillis();
			Arrays.sort(transaction.clone());
			System.out.println("time:" + (System.currentTimeMillis() - startTime));
			
			System.out.print("������      ");
			startTime=System.currentTimeMillis();
			MaxPQ pq=new MaxPQ<Transaction>(transaction.clone());
			while(!pq.isEmpty())
				pq.delMax();
			System.out.println("time:" + (System.currentTimeMillis() - startTime));
			System.out.println("================");
			
			// ���ڸö�����˵���鲢��������ܽϺã�����������������ѹ�뵯��2�����ܣ�
//			N: 1000
//			ϣ������ time:3
//			�鲢���� time:1
//			�������� time:2
//			������      time:4
//			================
//			N: 10000
//			ϣ������ time:14
//			�鲢���� time:8
//			�������� time:21
//			������      time:35
//			================
//			N: 100000
//			ϣ������ time:115
//			�鲢���� time:109
//			�������� time:90
//			������      time:114
//			================
//			N: 1000000
//			ϣ������ time:1948
//			�鲢���� time:684
//			�������� time:918
//			������      time:1259
//			================
		}
	}

}
