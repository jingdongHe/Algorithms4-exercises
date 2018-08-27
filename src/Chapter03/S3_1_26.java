package Chapter03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class S3_1_26 {
	private static void frequencyCounter() throws IOException {
		int minlen = 10;
		Map<String, Integer> map = new HashMap<String, Integer>();
		File file = new File("src/Chapter03/tale.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = br.readLine()) != null) {
			String str[] = line.split("\\s+");
			for (String s : str) {
				if (s.length() < minlen)
					continue;
				if (!map.containsKey(s))
					map.put(s, 1);
				else
					map.put(s, map.get(s) + 1);
			}
		}
		List list = new ArrayList(map.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				if (o1.getKey().compareTo(o2.getKey()) < 0)
					return -1;
				if (o1.getKey().compareTo(o2.getKey()) > 0)
					return 1;
				return 0;
			}
		});
		for (Object mapping : list) {
			System.out.println(mapping);
		}
		System.out.println("============================");
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				if (o1.getValue()<o2.getValue())
					return -1;
				if (o1.getValue()>o2.getValue())
					return 1;
				return 0;
			}
		});
		for (Object mapping : list) {
			System.out.println(mapping);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			frequencyCounter();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
