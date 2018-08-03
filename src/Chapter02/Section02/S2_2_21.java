package Chapter02.Section02;

public class S2_2_21 {

	private static String getSame(String[] s1,String[] s2,String[] s3) {
		int i=0,j=0,k=0;
		while(true) {
			if(s1[i].compareTo(s2[j])<0||s1[i].compareTo(s3[k])<0) i++;
			if(i>=s1.length) break;
			if(s2[j].compareTo(s1[i])<0||s2[j].compareTo(s3[k])<0) j++;
			if(j>=s2.length) break;
			if(s3[k].compareTo(s1[i])<0||s3[k].compareTo(s2[j])<0) k++;
			if(k>=s3.length) break;
			if(s1[i].compareTo(s2[j])==0&&s1[i].compareTo(s3[k])==0)	return s1[i];
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s1= {"asdf","wer","dfgh","23456","abc"};
		String[] s2= {"abc","7867896+","cvbncbv","23cvbn456","atyurbc"};
		String[] s3= {"zxcv","wqqqqqer","abc","yy","9hguk"};
		
		InplaceMergeSort sort=new InplaceMergeSort();
		sort.sort(s1);
		for(String s:s1)	System.out.print(s+" ");
		System.out.println();
		sort.sort(s2);
		for(String s:s2)	System.out.print(s+" ");
		System.out.println();
		sort.sort(s3);
		for(String s:s3)	System.out.print(s+" ");
		System.out.println();
		
		System.out.println(getSame(s1, s2, s3));
	}

}
