import java.io.*;
import java.util.*;
public class dictionary
{
	Word head=null,prev=null,ldown=null;
	class Word{
		String word;
		Word rightWord;
		Word downWord;
		Word(String word)
		{
			this.word=word;
			rightWord=null;
			downWord=null;

		}
	}
	public static void main(String[] args)
	{
		
		dictionary dict=new dictionary();
		dict.initialize(dict);
		String runloop="nonstop";
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			runloop=sc.next();
			if(runloop.equals("stop"))
				break;
			dict.insert(runloop);

		}
		dict.printList();

	}
	void initialize(dictionary dict){
		char myword='A';
		dictionary dic=new dictionary();
		for(int i=0;i<26;i++)
		{	dict.insert(myword+"",i);			
			myword++;
		}

	}
	void insert(String word)
	{
		Word temp=head;
		while(!temp.word.equals(word.charAt(0)+""))
		{
			temp=temp.downWord;
		}
		while(temp.rightWord!=null)
		{
			temp=temp.rightWord;
		}
		Word myword=new Word(word);
		temp.rightWord=myword;
	}
	void insert(String myword,int i)
	{
		Word word=new Word(myword+"");
			if(i==0)
			{
				head=word;
				ldown=head;
			}
			else
			{
				ldown.downWord=word;
				ldown=word;

			}
		
	}
	void printList(){
		Word temp=head;
		while(temp!=null)
		{
			System.out.print(temp.word);
			Word rightside=temp.rightWord;
			int flag=0;
			while(rightside!=null && rightside.rightWord!=null)
			{
				flag=1;
				System.out.print("->"+rightside.word);
				rightside=rightside.rightWord;
			}
			if(rightside!=null && rightside.word!=null)
				System.out.print("->"+rightside.word);
			System.out.println("|");
			temp=temp.downWord;
		}
	}

}