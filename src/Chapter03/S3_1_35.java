package Chapter03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class S3_1_35 {
	private static long frequencyCounter(int N) throws IOException {
		int minlen = 10;
		SequentialSearchST<String, Integer> map = new SequentialSearchST<String, Integer>();
		File file = new File("src/Chapter03/tale.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;long startTime=System.currentTimeMillis();
		while ((line = br.readLine()) != null) {
			Pattern p = Pattern.compile("[a-zA-Z]+"); 
			Matcher m = p.matcher(line); 
			while (m.find()) {
				String s=m.group();
				if(N--<=0) return System.currentTimeMillis()-startTime;
				if (s.length() < minlen)
					continue;
				if (!map.contains(s))
					map.put(s, 1);
				else
					map.put(s, map.get(s) + 1);
			}
		}
		return System.currentTimeMillis()-startTime;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 《双城记》 无法进行正确的测试
		int N=100000;long currentTime = 0,beforeTime;
		for(int i=0;i<10;i++) {
			beforeTime=currentTime;
			currentTime=frequencyCounter(N);
			System.out.println(beforeTime/currentTime);
			N=N*2;
		}
		
	}

}
