package Chapter02.Section05;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class S2_5_29 {

	private static void fileSorter(String[] args) {
		String filePath=args[0];
		File file = new File(filePath);
		File[] fileList = file.listFiles();
		Arrays.sort(fileList,new Comparator<File>() {

			@Override
			public int compare(File o1, File o2) {
				// TODO Auto-generated method stub
				for(int i=1;i<args.length;i++)
				{
					if(args[i].equals("-t")) {
						if(o1.lastModified()>o2.lastModified()) return 1;
						if(o1.lastModified()<o2.lastModified()) return -1;
					}else if(args[i].equals("-n")) {
						if(o1.getName().compareTo(o2.getName())>0) return 1;
						if(o1.getName().compareTo(o2.getName())>0) return -1;
					}else {
						if(o1.getName().compareTo(o2.getName())>0) return 1;
						if(o1.getName().compareTo(o2.getName())>0) return -1;
					}
				}
				return 0;
			}
		});
		for(int i=0;i<fileList.length;i++)
			System.out.println(fileList[i]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// C:\\Users\\Administrator\\java-workspace\\Algorithms\\src\\Chapter02\\Section05 -t -n
		fileSorter(args);
	}

}
