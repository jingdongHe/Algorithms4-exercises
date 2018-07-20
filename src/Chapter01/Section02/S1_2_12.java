package Chapter01.Section02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class SmartDateWeek extends SmartDate{
	public SmartDateWeek(int day, int month, int year) throws ParseException {
		super(day, month, year);
		// TODO Auto-generated constructor stub
	}
	
	public String dayOfTheWeek() throws ParseException {
		SimpleDateFormat parseFormat=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatFormat = new SimpleDateFormat("EEEE");
		
		Date tempDate=parseFormat.parse(year+"-"+month+"-"+day);
		return formatFormat.format(tempDate);
		
	}
}
public class S1_2_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartDateWeek date;
		try {
			date = new SmartDateWeek(1, 9, 2018);
			System.out.println(date.dayOfTheWeek());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
