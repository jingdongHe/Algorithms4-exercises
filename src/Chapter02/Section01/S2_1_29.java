package Chapter02.Section01;

public class S2_1_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=128,T=5;
		
		SortCompare compare=new SortCompare();
		System.out.println("希尔排序");
		double time01=0,time02=0;
		for(int i=0;i<8;i++) {
			time01=compare.timeShellInList(new ShellInList(), (int) (N*Math.pow(2,i)), T,new int[]{1,4,13,40,121,364,1093,3280,9841});
			time02=compare.timeShellInList(new ShellInList(), (int) (N*Math.pow(2,i)), T,new int[]{1,5,19,41,109,209,505,929,2161,3905,8929});
			System.out.println(String.format("N:%7d;\n time01:%7.1f; time02:%7.1f; ratio:%3.2f", (int) (N*Math.pow(2,i)),time01,time02,time01/time02));
		}
		// 大多数情况下，使用新的递增序列较原本的递增序列快
	}

}
