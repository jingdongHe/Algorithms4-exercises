package Chapter03.Section01;

import java.util.HashMap;
import java.util.Map;

public class S3_1_7 {
	public static void frequencyCounter(int N) {
		int count=0;int time=10;
		while(time-->0) {
			Map map=new HashMap<Integer,Integer>();
			for(int i=0;i<N;i++) {
				map.put((int)(Math.random()*1000), 0);
			}
			count+=map.size();
		}
		System.out.println(N+":"+count*1.0/10);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=10;i<=1000000;i*=10) {
			frequencyCounter(i);
		}

//		10:9.8
//		100:96.0
//		1000:629.9
//		10000:1000.0
//		100000:1000.0
//		1000000:1000.0

	}

}
