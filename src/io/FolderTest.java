package io;

import java.io.File;

public class FolderTest {
	public static void main(String[] args) {
		File path = new File("C:\\개발설치파일\\address");
		if(path.isDirectory()) {
			File[] files = path.listFiles();
			for(File file:files) {
				if(!file.isDirectory() && file.getName().indexOf("build_")==0)
				System.out.println(file.getName());
			}
		}
		System.out.println(path.isDirectory());
		System.out.println(path.isFile());
		
	}

}
