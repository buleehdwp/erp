package test;

import java.util.HashMap;
import java.util.Map;

public class ListMapTest {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("1", "1");
		System.out.print(map.get("1"));
	}

}
