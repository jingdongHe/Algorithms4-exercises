package Chapter03.Section01;
public class S3_1_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings= {"E","A","S","Y","Q","U","E","S","T","I","O","N"};
		BinarySearchST<String,String> st=new BinarySearchST<String,String>(10);
		
		for(String str:strings) {
			st.put(str, "");
		}
		st.print();
		st.delete("O");
		st.print();
	}

}
