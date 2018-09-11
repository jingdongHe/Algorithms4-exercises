package Chapter03.Section04;

public class S3_4_23 {
	private static int hash(String s) {
		int hash=0;
		for(int i=0;i<s.length();i++)
			hash=(256*hash+s.charAt(i))%255;
		return hash;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"ABC","BAC","CAB","DEFGHI","JKLMNOPQ","RS","TUVW","XYZ"};
		
		for(int i=0;i<s.length;i++)
			System.out.println(s[i]+":"+hash(s[i]));
	}

}
