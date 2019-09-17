import java.util.*;
class Node
{
	int data;
	Node left,right;
	Node(int data){
		this.data=data;
		left=null;
		right=null;

	}

}
class BinaryTree{
	static Node root;
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		while(data!=-1)
		{
			Node newnode=new Node(data);
			if(root==null)
				root=newnode;
			else
			{
				Node temp=root;
				Node prev=null;
				while(temp!=null)
				{
					prev=temp;

					if(temp.data>data)
						temp=temp.left;
					else
						temp=temp.right;
				}
				if(data<=prev.data)
					prev.left=newnode;
				else
					prev.right=newnode;
			}
			data=sc.nextInt();

		}
		printListInorder(root);
		System.out.println();
		printListPreOrder(root);
		System.out.println();
		printListPostOrder(root);
	}
	static void printListInorder(Node node){
		Stack<Node> stack=new Stack<>();
		Node current=root;
		stack.push(current);
		current=current.left;
		while(current!=null){
			stack.push(current);
			current=current.left;
		}
		while(stack.size()!=0)
		{
			Node curr=stack.pop();
			System.out.print(curr.data+"-");			
			current=curr.right;
			while(current!=null)
			{
				stack.push(current);
				current=current.left;
			}
		}
	}
	static void printListPreOrder(Node root){
		/*if(root==null)
			return;
		System.out.print(root.data+"-");
		printListPreOrder(root.left);
		printListPreOrder(root.right);*/
		Stack<Node> stack=new Stack<>();
		Node temp=root;
		while(temp!=null)
		{
			System.out.print(temp.data+"-");
			stack.push(temp);
			temp=temp.left;
		}
		while(stack.size()!=0)
		{
			Node current=stack.pop();
			current=current.right;
			while(current!=null)
			{
				System.out.print(current.data+"-");
				stack.push(current);
				current=current.left;
			}
		}

	}
	static void printListPostOrder(Node root)
	{
		Stack<Node> stack=new Stack<>();
		Stack<Integer> out=new Stack<>();
		stack.push(root);
		while(stack.size()!=0)
		{
			Node curr=stack.pop();
			out.push(curr.data);
			if(curr.left!=null)
				stack.push(curr.left);
			if(curr.right!=null)
				stack.push(curr.right);

		}
		while(out.size()!=0)
			System.out.print(out.pop()+"-");

		// if(root==null)
		// {
		// 	return;
		// }
		// printListPostOrder(root.left);
		// printListPostOrder(root.right);
		// System.out.print(root.data+"-");

	}
}