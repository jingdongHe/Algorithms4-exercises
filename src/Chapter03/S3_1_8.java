package Chapter03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S3_1_8 {
	private static void frequencyCounter() throws IOException {
		int minlen=10;
		Map<String, Integer> map=new HashMap<String, Integer>();
		File file=new File("src/Chapter03/tale.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		while((line=br.readLine())!=null){
		    String str[] = line.split("\\s+");
		    for(String s: str){
		    	if(s.length()<minlen)	continue;
		    	if(!map.containsKey(s))	map.put(s, 1);
		    	else	map.put(s, map.get(s)+1);
		    }
		}
		String max="";
		map.put(max, 0);
		for(String word:map.keySet()) {
			if(map.get(word)>map.get(max))
				max=word;
		}
		System.out.println(max+" "+map.get(max));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			frequencyCounter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
