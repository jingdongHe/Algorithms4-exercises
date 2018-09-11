package Chapter03.Section04;
class Date extends java.util.Date{
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
public class S3_4_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// date自带hashcode，此处以重写hashcode为例
		Date date=new Date();
		System.out.println(date.hashCode());
	}

}
