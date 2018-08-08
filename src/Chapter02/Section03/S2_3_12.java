package Chapter02.Section03;

public class S2_3_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"B","A","B","A","B","A","B","A","C","A","D","A","B","R","A"};
//		当以B为第一个值进行排序时，信息量最佳
		Quick quick=new QuickWithoutShuffle();
		quick.sort(s);
	}

}
