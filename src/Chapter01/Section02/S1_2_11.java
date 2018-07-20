package Chapter01.Section02;

import java.text.ParseException;
import java.text.SimpleDateFormat;

class SmartDate{
	int day,month,year;
	public SmartDate(int day,int month,int year) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			format.setLenient(false);
			format.parse(year+"-"+month+"-"+day);
		}catch (Exception e) {
			throw new ParseException("ÈÕÆÚÓÐÎó",0);
		}
		this.day=day;
		this.month=month;
		this.year=year;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d-%d-%d", year,month,day);
	}
}

public class S1_2_11 {

	public static void main(String[] args) {
		SmartDate date=null;
		try {
			date=new SmartDate(50, 2, 2018);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			date=new SmartDate(1, 1, 2018);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date);
	}

}
