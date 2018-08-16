package Chapter02.Section04;

public class S2_4_15 {

	private static boolean isMinPQ(Comparable[] a) {
		for(int i=1;i<a.length;i++) {
			if(i*2<a.length&&a[i].compareTo(a[i*2])>0)
				return false;
			if(i*2+1<a.length&&a[i].compareTo(a[i*2+1])>0)
				return false;
		}
		return true;
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a1= {null,1,2,3,4,5,6,7,8,9};
		Integer[] a2= {null,9,2,3,4,5,6,7,8,9};
		
		System.out.println("a1 is min pq? "+isMinPQ(a1));
		System.out.println("a2 is min pq? "+isMinPQ(a2));
	}

}
