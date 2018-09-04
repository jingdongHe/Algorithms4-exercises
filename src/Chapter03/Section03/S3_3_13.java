package Chapter03.Section03;

public class S3_3_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackBST<String, String> bst = new RedBlackBST<>();
		for (char a = 'A'; a <= 'Z'; a++) {
			bst.put(a+"", null);
			System.out.println((int)(a-'A')+":"+bst.height());
		}
	}
	
	// 红黑树的高度单调递增
//	0:1
//	1:1
//	2:2
//	3:2
//	4:2
//	5:2
//	6:3
//	7:3
//	8:3
//	9:3
//	10:3
//	11:3
//	12:3
//	13:3
//	14:4
//	15:4
//	16:4
//	17:4
//	18:4
//	19:4
//	20:4
//	21:4
//	22:4
//	23:4
//	24:4
//	25:4

}
