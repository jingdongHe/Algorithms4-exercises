package Chapter01.Section02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class S1_2_15 {
	private static String readString(String filePath) throws IOException {
		String encoding = "UTF-8";  
        File file = new File(filePath);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        FileInputStream in = new FileInputStream(file);  
        in.read(filecontent);  
        in.close();  
        
        return new String(filecontent, encoding);
	}
	private static int[] readInts(String filePath) throws IOException {
		String content=readString(filePath);
		String[] words=content.split("\\s+");
		int[] ints=new int[words.length];
		for(int i=0;i<words.length;i++) {
			ints[i]=Integer.parseInt(words[i]);
		}
		return ints;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath=System.getProperty("user.dir")+"\\src\\Chapter01\\Section02\\S1_2_15_test.txt";
		int[] ints=readInts(filePath);
		for(int i=0;i<ints.length;i++)
			System.out.println(ints[i]);
	}

}
