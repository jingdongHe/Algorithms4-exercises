package Chapter02.Section05;

import java.util.ArrayList;

public class S2_5_2 {

	private static ArrayList<String> findComb(String[] s) {
		ArrayList<String> list=new ArrayList<>();
		for(int i=0;i<s.length;i++) {
			for(int j=i+1;j<s.length;j++) {
				for(int k=0;k<s.length;k++) {
					if(s[k].length()==(s[i].length()+s[j].length())&&(s[k].equals(s[i]+s[j])||s[k].equals(s[j]+s[i])))
						list.add(s[k]);
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"after","thought","afterthought","mooncake","hard","work","hardwork","moon","cake"};
		ArrayList<String> comb=findComb(s);
		for(String c:comb) {
			System.out.println(c);
		}
	}

}
