package Chapter03.Section03;

class RedBlackBSTWithCounter<Key extends Comparable<Key>, Value> extends RedBlackBST{
	int rotate,broke;
	@Override
	public Node rotateLeft(Node h) {
		// TODO Auto-generated method stub
		rotate++;
		return super.rotateLeft(h);
	}
	@Override
	public Node rotateRight(Node h) {
		// TODO Auto-generated method stub
		rotate++;
		return super.rotateRight(h);
	}
	@Override
	protected void flipColors(Node h) {
		// TODO Auto-generated method stub
		broke++;
		super.flipColors(h);
	}
	public void statistics() {
		System.out.println(String.format("N:%5d;rotate:%4d(%4.2f);broke:%4d(%4.2f)", root.N,rotate,rotate*1.0/root.N,broke,broke*1.0/root.N));
	}
}

public class S3_3_45 {
	
	private static void create(int N) {
		RedBlackBSTWithCounter<Integer, String> bst=new RedBlackBSTWithCounter<>();
		for(int i=0;i<N;i++)
			bst.put((int) (Math.random()*N), null);
		bst.statistics();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=100;i<=10000;i+=100)
			create(i);
	}

}
