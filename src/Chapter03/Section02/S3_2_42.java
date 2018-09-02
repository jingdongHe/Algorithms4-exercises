package Chapter03.Section02;

public class S3_2_42 {
	private static void hibbard(int N) {
		BST<Integer, Integer> bst=new BST<>();
		for(int i=0;i<N;i++)
			bst.put((int) (Math.random()*N), null);
		
		for(int i=0;i<N*N;i++) {
			bst.delete(bst.select((int) (Math.random()*N)));
			bst.put((int) (Math.random()*N), null);
		}
		System.out.println(N+":"+bst.avgCompares());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hibbard(100);
		hibbard(1000);
		hibbard(10000);
		
//		100  :3.723404255319149 sqrt(100  )=10  
//		1000 :4.349112426035503 sqrt(1000 )=31  0.62
//		10000:4.569463823001794 sqrt(10000)=100 0.22
		
//		100  :4.173913043478261 sqrt(100  )=10  
//		1000 :4.392785571142284 sqrt(1000 )=31  0.22
//		10000:4.438399369209541 sqrt(10000)=100 0.04
	}

}
