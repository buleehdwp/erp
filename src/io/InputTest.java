package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputTest {
	public static void main(String[] args) {
		File f = new File("c:\\read.txt");
		try {
//			FileInputStream fis = new FileInputStream(f);//file로 된걸 inputStream으로 읽어들인것 통로(?) 역할
//			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");//통로에 있는것을 빨아들이는 역할
//			BufferedReader br = new BufferedReader(isr);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			String str = br.readLine();
			Map<String, String> phone = new HashMap<>();
			List<Map<String, String>> pList = new ArrayList();
			while (str != null) {
				String[] strs = str.split(",");
				phone.put("지역", strs[0]);
				phone.put("국번", strs[1]);
				pList.add(phone);
				phone = new HashMap<>();
				str = br.readLine();
			}
			System.out.println(pList);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

