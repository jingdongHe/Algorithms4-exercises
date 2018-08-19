package Chapter02.Section05;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

class Volume implements Comparable<Volume>{
	Date date;
	int amount;
	public Volume(Date date, int amount) {
		super();
		this.date = date;
		this.amount = amount;
	}
	@Override
	public int compareTo(Volume o) {
		// TODO Auto-generated method stub
		if(this.amount>o.amount) return 1;
		if(this.amount<o.amount) return -1;
		if(this.date.compareTo(o.date)>0) return 1;
		if(this.date.compareTo(o.date)<0) return -1;
		return 0;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return date+" "+amount;
	}
}

public class S2_5_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Volume[] volumes=new Volume[10];
		volumes[0]=new Volume(new Date(1928, 10, 1), 3500000);
		volumes[1]=new Volume(new Date(1928, 10, 2), 3850000);
		volumes[2]=new Volume(new Date(1928, 10, 3), 4060000);
		volumes[3]=new Volume(new Date(1928, 10, 4), 4330000);
		volumes[4]=new Volume(new Date(1928, 10, 5), 4360000);
		
		volumes[5]=new Volume(new Date(1999, 11, 30), 554680000);
		volumes[6]=new Volume(new Date(1999, 11, 31), 374049984);
		
		volumes[7]=new Volume(new Date(2000, 1, 3), 931800000);
		volumes[8]=new Volume(new Date(2000, 1, 4), 1009000000);
		volumes[9]=new Volume(new Date(2000, 1, 5), 1085500032);
		
		for(int i=0;i<volumes.length;i++)
			System.out.println(volumes[i]);
		System.out.println("===========");
		Arrays.sort(volumes);
		for(int i=0;i<volumes.length;i++)
			System.out.println(volumes[i]);

	}

}
