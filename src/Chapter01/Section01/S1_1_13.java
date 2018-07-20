package Chapter01.Section01;

public class S1_1_13 {
	private static int[][] transpose(int[][] table) {
		int[][] transpositionTable=new int[table[0].length][table.length];
		for(int i=0;i<table.length;i++) {
			for(int j=0;j<table[i].length;j++) {
				transpositionTable[j][i]=table[i][j];
			}
		}
		return transpositionTable;
	}
	public static void main(String[] args) {
		int[][] table= {
				{1,1,1,1},
				{2,2,2,2},
				{3,3,3,3},
				{4,4,4,4}
		};
		int[][] transpositionTable=transpose(table);
		for(int i=0;i<transpositionTable.length;i++) {
			for(int j=0;j<transpositionTable[i].length;j++) {
				System.out.print(transpositionTable[i][j]);
			}
			System.out.println();
		}

	}

}
