package Chapter02.Section03;

class QuickInTrack extends Quick{
	@Override
	void sort(Comparable[] a,int lo,int hi) {
		for(Comparable i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
}

public class S2_3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quick quick=new QuickInTrack();
		String[] s= {"A","E","Q","S","U","Y","E","I","N","O","S","T"};
		
		quick.sort(s);
		for(String i:s) {
			System.out.print(i);
		}
	}

}
