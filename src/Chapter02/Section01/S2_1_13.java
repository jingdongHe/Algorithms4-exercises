package Chapter02.Section01;

import java.util.Arrays;
import java.util.Comparator;

public class S2_1_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 初始化乱序数组，数组大小为52，代表4个花色各13张牌
		// 根据题干，最多只能同时访问2张牌
		// 此题使用本节3中排序方式均可进行排序
		
		int N=52;
		Integer[] poker=new Integer[N];
		for(int i=0;i<N;i++)
			poker[i]=i+1;
		Arrays.sort(poker, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return Math.random()>=0.5?1:-1;
			}
		});
		
		Selection selection=new Selection();
		Sort.show(poker);
		selection.sort(poker);
		Sort.show(poker);
	}

}
