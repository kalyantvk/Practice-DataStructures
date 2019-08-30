import java.io.*;
import java.util.*;
class LinkedList
{
	LinkedList(){}
	Node head=null;
	Node prev=null;
	class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
			next=null;
		}
	}
	public static void main(String[] args)
	{
		int runloop=1;
		Scanner sc=new Scanner(System.in);
		LinkedList linkedlist=new LinkedList();
		while(runloop!=-1)
		{
			int data=sc.nextInt();
			if(data==-1)
				break;
			linkedlist.insertAtBegining(data);

		}
		linkedlist.deleteFromList(6);
		linkedlist.printList();
	}
	void insertAtEnding(int data)
	{
		Node node=new Node(data);
		if(head==null)
		{
				head=node;
				prev=head;
		}
		else
		{
				prev.next=node;
				prev=node;
		}

	}
	void insertAtBegining(int data)
	{
		Node node=new Node(data);
		node.next=head;
		head=node;

	}
	void printList()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.println(temp.data+" ");
			temp=temp.next;
		}
	}
	void deleteFromList(int data)
	{
		if(head.data==data){
			head=head.next;
			return;
		}
		Node del=null;
		Node temp=head;
		while(temp!=null && temp.data!=data)
		{
			del=temp;
			temp=temp.next;
		}
		if(temp==null)
		{
			System.out.println("element not found");
			return;
		}
		del.next=temp.next;


	}
	void search(int data)
	{
		Node temp=head;
		int flag=0;
		while(temp!=null)
		{
			if(temp.data==data){
				flag==1;
				break;
			}
			temp=temp.next;

		}
		if(flag==0)
			System.out.println("Not Found");
		else
			System.out.println("Found");
	}
	
}
