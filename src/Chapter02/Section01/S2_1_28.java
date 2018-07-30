package Chapter02.Section01;

public class S2_1_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortCompare compare=new SortCompare();
		int N=128,T=10;
		
		System.out.println("插入排序");
		for(int i=0;i<7;i++) {
			System.out.println(String.format("N:%7d; time:%7.1f;", (int) (N*Math.pow(2,i)),compare.time2Input(new Insertion(), (int) (N*Math.pow(2,i)), T)));
			System.out.println(String.format("N:%7d; time:%7.1f;", (int) (N*Math.pow(2,i)),compare.timeRandomInput(new Insertion(), (int) (N*Math.pow(2,i)), T)));
			System.out.println("----------");
		}
		
		System.out.println("选择排序");
		for(int i=0;i<7;i++) {
			System.out.println(String.format("N:%7d; time:%7.1f;", (int) (N*Math.pow(2,i)),compare.time2Input(new Selection(), (int) (N*Math.pow(2,i)), T)));
			System.out.println(String.format("N:%7d; time:%7.1f;", (int) (N*Math.pow(2,i)),compare.timeRandomInput(new Selection(), (int) (N*Math.pow(2,i)), T)));
			System.out.println("-----------");
		}
		// 对于插入排序，相等的主键，会提高性能
		// 对于选择排序，相等的主键，对性能无影响
	}

}
