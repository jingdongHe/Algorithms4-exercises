package Chapter01.Section03;

public class S1_3_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputs="2+(3+4)*5*6";
		Stack<String> opts=new Stack<String>(10);
		for(int i=0;i<inputs.length();i++) {
			String input=inputs.charAt(i)+"";
			if(input.equals("+")||input.equals("-")||input.equals("*")||input.equals("/"))
				opts.push(input);
			else if(input.equals("("))
				opts.push(input);
			else if(input.equals(")")) {
				String item=null;
				while(!(item=opts.pop()).equals("(")) {
					System.out.print(item);
				}
			}else {
				System.out.print(input);
			}
		}
		while(!opts.isEmpty())
			System.out.print(opts.pop());
	}

}
