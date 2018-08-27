package Chapter03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class S3_1_19 {

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
		Queue queue=new LinkedList();
		queue.add("");
		map.put((String) queue.peek(), 0);
		for(String word:map.keySet()) {
			if(map.get(word)>map.get(queue.peek())) {
				System.out.println(map.get(queue.peek()));
				for(Object s:queue) {
					System.out.print(s+",");
				}
				System.out.println("\n===================");
				queue.clear();
				queue.add(word);
			}else if(map.get(word)==map.get(queue.peek())) {
				queue.add(word);
			}
		}
		System.out.println(map.get(queue.peek()));
		while(!queue.isEmpty()) {			
			System.out.print(queue.poll()+",");
		}
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
