package Chapter02.Section01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction implements Comparable<Transaction>{
	String who;
	Date when;
	private float amount;
	
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