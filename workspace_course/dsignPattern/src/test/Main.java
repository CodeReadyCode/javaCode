package test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static Map<String, String> getStringFieldsToMap(Object obj) {

		Map<String, String> map = new HashMap<String, String>();

		for (Field f : obj.getClass().getDeclaredFields()) {
			if (f.getType().equals(String.class)) {
				try {
					f.setAccessible(true);
					map.put(f.getName(), (String) f.get(obj));

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
		return map;

	}

	public static void main(String[] args) {
		String str = new String("yes");
		getStringFieldsToMap(str);
	}

}
