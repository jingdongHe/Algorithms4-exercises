package Chapter02.Section05;

import java.util.Arrays;

class Version implements Comparable<Version>{
	int a,b,c;

	public Version(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Version o) {
		// TODO Auto-generated method stub
		if(this.a>o.a) return 1;
		if(this.a<o.a) return -1;
		if(this.b>o.b) return 1;
		if(this.b<o.b) return -1;
		if(this.c>o.c) return 1;
		if(this.c<o.c) return -1;
		return 0;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return a+"."+b+"."+c;
	}
}

public class S2_5_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Version[] versions=new Version[3];
		versions[0]=new Version(115, 10, 1);
		versions[1]=new Version(115, 1, 1);
		versions[2]=new Version(115, 10, 2);
		
		for(int i=0;i<versions.length;i++)
			System.out.println(versions[i]);
		System.out.println("===============");
		Arrays.sort(versions);
		for(int i=0;i<versions.length;i++)
			System.out.println(versions[i]);
	}

}
