package Chapter02.Section02;

public class S2_2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"A","E","Q","S","U","Y","E","I","N","O","S","T"};
		
		InplaceMergeSort sort=new MergeSortByBottom();
		sort.sort(s);
		Merging.print(s);
	}

}
