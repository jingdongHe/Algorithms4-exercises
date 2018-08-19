package Chapter02.Section05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Job implements Comparable<Job>{
	long start;
	long end;
	public Job(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Job o) {
		// TODO Auto-generated method stub
		if(this.end<o.end) return -1;
		if(this.end>o.end) return 1;
		return 0;
	}
}

public class S2_5_20 {
	private static void getTime(Job[] jobs,int N) {
		Arrays.sort(jobs, new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				// TODO Auto-generated method stub
				if(o1.start<o2.start) return -1;
				if(o1.start>o2.start) return 1;
				if(o1.end<o2.end) return -1;
				if(o1.end>o2.end) return 1;
				return 0;
			}
		});
		
		PriorityQueue<Job> big=new PriorityQueue<>(new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				// TODO Auto-generated method stub
				if(o1.end<o2.end) return 1;
				if(o1.end>o2.end) return -1;
				return 0;
			}
		});
		PriorityQueue<Job> small=new PriorityQueue<>(new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				// TODO Auto-generated method stub
				if(o1.end<o2.end) return -1;
				if(o1.end>o2.end) return 1;
				return 0;
			}
		});
		for(int i=0;i<N;i++)
			small.add(new Job(0, 0));
		
		long free=0,busy=0;
		long start=0,end=0;
		for(int i=0;i<jobs.length;i++) {
			big.clear();
			big.addAll(small);
			Job temp=big.poll();
			
			// 存在空闲时间
			if(jobs[i].start-temp.end>0) {
				end=temp.end;
				if(end-start>busy)
					busy=end-start;
				start=jobs[i].start;
				
				if(jobs[i].start-temp.end>free) 
					free=jobs[i].start-temp.end;
			}
			
			temp=small.poll();
			if(jobs[i].start>temp.end)
				temp.start=jobs[i].start;
			if(jobs[i].end>temp.end)
				temp.end=jobs[i].end;
			small.add(temp);
		}
		
		big.clear();
		big.addAll(small);
		Job temp=big.poll();
		end=temp.end;
		if(end-start>busy)
			busy=end-start;
		System.out.println("free: "+free+" busy: "+busy);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1、对任务进行排序（开始时间为key）
		// 2、为同一份数据，建立大顶堆和小顶堆
		// 3、小顶堆用于数据输入，大顶堆用于时间的维护
		// 4、判断空闲：jobs[i].start>big.poll().end
		// 5、判断繁忙：2个空闲时间之间为繁忙；end-start;start=上一个空闲时间 后 第一个job的start;end=big.poll().end
		Job[] jobs= {
				new Job(0, 1),
				new Job(3, 3),
				new Job(3, 4),
				new Job(3, 6)
		};
		getTime(jobs, 3);
	}

}
