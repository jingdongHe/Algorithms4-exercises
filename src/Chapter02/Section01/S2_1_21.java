package Chapter02.Section01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


class Transaction implements Comparable<Transaction>{
	String who;
	Date when;
	float amount;
	
	public Transaction(String who, Date when, float amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	public Transaction(String who, String when, float amount) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		this.who = who;
		this.when = format.parse(when);
		this.amount = amount;
	}

	@Override
	public String toString() {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		return "Transaction [who=" + who + ", when=" + format.format(when) + ", amount=" + amount + "]";
	}

	public String getWho() {
		return who;
	}

	public Date getWhen() {
		return when;
	}

	public float getAmount() {
		return amount;
	}
	
	public boolean equal(Transaction that) {
		if(that.getWho()==who&&that.getAmount()==amount&&that.getWhen().equals(when))
			return true;
		return false;
		
	}
	@Override
	public int compareTo(Transaction o) {
		// TODO Auto-generated method stub
		if(this.amount>o.amount)	return 1;
		return -1;
	}
	
}
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
