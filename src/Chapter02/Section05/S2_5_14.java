package Chapter02.Section05;

import java.util.Arrays;

class Domain implements Comparable<Domain>{
	String url;

	public Domain(String url) {
		super();
		this.url = url;
	}

	String getReverse(String s) {
		String[] originURL=s.split("\\.");
		String str="";
		for(int i=originURL.length-1;i>=0;i--)
			str=str+originURL[i];
		return str;
	}
	
	@Override
	public int compareTo(Domain o) {
		// TODO Auto-generated method stub
		String originReverseURL=getReverse(o.url);
		String thisReverseURL=getReverse(this.url);
		if(thisReverseURL.compareTo(originReverseURL)>0)
			return 1;
		if(thisReverseURL.compareTo(originReverseURL)<0)
			return -1;
		return 0;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.url;
	}
}

public class S2_5_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] urls= {
				"www.baidu.com",
				"www.google.com",
				"www.github.com",
				"cs.princetion.edu",
				"blog.csdn.cn"
		};
		Domain[] domains=new Domain[urls.length];
		for(int i=0;i<urls.length;i++)
			domains[i]=new Domain(urls[i]);
		
		Arrays.sort(domains);
		for(int i=0;i<domains.length;i++)
			System.out.println(domains[i]);
	}

}
