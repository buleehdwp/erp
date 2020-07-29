package io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderTest {
	public static void main(String[] args) {
<<<<<<< HEAD
		File path = new File("c:\\address\\address");
=======
		File path = new File("c:\\\\studyfile\\\\address");
		List<File> fList = new ArrayList<>();
>>>>>>> branch 'master' of https://github.com/buleehdwp/erp.git
		if(path.isDirectory()) {
			File[] files = path.listFiles();
			for(File file:files) {
				if(!file.isDirectory() && file.getName().indexOf("build_")==0) {
					fList.add(file);
				}
				
			}
		}
		System.out.println(fList);
//		System.out.println(path.isDirectory());
//		System.out.println(path.isFile());
		
	}

}
