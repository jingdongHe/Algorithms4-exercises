package Chapter03;

public class S3_1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ST<String,Double> st=new ArrayST<String,Double>();
		st.put("A+", 4.33);
		st.put("A", 4.0);
		st.put("A-", 3.67);
		st.put("B+", 3.33);
		for(String s:st.keys())
			System.out.println(s);
		System.out.println(st.get("A+"));
		st.delete("A");
		for(String s:st.keys())
			System.out.println(s);
	}

}
