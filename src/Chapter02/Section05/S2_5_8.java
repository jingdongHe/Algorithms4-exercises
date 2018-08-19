package Chapter02.Section05;

import java.util.ArrayList;
import java.util.Arrays;

class Word implements Comparable<Word>{
	
	String word;
	int frequency;
	
	public Word(String word,int frequency) {
		// TODO Auto-generated constructor stub
		this.word=word;
		this.frequency=frequency;
	}

	@Override
	public int compareTo(Word o) {
		// TODO Auto-generated method stub
		if(this.frequency>o.frequency) return -1;
		if(this.frequency<o.frequency) return 1;
		return 0;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("word: %s ; frequency: %d", this.word,this.frequency);
	}
	
}

public class S2_5_8 {

	
	private static void frequency(String[] a) {
		Arrays.sort(a);
		ArrayList<Word> wordList=new ArrayList<>();
		for(int i=0;i<a.length;i++) {
			int start=i;
			while(i+1<a.length&&a[i]==a[i+1]) i++;
			wordList.add(new Word(a[start], i-start+1));
		}
		Word[] words=new Word[wordList.size()];
		int i=0;
		for(Word w:wordList) {
			words[i++]=w;
		}
		Arrays.sort(words);
		for(i=0;i<words.length;i++)
			System.out.println(words[i]);
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a= {"E","A","S","Y","Q","U","E","S","T","I","O","N"};
		frequency(a);
	}

}
