package Chapter03;

import java.util.HashMap;
import java.util.Map;

public class S3_1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Double> map=new HashMap<String,Double>();
		
		map.put("A+", 4.33);
		map.put("A", 4.0);
		map.put("A-", 3.67);
		map.put("B+", 3.33);
		map.put("B", 3.00);
		map.put("B-", 2.67);
		map.put("C+", 2.33);
		map.put("C", 2.0);
		map.put("C-", 1.67);
		map.put("D", 1.0);
		map.put("F", 0.0);
		
		double sum=0;
		for(int i=0;i<args.length;i++)
			sum+=map.get(args[i]);
		System.out.println("Æ½¾ùÖµ£º"+sum/args.length);
	}

}
