package Chapter01.Section03;

public class S1_3_2 {

	public static void main(String[] args) {
		FixedCapacityStackOfStrings s=new FixedCapacityStackOfStrings(20);
		String[] inputs= {"it","was","-","the","best","-","of","times","-","-","-","it","was","-","the","-","-"};
		for(String input:inputs) {
			if(!input.equals("-")) {
				s.push(input);
			}else if(!s.isEmpty()) {
				System.out.print(s.pop()+" ");
			}
		}

	}

}
