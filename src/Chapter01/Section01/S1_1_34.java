package Chapter01.Section01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//return Math.random()>.5 ? -1 : 1;

class Shuffle implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		return Math.random()>.5 ? -1 : 1;
	}
}


public class S1_1_34 {

	public static void main(String[] args) {
		// 此处偷懒，直接用内置的排序，取值完事
		
		double[] ary= {.1,.2,.9,.5,.9,.5,.4,.6,.1,.7};
		int k=3;
		
		Arrays.sort(ary);
		
		System.out.println(ary[0]+" "+ary[ary.length-1]);
		System.out.println(ary[(int) (Math.ceil(ary.length/2)-1)]);
		System.out.println(ary[k-1]);
		
		double sqrtSum=0;
		for(int i=0;i<ary.length;i++)
			sqrtSum+=ary[i]*ary[i];
		System.out.println(sqrtSum);
		
		double sum=0;
		for(int i=0;i<ary.length;i++)
			sum+=ary[i];
		System.out.println(sum/ary.length);
		
		int count=0;
		while(ary[count]<=sum/ary.length) {
			count++;
		}
		System.out.println((1-(count*1.0)/ary.length)*100+"%");
		
		for(int i=0;i<ary.length;i++)
			System.out.print(ary[i]+" ");
		System.out.println();
		
		List<Double> arylist=new ArrayList<Double>();
		for(int i=0;i<ary.length;i++)
			arylist.add(ary[i]);
		for(int i=0;i<arylist.size();i++){  
            System.out.print(arylist.get(i)+" ");
        }  
		System.out.println();
		Collections.sort(arylist,new Shuffle());
		for(int i=0;i<arylist.size();i++){  
            System.out.print(arylist.get(i)+" ");
        }  
		System.out.println();
	}

}
