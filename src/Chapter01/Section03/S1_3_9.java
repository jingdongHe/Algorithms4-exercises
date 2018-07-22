package Chapter01.Section03;

public class S1_3_9 {

	public static void main(String[] args) {
		String inputs="1+2)*3-4)*5-6)))";
		Stack<String> vals=new Stack<String>(20);
		Stack<String> opts=new Stack<String>(20);
		
		for(int i=0;i<inputs.length();i++) {
			String input=inputs.charAt(i)+"";
			if(input.equals(")")) {
				String temp=")";
				temp=vals.pop()+temp;
				temp=opts.pop()+temp;
				temp=vals.pop()+temp;
				temp="("+temp;
				vals.push(temp);
			}else if(input.equals("+")||input.equals("-")||input.equals("*")||input.equals("/")) {
				opts.push(input);
			}else {
				vals.push(input);
			}
		}
		System.out.println(vals.pop());
	}

}
