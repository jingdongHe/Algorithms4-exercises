package Chapter03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class S3_1_9 {
	private static void frequencyCounter(int minlen) throws IOException {
		Map<String, Integer> map=new HashMap<String, Integer>();
		File file=new File("src/Chapter03/tale.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String line = null;int beforeCount=0;String LastWord=null,nowWord=null;
		
		while((line=br.readLine())!=null){
		    String str[] = line.split("\\s+");
		    for(String s: str){
		    	if(s.length()<minlen)	continue;
		    	if(!map.containsKey(s))	{
		    		beforeCount=map.size();
		    		LastWord=nowWord;
		    		nowWord=s;
		    		map.put(s, 1);
		    		
		    	}
		    	else	map.put(s, map.get(s)+1);
		    }
		}
		System.out.println(minlen+"=>"+beforeCount+" "+LastWord);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			frequencyCounter(1);
			frequencyCounter(8);
			frequencyCounter(10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
