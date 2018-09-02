package Chapter03.Section01;
class BinarySearchSTInCount<Key,Value> extends BinarySearchST{
	public BinarySearchSTInCount(int capacity) {
		super(capacity);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void put(Comparable key, Object val) {
		// TODO Auto-generated method stub
		super.put(key, val);
		print();
	}
}
public class S3_1_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings= {"E","A","S","Y","Q","U","E","S","T","I","O","N"};
		BinarySearchST<String,String> st=new BinarySearchSTInCount<String,String>(10);
		
		for(String str:strings) {
			st.put(str, "");
		}
	}

}
