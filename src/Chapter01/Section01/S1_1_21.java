package Chapter01.Section01;

import java.util.Scanner;

public class S1_1_21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s=null;
        while (!(s = sc.nextLine()).equals("")) {
            String[] str = s.split(" ");
            int[] val= {0,Integer.parseInt(str[1]),Integer.parseInt(str[2])};
            System.out.printf("%s:%4d,%4d,%.3f\n",str[0],val[1],val[2],val[1]*1.0/val[2]);
        }
	}

}
