package Chapter01.Section03;

import java.io.File;

public class S1_3_43 {
	public static void getFile(String filePath,int deep) {
		File file = new File(filePath);
		File[] fileList = file.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			String temp="";
			for(int d=0;d<deep;d++) temp+="\t";
			String[] filePathSplit=fileList[i].toString().split("\\\\");
			temp+=filePathSplit[filePathSplit.length-1];
			System.out.println(temp);
			if(fileList[i].isDirectory())
				getFile(fileList[i].toString(),deep+1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "C:\\Users\\Administrator\\java-workspace\\Algorithms\\src";
		getFile(filePath,0);
	}

}
