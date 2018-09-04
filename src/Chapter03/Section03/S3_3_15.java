package Chapter03.Section03;

public class S3_3_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackBST<String, String> bst = new RedBlackBST<>();
		for (char a = 'Z'; a >= 'A'; a--) {
			bst.put(a + "", null);
			System.out.println((int)('Z'-a)+":"+bst.height());
		}
		bst.print();
		// 树的高度单调递增，但增速较低
		// 在建树过程中，会不断进行左右转换来维持树的平衡
		// 对比正序建树，逆序会产生一个类纺锥形的效果
		
//		0:1
//		1:1
//		2:2
//		3:2
//		4:2
//		5:2
//		6:3
//		7:3
//		8:3
//		9:3
//		10:3
//		11:3
//		12:3
//		13:3
//		14:4
//		15:4
//		16:4
//		17:4
//		18:4
//		19:4
//		20:4
//		21:4
//		22:4
//		23:4
//		24:4
//		25:4
//		S(null),
//		K(S-l(R)),W(S-r(R)),
//		G(K-l(B)),O(K-r(B)),U(W-l(B)),Y(W-r(B)),
//		E(G-l(B)),I(G-r(B)),M(O-l(B)),Q(O-r(B)),T(U-l(B)),V(U-r(B)),X(Y-l(B)),Z(Y-r(B)),
//		C(E-l(R)),F(E-r(R)),H(I-l(B)),J(I-r(B)),L(M-l(B)),N(M-r(B)),P(Q-l(B)),R(Q-r(B)),
//		B(C-l(B)),D(C-r(B)),
//		A(B-l(R)),

	}

}
