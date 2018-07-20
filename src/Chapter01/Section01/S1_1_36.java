package Chapter01.Section01;

public class S1_1_36 {
//	private static void shuffle(int[] a) {
//		int N=a.length;
//		for(int i=0;i<N;i++) {
//			int r=(int) (i+Math.random()*(N-i));
//			int temp=a[i];
//			a[i]=a[r];
//			a[r]=temp;
//		}
//	}
//	private static double[][] shuffleTest(int M,int N) {
//		double[][] count=new double[M][M];
//		int[] a= new int[M];
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++)
//				a[j]=j;
//			shuffle(a);
//			for(int j=0;j<M;j++)
//				count[j][a[j]]++;
//		}
//		return count;
//	}
//	public static void main(String[] args) {
//		double[][] count=shuffleTest(10, 100);
//		for(int i=0;i<count.length;i++) {
//			for(int j=0;j<count[i].length;j++)
//				System.out.printf("%6d",(int)count[i][j]);
//			System.out.println();
//		}
//		
//	}
	
	public interface IShuffle
    {
        public void shuffle(int[] a);
    }
	public static void ShuffleTest(IShuffle shuffle, int m, int n)
    {
        int[][] s = new int[m][m];
        
        for (int k = 0; k < n; k++)
        {
            int[] a = new int[m];
            for (int i = 0; i < m; i++)
                a[i] = i;
            
            shuffle.shuffle(a);
            
            for (int i = 0; i < m; i++)
                s[i][a[i]]++;
        }
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < m; j++)
                System.out.printf("%7d", s[i][j]);
            System.out.println();
        }
    }
	
	public static void main(String[] args)
    {
        int m = 10;
        int n = 100;
        
        // closure
        IShuffle shuffle = new IShuffle()
        {
            public void shuffle(int[] a)
            {
        		int N=a.length;
        		for(int i=0;i<N;i++) {
        			int r=(int) (i+Math.random()*(N-i));
        			int temp=a[i];
        			a[i]=a[r];
        			a[r]=temp;
        		}
            }
        };
        
        ShuffleTest(shuffle, m, n);
    }

}
