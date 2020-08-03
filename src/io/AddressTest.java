package io;

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
	// 법정코드, 시도명,
	public static void main(String[] args) throws SQLException {
		String key ="dong_code\r\n" + "sido\r\n" + "sigungu\r\n" + "dong_name\r\n" + "lee_name\r\n" + "is_mnt\r\n"
				+ "jibun_num\r\n" + "sub_jibun_num\r\n" + "road_code\r\n" + "is_base\r\n" + "build_num\r\n"
				+ "sub_build_num\r\n" + "jibun_code";

		String[] keys = key.split("\r\n");
		File path = new File("C:\\java_study_file\\address");
		List<File> fList = new ArrayList<>();
		if (path.isDirectory()) {
			File[] files = path.listFiles();
			for (File file : files) {
				if (!file.isDirectory() && file.getName().indexOf("jibun_") == 0) {
					fList.add(file);
				}
			}
		}
		for (File f : fList) {
			List<Map<String, String>> list = new ArrayList<>();
			String str = ReadText.readText(path + "\\" + f.getName());
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
			System.out.println();
			System.out.println("프로그램 실행");
			long sTime = System.currentTimeMillis();
			String sql = " insert into jibun_address(";
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
			int cnt = 1;
			for (Map<String, String> row : list) {
				for (int i = 0; i < keys.length; i++) {
					ps.setString((i + 1), row.get(keys[i]));
				}
				ps.addBatch();
				if (cnt % 1000 == 0) {
					ps.executeBatch();
					ps.clearBatch();
				}
				cnt++;
			}
			if (list.size() % 1000 != 0) {
				ps.executeBatch();
				ps.clearBatch();
			}
			conn.commit();
			long eTime = System.currentTimeMillis();
			System.out.println("실행시간 : " + (eTime - sTime));
			System.out.println("프로그램 종료");

		}
	}
}
