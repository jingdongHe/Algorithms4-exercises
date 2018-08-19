package Chapter02.Section05;

import java.util.Arrays;

class Vector implements Comparable<Vector>{
	int[] a;

	public Vector(int[] a) {
		super();
		this.a = a;
	}

	@Override
	public int compareTo(Vector o) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.a.length;i++) {
			if(this.a[i]>o.a[i]) return 1;
			if(this.a[i]<o.a[i]) return -1;
		}
		return 0;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s="";
		for(int i=0;i<this.a.length;i++)
			s=s+a[i]+" ";
		return s;
	}
}
public class S2_5_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector[] vectors= {
				new Vector(new int[] {3,2,1}),
				new Vector(new int[] {1,2,3}),
				new Vector(new int[] {3,1,1})
		};
		for(int i=0;i<vectors.length;i++)
			System.out.println(vectors[i]);
		System.out.println("=================");
		Arrays.sort(vectors);
		for(int i=0;i<vectors.length;i++)
			System.out.println(vectors[i]);
	}

}
