package Chapter02.Section05;

import java.io.File;
import java.util.Arrays;

public class S2_5_28 {

	private static void fileSorter(String filePath) {
		File file = new File(filePath);
		File[] fileList = file.listFiles();
		String[] fileNames=new String[fileList.length];
		for(int i=0;i<fileList.length;i++) {
			String[] fileSplit=fileList[i].toString().split("\\\\");
			fileNames[i]=fileSplit[fileSplit.length-1];
		}
		Arrays.sort(fileNames);
		for(int i=0;i<fileNames.length;i++)
			System.out.println(fileNames[i]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="C:\\Users\\Administrator\\java-workspace\\Algorithms\\src\\Chapter02\\Section05";
		fileSorter(filePath);
	}

}
