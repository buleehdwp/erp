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

public class ReadText {
	public static String readText(String path) {
		File f = new File(path);

		FileInputStream fis;
		try {
			fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, "MS949");
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str + "<>");
			}
			return sb.toString();
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

		return null;
	}

	public static List<Map<String, String>> pasce(String str) {
		String[] strs = str.split("\r\n");
		String[] keys = null;
		List<Map<String, String>> list = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			if (i == 0) {
				keys = strs[i].split(",");
			} else {
				String[] values = strs[i].split(",");
				Map<String, String> map = new HashMap<>();
				for (int a = 0; a < keys.length; a++) {
					if (keys.length == values.length) {
						map.put(keys[a], values[a]);
					}
				}
				System.out.println(map);
			}
		}
		return list;
	}
}
