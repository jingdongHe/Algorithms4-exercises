package Chapter02.Section01;

public class S2_1_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N=128,T=5;
		
		SortCompare compare=new SortCompare();
		System.out.println("Ï£¶ûÅÅÐò");
		double time=0,prev=0;
		for(int i=0;i<10;i++) {
			time=compare.timeRandomInput(new Shell(), (int) (N*Math.pow(2,i)), T);
			System.out.println(String.format("N:%7d; prev:%7.1f; time:%7.1f; ratio:%3.2f", (int) (N*Math.pow(2,i)),prev,time,time/prev));
			prev=time;
		}
		
		System.out.println("²åÈëÅÅÐò");
		time=0;prev=0;
		for(int i=0;i<10;i++) {
			time=compare.timeRandomInput(new Insertion(), (int) (N*Math.pow(2,i)), T);
			System.out.println(String.format("N:%7d; prev:%7.1f; time:%7.1f; ratio:%3.2f", (int) (N*Math.pow(2,i)),prev,time,time/prev));
			prev=time;
		}
		
		System.out.println("Ñ¡ÔñÅÅÐò");
		time=0;prev=0;
		for(int i=0;i<10;i++) {
			time=compare.timeRandomInput(new Selection(), (int) (N*Math.pow(2,i)), T);
			System.out.println(String.format("N:%7d; prev:%7.1f; time:%7.1f; ratio:%3.2f", (int) (N*Math.pow(2,i)),prev,time,time/prev));
			prev=time;
		}
	}

}
