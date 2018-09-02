package Chapter03.Section01;

public class S3_1_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings= {"E","A","S","Y","Q","U","E","S","T","I","O","N"};
		ArrayST<String,String> st=new ArrayST<String,String>();
		
		for(String str:strings) {
			st.put(str, "");
		}
		st.print();
		st.smartGet("A");
		st.smartGet("S");
		st.print();
	}

}
