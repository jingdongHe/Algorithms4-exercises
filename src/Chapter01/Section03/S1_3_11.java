package Chapter01.Section03;

public class S1_3_11 {

	public static void main(String[] args) {
		String inputs="234+56**+";
		
		Stack<Integer> values= new Stack<Integer>(10);
		
		for(int i=0;i<inputs.length();i++){
			String input=inputs.charAt(i)+"";
			if(input.equals("+")||input.equals("-")||input.equals("*")||input.equals("/")) {
				int var1=values.pop();
				int var2=values.pop();
				if(input.equals("+")) values.push(var1+var2);
				else if(input.equals("-")) values.push(var2-var1);
				else if(input.equals("*")) values.push(var1*var2);
				else if(input.equals("/")) values.push(var2/var1);
			}else {
				values.push(Integer.parseInt(input));
			}
		}
		System.out.println(values.pop());
	}

}
