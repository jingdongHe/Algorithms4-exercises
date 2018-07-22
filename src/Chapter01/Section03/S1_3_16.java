package Chapter01.Section03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class S1_3_16 {
	public static Date[] readDates() throws ParseException {
		
		Queue<Date> queue=new Queue<Date>(10);
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		Scanner scan = new Scanner(System.in);
		String read=null;
		while(!(read = scan.nextLine()).equals("")) {
			System.out.println(" ‰»Î ˝æ›£∫"+read); 
			Date date=df.parse(read);
			queue.enqueue(date);
		}
		
		Date[] a=new Date[10];
		int i=0;
		while(!queue.isEmpty()) {
			a[i++]=queue.dequeue();
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Date[] result=readDates();
			for(int i=0;i<result.length;i++)
				System.out.println(result[i]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
