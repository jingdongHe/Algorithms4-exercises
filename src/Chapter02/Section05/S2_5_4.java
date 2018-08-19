package Chapter02.Section05;

import java.util.Arrays;

public class S2_5_4 {
	
	private static String[] dedup(String[] a) {
		int samCount=0;
		int j=0;
		Arrays.sort(a);
		for(int i=1;i<a.length;i++)
			if(a[i]==a[i-1])
			{
				a[i-1]=null;
				samCount++;
			}
		String[] result=new String[a.length-samCount];
		for(int i=0;i<a.length;i++)
			if(a[i]!=null) result[j++]=a[i];
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a= {"1","1","1","2","3","3","3","3"};
		String[] b=dedup(a);
		for(int i=0;i<b.length;i++)
			System.out.print(b[i]+" ");
	}

}
