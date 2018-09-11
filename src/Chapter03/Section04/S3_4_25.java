package Chapter03.Section04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Transaction {
	String who;
	Date when;
	float amount;
	int hash;

	public Transaction(String who, Date when, float amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
		this.hash = -1;
	}

	public Transaction(String who, String when, float amount) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.who = who;
		this.when = format.parse(when);
		this.amount = amount;
		this.hash = -1;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
		if (that.getWho() == who && that.getAmount() == amount && that.getWhen().equals(when))
			return true;
		return false;

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		if (this.hash != -1)
			return hash;
		System.out.println("calulate hash code");
		int hash = 17;
		hash = 31 * hash + who.hashCode();
		hash = 31 * hash + when.hashCode();
		hash = 31 * hash + ((Float) amount).hashCode();
		this.hash = hash;
		return hash;
	}

}

public class S3_4_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction t=new Transaction("hejd", new Date(), (float) 0.1);
		System.out.println(t.hashCode());
		System.out.println(t.hashCode());
	}

}
