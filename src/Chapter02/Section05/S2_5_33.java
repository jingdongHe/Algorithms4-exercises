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
			System.out.print("希尔排序 ");
			Shell shell=new Shell();
			startTime=System.currentTimeMillis();
			shell.sort(transaction.clone());
			System.out.println("time:" + (System.currentTimeMillis() - startTime));
			
			System.out.print("归并排序 ");
			InplaceMergeSort merge=new InplaceMergeSort();
			startTime=System.currentTimeMillis();
			merge.sort(transaction.clone());
			System.out.println("time:" + (System.currentTimeMillis() - startTime));
			
			System.out.print("快速排序 ");
			startTime=System.currentTimeMillis();
			Arrays.sort(transaction.clone());
			System.out.println("time:" + (System.currentTimeMillis() - startTime));
			
			System.out.print("堆排序      ");
			startTime=System.currentTimeMillis();
			MaxPQ pq=new MaxPQ<Transaction>(transaction.clone());
			while(!pq.isEmpty())
				pq.delMax();
			System.out.println("time:" + (System.currentTimeMillis() - startTime));
			System.out.println("================");
			
			// 对于该对象来说，归并排序的性能较好，堆排序最慢（存在压入弹出2个功能）
//			N: 1000
//			希尔排序 time:3
//			归并排序 time:1
//			快速排序 time:2
//			堆排序      time:4
//			================
//			N: 10000
//			希尔排序 time:14
//			归并排序 time:8
//			快速排序 time:21
//			堆排序      time:35
//			================
//			N: 100000
//			希尔排序 time:115
//			归并排序 time:109
//			快速排序 time:90
//			堆排序      time:114
//			================
//			N: 1000000
//			希尔排序 time:1948
//			归并排序 time:684
//			快速排序 time:918
//			堆排序      time:1259
//			================
		}
	}

}
