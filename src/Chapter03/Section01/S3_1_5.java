package Chapter03.Section01;

public class S3_1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequentialSearchST<String, Integer> st=new SequentialSearchST<String, Integer>();
		
		st.put("3", 1);
		st.put("2", 2);
		st.put("1", 3);
		
		System.out.println(st.size());
		System.out.println(st.get("2"));
		
		for(Object s:st.keys()) {
			System.out.println(s+"=>"+st.get((String) s));
		}
	}

}
