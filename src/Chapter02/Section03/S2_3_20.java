package Chapter02.Section03;

import java.util.Stack;

class QuickInStack extends Quick{
	class Node{
		int start,end;
		public Node(int start,int end) {
			// TODO Auto-generated constructor stub
			this.start=start;
			this.end=end;
		}
	}
	void sort(Comparable[] a,int lo,int hi) {
		Stack<Node> stack=new Stack<Node>();
		stack.push(new Node(lo, hi));
		while(!stack.isEmpty()) {
			Node item=stack.pop();
			if(item.start>=item.end) continue;
			int j=partition(a,item.start,item.end);
			stack.push(new Node(item.start, j-1));
			stack.push(new Node(j+1, item.end));
		}
	}
}
public class S2_3_20 {
	public static void main(String[] args) {
		int N=100;
		long startTime;
		Integer[] a=new Integer[N];
		for(int j=0;j<a.length;j++)
			a[j]=j;
		
		Quick quick=new QuickInStack();
		startTime=System.currentTimeMillis();
		quick.sort(a);
		System.out.println("N: "+N+" time: "+(System.currentTimeMillis()-startTime));
		
		for(int j=0;j<a.length;j++)
			System.out.print(a[j]+" ");
	}
}
