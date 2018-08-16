package Chapter02.Section04;

public class S2_4_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPQ pq=new MaxPQ<String>(15);
		String[] s= {"E","A","S","Y","Q","U","E","S","T","I","O","N"};
		for(int i=0;i<s.length;i++) {
			pq.insert(s[i]);
		}
		pq.show();
	}

}
