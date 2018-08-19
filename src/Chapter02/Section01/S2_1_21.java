package Chapter02.Section01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class S2_1_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction[] transactions=new Transaction[4];
		transactions[0]=new Transaction("Number1", new Date(), 100);
		transactions[1]=new Transaction("Number1", new Date(), 1);
		transactions[2]=new Transaction("Number1", new Date(), 10);
		transactions[3]=new Transaction("Number1", new Date(), 1);
		
		for(int i=0;i<transactions.length;i++)
			System.out.println(transactions[i]);
		
		System.out.println("========after sort==========");
		Arrays.sort(transactions);
		for(int i=0;i<transactions.length;i++)
			System.out.println(transactions[i]);
		
	}

}
