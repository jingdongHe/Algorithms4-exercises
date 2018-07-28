package Chapter01.Section05;
class WeightQuickUnionLink{
	class Node{
		int sz;
		int id;
		Node next,parent;
		public Node(int id) {
			// TODO Auto-generated constructor stub
			this.id=id;sz=1;
			next=null;parent=this;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return id+"";
		}
	}
	Node head,tail;
	int count,length;
	public WeightQuickUnionLink() {
		head=null;tail=null;
		count=0;length=0;
	}
	public void add(Node node) {
		if(head==null&&tail==null)
			head=tail=node;
		else {
			tail.next=node;
			tail=node;
		}
	}
	public void add(int size) {
		for(int i=length;i<length+size;i++) {
			Node node=new Node(i);
			add(node);
		}
		count+=size;length+=size;
	}
	public Node find(Node node) {
		// TODO Auto-generated method stub
		Node point=node;
		while(point.parent!=point)	point=point.parent;
		return point;
	}
	public void union(Node p, Node q) {
		// TODO Auto-generated method stub
		Node pRoot=find(p);
		Node qRoot=find(q);
		if(pRoot!=qRoot) {
			if(pRoot.sz<qRoot.sz) {
				pRoot.parent=qRoot;
				qRoot.sz+=pRoot.sz;
			}else {
				qRoot.parent=pRoot;
				pRoot.sz+=qRoot.sz;
			}
			count--;
		}
	}
	public void union(int p,int q) {
		Node NodeP = null,NodeQ = null;
		Node first=head;
		while(first!=null) {
			if(first.id==p) NodeP=first;
			if(first.id==q) NodeQ=first;
			first=first.next;
		}
		union(NodeP,NodeQ);
	}
	public boolean connected(Node p,Node q) {
		return find(p)==find(q);
	}
	public boolean connected(int p,int q) {
		Node NodeP = null,NodeQ = null;
		Node first=head;
		while(first!=null) {
			if(first.id==p) NodeP=first;
			if(first.id==q) NodeQ=first;
			first=first.next;
		}
		return connected(NodeP,NodeQ);
	}
	public int count() {
		return count;
	}
	public void print() {
		// TODO Auto-generated method stub
		Node first=head;
		while(first!=null) {
			System.out.print(first+"->");
			first=first.next;
		}
		System.out.println();
	}

}
public class S1_5_20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeightQuickUnionLink wqul=new WeightQuickUnionLink();
		wqul.add(3);
		wqul.union(2, 1);
		System.out.println(wqul.connected(2, 1)+";"+wqul.count());
		
		
		wqul.add(7);
		wqul.print();
		
		int[][] link= {
				{9,0},{3,4},{5,8},{7,2},
				{2,1},{5,7},{0,3},{4,2}
		};
		for(int i=0;i<link.length;i++) {
			if(!wqul.connected(link[i][0], link[i][1]))
				wqul.union(link[i][0], link[i][1]);
		}
		System.out.println(wqul.count());
	}

}

