package Chapter02.Section01;

public class S2_1_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t=2;
		int N=1000000,T=1;
		
		SortCompare compare=new SortCompare();
		System.out.println("Ï£¶ûÅÅÐò");
		double time01=0;
		for(int i=0;i<8;i++) {
			int time=0;
			while(Math.pow(t+i, time)<N/3) time++;
			time++;
			int[] list=new int[time];
			for(int j=0;j<time;j++) {
				list[j]=(int) Math.pow(t+i, j);
			}
			for(int j=0;j<time;j++)
				System.out.print(list[j]+" ");
			System.out.println();
			time01=compare.timeShellInList(new ShellInList(), N, T,list);
			System.out.println(String.format("N:%7d;t:%3d\ntime:%7.1f;", N,t+i,time01));
		}
	}
	
//	Ï£¶ûÅÅÐò
//	1 2 4 8 16 32 64 128 256 512 1024 2048 4096 8192 16384 32768 65536 131072 262144 524288 
//	N:1000000;t:  2
//	time:20466.0;
//	1 3 9 27 81 243 729 2187 6561 19683 59049 177147 531441 
//	N:1000000;t:  3
//	time:17163.0;
//	1 4 16 64 256 1024 4096 16384 65536 262144 1048576 
//	N:1000000;t:  4
//	time:20033.0;
//	1 5 25 125 625 3125 15625 78125 390625 
//	N:1000000;t:  5
//	time:10905.0;
//	1 6 36 216 1296 7776 46656 279936 1679616 
//	N:1000000;t:  6
//	time:13931.0;
//	1 7 49 343 2401 16807 117649 823543 
//	N:1000000;t:  7
//	time:12095.0;
//	1 8 64 512 4096 32768 262144 2097152 
//	N:1000000;t:  8
//	time:13612.0;
//	1 9 81 729 6561 59049 531441 
//	N:1000000;t:  9
//	time:13904.0;

}
