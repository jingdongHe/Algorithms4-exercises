package Chapter03.Section01;

class SequentialSearchSTInCount<Key,Value> extends SequentialSearchST{
	@Override
	public void put(Object key, Object val) {
		// TODO Auto-generated method stub
		super.put(key, val);
		super.print();
	}
}

public class S3_1_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings= {"E","A","S","Y","Q","U","E","S","T","I","O","N"};
		SequentialSearchST<String,String> st=new SequentialSearchSTInCount<String,String>();
		
		for(String str:strings) {
			st.put(str, "");
		}
		
	}

}
