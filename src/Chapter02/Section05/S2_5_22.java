package Chapter02.Section05;

import java.util.Comparator;
import java.util.PriorityQueue;

class Share{
	double amount;
	int count;
	public Share(double amount, int count) {
		super();
		this.amount = amount;
		this.count = count;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return ((Share)obj).amount==this.amount;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.amount+" "+this.count;
	}
}
public class S2_5_22 {
	private static void matching(PriorityQueue buyer,PriorityQueue seller) {
		while(buyer.peek().equals(seller.peek())) {
			Share buyerShare=(Share) buyer.poll();
			Share sellerShare=(Share) seller.poll();
			
			if(buyerShare.count<sellerShare.count)
			{
				sellerShare.count-=buyerShare.count;
				seller.add(sellerShare);
				System.out.println("sell=>"+buyerShare.amount+" "+buyerShare.count);
			}else if(buyerShare.count>sellerShare.count) {
				buyerShare.count-=sellerShare.count;
				buyer.add(buyerShare);
				System.out.println("sell=>"+sellerShare.amount+" "+sellerShare.count);
			}else {
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Share> buyer=new PriorityQueue<>(new Comparator<Share>() {

			@Override
			public int compare(Share o1, Share o2) {
				// TODO Auto-generated method stub
				if(o1.amount>o2.amount) return -1;
				if(o1.amount<o2.amount) return 1;
				return 0;
			}
		});
		
		PriorityQueue<Share> seller=new PriorityQueue<>(new Comparator<Share>() {

			@Override
			public int compare(Share o1, Share o2) {
				// TODO Auto-generated method stub
				if(o1.amount>o2.amount) return 1;
				if(o1.amount<o2.amount) return -1;
				return 0;
			}
		});
		
		buyer.add(new Share(20, 10));
		buyer.add(new Share(21, 10));
		buyer.add(new Share(22, 2));
		buyer.add(new Share(22, 3));
		
		seller.add(new Share(22, 6));
		seller.add(new Share(23, 6));
		seller.add(new Share(24, 6));
		
		matching(buyer, seller);
	}

}
