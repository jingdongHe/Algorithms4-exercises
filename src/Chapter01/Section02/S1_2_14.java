/**
 * Transaction ÔÚ±í1.2.6ÖÐ
 */
package Chapter01.Section02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Transaction{
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
	
}

public class S1_2_14 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Transaction transaction=new Transaction("hejd", "2018-01-01", 100);
		System.out.println(transaction);
		
		Transaction transaction2=new Transaction("hejd", "2018-02-02", 100);
		System.out.println(transaction.equal(transaction2));
	}

}
