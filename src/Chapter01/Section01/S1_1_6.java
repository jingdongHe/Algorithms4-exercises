package Chapter01.Section01;

public class S1_1_6 {

	public static void main(String[] args) {
		int f=0;
		int g=1;
		
		for(int i=0;i<=15;i++) {
			f=f+g;
			g=f-g;
			System.out.printf("f = %s, g = %s\n", f, g);
		}
	}

}
