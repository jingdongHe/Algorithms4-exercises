package Chapter01.Section03;

public class S1_3_4 {
	private static boolean isValid(String[] inputs) {
		FixedCapacityStackOfStrings s=new FixedCapacityStackOfStrings(20);
		for(String input:inputs) {
			if(input=="{"||input=="["||input=="(") 
				s.push(input);
			else {
				String popItem=s.pop();
				if(
						(popItem=="("&&input==")")||
						(popItem=="["&&input=="]")||
						(popItem=="{"&&input=="}")
				) {
					
				}else {
					return false;
				}
			}
		}
		return s.isEmpty();
	}

	public static void main(String[] args) {
		
		String[] inputs= {"[","(",")","]","{","}","{","[","(",")","(",")","]","(",")","}"};
		String[] errorInputs= {"[","(","]",")"};
		
		System.out.println(isValid(inputs));
		System.out.println(isValid(errorInputs));
		

	}

}
