package Chapter01.Section01;

public class S1_1_11 {

	public static void main(String[] args) {
		boolean[][] table={
				{true,false,true,false},
				{false,true,false,true},
				{true,false,true,false},
				{false,true,false,true}
		};
		for(int i=0;i<table[0].length+1;i++) 
			System.out.print(i);
		System.out.println();
		for(int i=0;i<table.length;i++) {
			System.out.print(i+1);
			for(int j=0;j<table[i].length;j++) {
				System.out.printf(table[i][j]?"*":" ");
//				if(table[i][j])
//					System.out.printf("*");
//				else
//					System.out.printf(" ");
			}
			System.out.println();
		}
	}

}
