package Chapter02.Section05;

import java.util.Arrays;

class Candidate implements Comparable<Candidate>{
	static final String INITIALS="PWQOJMVAHBSGZXNTCIEKUPDYFL";
	String name;

	public Candidate(String name) {
		super();
		this.name = name;
	}

	@Override
	public int compareTo(Candidate o) {
		// TODO Auto-generated method stub
		int thisIndex=INITIALS.indexOf(this.name.charAt(0));
		int oIndex=INITIALS.indexOf(o.name.charAt(0));
		if(thisIndex>oIndex) return 1;
		if(thisIndex<oIndex) return -1;
		return 0;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}

public class S2_5_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names= {
				"baidu",
				"google",
				"github",
				"princetion",
				"csdn"
		};
		Candidate[] candidates=new Candidate[names.length];
		for(int i=0;i<names.length;i++)
			candidates[i]=new Candidate(names[i].toUpperCase());
		
		Arrays.sort(candidates);
		for(int i=0;i<candidates.length;i++)
			System.out.println(candidates[i]);
	}

}
