package Chapter01.Section01;

public class S1_1_37 {
	public static void badShuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
        	int r=(int) (Math.random()*N);     // between 0 and N-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

	public static void main(String[] args) {
		S1_1_36.IShuffle shuffle=new S1_1_36.IShuffle() {

			@Override
			public void shuffle(int[] a) {
				badShuffle(a);
			}
			
		};
		S1_1_36.ShuffleTest(shuffle, 10, 100);
	}

}
