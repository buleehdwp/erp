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

public class PersonInputTest {
	public static void main(String[] args) {
		File f = new File("c:\\person.txt");
		List<Map<String, String>> pList = new ArrayList<>();
		List<String> kList = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String person = "";
			String str;
			while ((str = br.readLine()) != null) {
				if (kList.size() == 0) {
					String[] keys = str.split(",");
					for (String key : keys) {
						kList.add(key);
					}
				} else {
					Map<String, String> pMap = new HashMap<>();
					String[] values = str.split(",");
					for (int i = 0; i < kList.size(); i++) {
						pMap.put(kList.get(i), values[i]);
						pList.add(pMap);
					}
					

				}
			}
			System.out.println(pList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
