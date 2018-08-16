package Chapter02.Section04;

public class S2_4_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPQ pq=new MaxPQ<String>(10);
		String[] s= {"P","R","I","O","*","R","*","*","I","*","T","*","Y","*","*","*","Q","U","E","*","*","*","U","*","E"};
		for(int i=0;i<s.length;i++) {
			if(s[i].equals("*")) {
				System.out.print(pq.delMax()+" ");
			}else {
				pq.insert(s[i]);
			}
			pq.show();
		}
	}

}
