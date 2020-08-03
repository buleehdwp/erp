package iotest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderTest {

	public static void main(String[] args) {
		File path = new File("c:\\address\\address");
		File file = null;
		List<String> fList = new ArrayList<>();
		if (path.isDirectory()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				file = files[i];
				if (!file.isDirectory() && file.getName().indexOf("build_") == 0) {
					fList.add(file.getName());
				}
			}

		}
		System.out.print(fList);
//		System.out.println(path+"\\"+file.getName());
//		System.out.println(path.isDirectory());
//		System.out.println(path.isFile());

	}
}
