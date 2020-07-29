package iotest;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Connector;

public class AddressTest {
	public static void main(String[] args) throws SQLException {

		String key = "DONG_CODE\r\n" + "SIDO\r\n" + "GUGUN\r\n" + "DONG_NAME\r\n" + "LEE_NAME\r\n" + "IS_MNT\r\n"
				+ "JIBUN\r\n" + "SUB_JIBUN\r\n" + "ROAD_CODE\r\n" + "ROAD_NAME\r\n" + "IS_BASE\r\n" + "BULID_NUM\r\n"
				+ "SUN_BULID_NUM\r\n" + "BULIDING_NAME\r\n" + "DETAIL_BULIDING_NAME\r\n" + "ADDR_CODE";
		String[] keys = key.split("\r\n");
		File path = new File("c:\\address\\address");
		List<File> fList = new ArrayList<>();
		if (path.isDirectory()) {
			File[] files = path.listFiles();
			for (File file : files) {
				if (!file.isDirectory() && file.getName().indexOf("build_") == 0) {
					fList.add(file);
				}
			}
		}
		System.out.println(fList);
		for (File f : fList) {
			List<Map<String, String>> list = new ArrayList<>();
			String str = ReadText.f(path + "\\" + f.getName());
			String[] strs = str.split("<>");
			String[] values = null;
			for (int i = 0; i < strs.length; i++) {
				Map<String, String> map = new LinkedHashMap<>();
				values = strs[i].split("\\|");
				for (int j = 0; j < keys.length; j++) {
					map.put(keys[j], values[j]);
				}
				list.add(map);
			}
			System.out.println(list);

			System.out.println();
			long sTime = System.currentTimeMillis();
			String sql = " insert into address(";
			String value = " values(";
			for (String Key : keys) {
				sql += Key + ",";
				value += "?,";
			}
			sql = sql.substring(0, sql.length() - 1) + ")\r\n";
			value = value.substring(0, value.length() - 1) + ")";
			sql += value;
			Connection conn = Connector.open();
			PreparedStatement ps = conn.prepareStatement(sql);
			for (Map<String, String> row : list) {
				for (int i = 0; i < keys.length; i++) {
					ps.setNString((i + 1), row.get(keys[i]));
				}
				ps.executeUpdate();
			}
			conn.commit();
			long eTime = System.currentTimeMillis();
			System.out.println("실행시간" + (eTime - sTime));
		}
	}
}
