package Chapter01.Section01;

public class S1_1_5 {

	public static void main(String[] args) {
		double x=Double.parseDouble(args[0]);
		double y=Double.parseDouble(args[1]);
		
		if(x>0&&x<1&&y>0&&y<1) {
			System.out.println(true);
		}
		else
			System.out.println(false);

	}

}
